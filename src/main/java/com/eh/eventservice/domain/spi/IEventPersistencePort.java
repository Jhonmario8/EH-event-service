package com.eh.eventservice.domain.spi;

import com.eh.eventservice.domain.model.Event;
import com.eh.eventservice.domain.model.EventStatus;
import com.eh.eventservice.domain.model.PageModel;


import java.time.LocalDate;
import java.util.Optional;

public interface IEventPersistencePort {
    Event saveEvent(Event event);
    Optional<Event> findById(Long eventId);
    PageModel<Event> findEvents(Long categoryId, String city, LocalDate eventDate, EventStatus status, int page, int size);
}
