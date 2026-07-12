package com.eh.eventservice.domain.usecase;

import com.eh.eventservice.domain.api.IAuthenticationServicePort;
import com.eh.eventservice.domain.api.IReservationServicePort;
import com.eh.eventservice.domain.constants.DomainConstants;
import com.eh.eventservice.domain.exception.ConflictException;
import com.eh.eventservice.domain.exception.ForbiddenException;
import com.eh.eventservice.domain.exception.NotFoundException;
import com.eh.eventservice.domain.model.*;
import com.eh.eventservice.domain.spi.IEventPersistencePort;
import com.eh.eventservice.domain.spi.IReservationPersistencePort;
import com.eh.eventservice.domain.spi.IUserServicePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;

@RequiredArgsConstructor
public class ReservationService implements IReservationServicePort {

    private final IReservationPersistencePort reservationPersistencePort;
    private final IEventPersistencePort eventPersistencePort;
    private final IAuthenticationServicePort authenticationServicePort;
    private final IUserServicePort userServicePort;

    @Override
    @Transactional
    public Reservation createReservation(Reservation reservation) {
        validateRole(Role.CLIENT, DomainConstants.MSG_ONLY_CLIENT_CAN_CREATE_RESERVATION);
        Long clientId = authenticationServicePort.getCurrentUserId();
        User user = userServicePort.findUserById(clientId);
        reservation.setClientId(clientId);
        reservation.setClientEmail(user.getEmail());
        Event event = eventPersistencePort.findById(reservation.getEventId())
                .orElseThrow(() -> new NotFoundException(DomainConstants.MSG_EVENT_NOT_FOUND));
        if (!event.getStatus().equals(EventStatus.OPEN)){
            throw new ForbiddenException(DomainConstants.MSG_EVENT_NOT_OPEN);
        }

        reservationPersistencePort.findByClientIdAndEventId(clientId, reservation.getEventId())
                .ifPresent(r -> {
                    throw new ConflictException(DomainConstants.MSG_RESERVATION_ALREADY_EXISTS);
                });
        if (reservation.getQuantity() <= 0 || reservation.getQuantity() > 6){
            throw new ForbiddenException(DomainConstants.MSG_RESERVATION_QUANTITY_INVALID);
        }

        if (event.getAvailableTickets() < reservation.getQuantity()){
            throw new ForbiddenException(DomainConstants.MSG_NOT_ENOUGH_TICKETS_AVAILABLE);
        }
        reservation.setStatus(ReservationStatus.ACTIVE);
        reservation.setReservedAt(LocalDateTime.now());
        Reservation savedReservation = reservationPersistencePort.saveReservation(reservation);
        event.setAvailableTickets(event.getAvailableTickets() - reservation.getQuantity());
        if (event.getAvailableTickets() == 0){
            event.setStatus(EventStatus.SOLD_OUT);
        }
        eventPersistencePort.saveEvent(event);
        return savedReservation;
    }

    @Override
    @Transactional
    public Map<String, Object> cancelReservation(Long reservationId) {
        validateRole(Role.CLIENT, DomainConstants.MSG_ONLY_CLIENT_CAN_CANCEL_RESERVATION);
        Long clientId = authenticationServicePort.getCurrentUserId();
        Reservation reservation = reservationPersistencePort.findById(reservationId)
                .orElseThrow(() -> new NotFoundException(DomainConstants.MSG_RESERVATION_NOT_FOUND));
        if (!reservation.getClientId().equals(clientId)){
            throw new ForbiddenException(DomainConstants.MSG_CANNOT_CANCEL_OTHER_CLIENT_RESERVATION);
        }
        if (!reservation.getStatus().equals(ReservationStatus.ACTIVE)){
            throw new ConflictException(DomainConstants.MSG_RESERVATION_ALREADY_CANCELLED);
        }
        Event event = eventPersistencePort.findById(reservation.getEventId())
                .orElseThrow(() -> new NotFoundException(DomainConstants.MSG_EVENT_NOT_FOUND));

        LocalDateTime eventDateTime = LocalDateTime.of(
                event.getEventDate(),
                event.getStartTime()
        );

        long hours = ChronoUnit.HOURS.between(LocalDateTime.now(), eventDateTime);

        if (hours < 24) {
            throw new ConflictException(DomainConstants.MSG_CANNOT_CANCEL_RESERVATION_WITHIN_24_HOURS);
        }
        reservation.setStatus(ReservationStatus.CANCELLED);
        reservation.setCanceledAt(LocalDateTime.now());
        event.setAvailableTickets(event.getAvailableTickets() + reservation.getQuantity());
        if (event.getStatus().equals(EventStatus.SOLD_OUT)){
            event.setStatus(EventStatus.OPEN);
        }
        reservationPersistencePort.saveReservation(reservation);
        eventPersistencePort.saveEvent(event);
        return Map.of(
                "message", DomainConstants.MSG_RESERVATION_CANCELLED_SUCCESSFULLY,
                "reservation", reservation
        );
    }

    private void validateRole(Role requiredRole, String errorMessage) {
        Role currentUserRole = authenticationServicePort.getCurrentUserRole();
        if (currentUserRole != requiredRole) {
            throw new ForbiddenException(errorMessage);
        }
    }
}
