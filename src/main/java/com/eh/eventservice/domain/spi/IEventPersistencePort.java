package com.eh.eventservice.domain.spi;

import com.eh.eventservice.domain.model.Event;


import java.util.Optional;

public interface IEventPersistencePort {
    Event saveEvent(Event event);
    Optional<Event> findById(Long eventId);
}
