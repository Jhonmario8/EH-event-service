package com.eh.eventservice.domain.spi;

import com.eh.eventservice.domain.model.Event;

public interface IEventPersistencePort {
    Event saveEvent(Event event);
}
