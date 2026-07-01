package com.eh.eventservice.domain.usecase;

import com.eh.eventservice.domain.api.IAuthenticationServicePort;
import com.eh.eventservice.domain.api.IEventServicePort;
import com.eh.eventservice.domain.constants.DomainConstants;
import com.eh.eventservice.domain.exception.DomainException;
import com.eh.eventservice.domain.exception.ForbiddenException;
import com.eh.eventservice.domain.model.Event;
import com.eh.eventservice.domain.model.Role;
import com.eh.eventservice.domain.spi.ICategoryPersistencePort;
import com.eh.eventservice.domain.spi.IEventPersistencePort;
import lombok.RequiredArgsConstructor;


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

    private void validateRole(Role requiredRole, String errorMessage) {
        Role currentUserRole = authenticationServicePort.getCurrentUserRole();
        if (currentUserRole != requiredRole) {
            throw new ForbiddenException(errorMessage);
        }
    }
}
