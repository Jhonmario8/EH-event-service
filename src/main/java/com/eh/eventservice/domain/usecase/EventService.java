package com.eh.eventservice.domain.usecase;

import com.eh.eventservice.domain.api.IAuthenticationServicePort;
import com.eh.eventservice.domain.api.IEventServicePort;
import com.eh.eventservice.domain.constants.DomainConstants;
import com.eh.eventservice.domain.exception.ConflictException;
import com.eh.eventservice.domain.exception.DomainException;
import com.eh.eventservice.domain.exception.ForbiddenException;
import com.eh.eventservice.domain.exception.NotFoundException;
import com.eh.eventservice.domain.model.Event;
import com.eh.eventservice.domain.model.EventStatus;
import com.eh.eventservice.domain.model.Role;
import com.eh.eventservice.domain.spi.ICategoryPersistencePort;
import com.eh.eventservice.domain.spi.IEventPersistencePort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;


@RequiredArgsConstructor
public class EventService implements IEventServicePort {

    private final IEventPersistencePort eventPersistencePort;
    private final IAuthenticationServicePort authenticationServicePort;
    private final ICategoryPersistencePort categoryPersistencePort;

    @Override
    public Event createEvent(Event event) {
        validateRole(Role.ORGANIZER, DomainConstants.MSG_ONLY_ORGANIZER_CAN_CREATE_EVENT);
        categoryPersistencePort.findByIdAndActive(event.getCategoryId()).orElseThrow(() -> new DomainException(DomainConstants.MSG_CATEGORY_NOT_FOUND));
        if (event.getEventDate().isBefore(event.getCreatedAt().toLocalDate())) {
            throw new DomainException(DomainConstants.MSG_EVENT_DATE_CANNOT_BE_BEFORE_CREATION_DATE);
        }
        if (!event.getEndTime().isAfter(event.getStartTime())){
            throw new DomainException(DomainConstants.MSG_EVENT_END_TIME_MUST_BE_AFTER_START_TIME);
        }
        event.setAvailableTickets(event.getCapacity());
        event.setOrganizerId(authenticationServicePort.getCurrentUserId());
        return eventPersistencePort.saveEvent(event);
    }

    @Override
    public Event opneEvent(Long eventId) {
         validateRole(Role.ADMIN, DomainConstants.MSG_ONLY_ADMIN_CAN_OPEN_EVENT);
        Event event = eventPersistencePort.findById(eventId)
                .orElseThrow(() -> new NotFoundException(DomainConstants.MSG_EVENT_NOT_FOUND));
        if (event.getStatus() != EventStatus.CREATED) {
            throw new ConflictException(DomainConstants.MSG_ONLY_CREATED_EVENT_CAN_BE_OPENED);
        }
        event.setStatus(EventStatus.OPEN);
        return eventPersistencePort.saveEvent(event);
    }

    @Override
    public Event updateEvent(Long eventId,Event event) {
        validateRole(Role.ORGANIZER, DomainConstants.MSG_ONLY_ORGANIZER_CAN_UPDATE_EVENT);
        Event existingEvent = eventPersistencePort.findById(eventId)
                .orElseThrow(() -> new NotFoundException(DomainConstants.MSG_EVENT_NOT_FOUND));
        if (!Objects.equals(existingEvent.getOrganizerId(), authenticationServicePort.getCurrentUserId())) {
            throw new ForbiddenException(DomainConstants.MSG_ONLY_ORGANIZER_CAN_UPDATE_OWN_EVENT);
        }
        if (existingEvent.getStatus() == EventStatus.FINISHED || existingEvent.getStatus() == EventStatus.CANCELLED) {
            throw new ConflictException(DomainConstants.MSG_ONLY_CREATED_OR_OPEN_EVENT_CAN_BE_UPDATED);
        }
        Integer reserves = existingEvent.getCapacity() - existingEvent.getAvailableTickets();
        if (event.getCapacity() < reserves) {
            throw new ConflictException(DomainConstants.MSG_EVENT_CAPACITY_CANNOT_BE_LESS_THAN_BOOKED_TICKETS);
        }
        existingEvent.setName(event.getName());
        existingEvent.setDescription(event.getDescription());
        existingEvent.setEventDate(event.getEventDate());
        existingEvent.setStartTime(event.getStartTime());
        existingEvent.setEndTime(event.getEndTime());
        existingEvent.setCity(event.getCity());
        existingEvent.setAddress(event.getAddress());
        existingEvent.setCapacity(event.getCapacity());
        existingEvent.setAvailableTickets(event.getCapacity() - reserves);
        existingEvent.setPrice(event.getPrice());
        existingEvent.setCategoryId(event.getCategoryId());
        existingEvent.setUpdatedAt(LocalDateTime.now());
        return eventPersistencePort.saveEvent(existingEvent);
    }

    private void validateRole(Role requiredRole, String errorMessage) {
        Role currentUserRole = authenticationServicePort.getCurrentUserRole();
        if (currentUserRole != requiredRole) {
            throw new ForbiddenException(errorMessage);
        }
    }
}
