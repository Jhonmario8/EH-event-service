package com.eh.eventservice.domain.api;

import com.eh.eventservice.domain.model.Event;

public interface IEventServicePort {
    Event createEvent(Event event);
    Event opneEvent(Long eventId);
    Event updateEvent(Long eventId,Event event);
}
