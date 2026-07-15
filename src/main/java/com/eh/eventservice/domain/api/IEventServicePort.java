package com.eh.eventservice.domain.api;

import com.eh.eventservice.domain.model.Event;
import com.eh.eventservice.domain.model.EventStatus;
import com.eh.eventservice.domain.model.PageModel;

import java.time.LocalDate;
import java.util.Map;

public interface IEventServicePort {
    Event createEvent(Event event);
    Event opneEvent(Long eventId);
    Event updateEvent(Long eventId,Event event);
    PageModel<Event> getEvents(Long categoryId, String city, LocalDate eventDate, EventStatus status, int page, int size);
    Event finalizeEvent(Long eventId);
    Map<String, Object> cancelEvent(Long eventId);
    Map<String, Object> getEventById(Long eventId);
}
