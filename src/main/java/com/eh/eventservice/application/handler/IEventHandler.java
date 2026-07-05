package com.eh.eventservice.application.handler;


import com.eh.eventservice.application.dto.EventDTO;
import com.eh.eventservice.application.dto.EventResponseDTO;

public interface IEventHandler {
    EventResponseDTO createEvent(EventDTO eventDTO);
    EventResponseDTO openEvent(Long eventId);
    EventResponseDTO updateEvent(Long eventId, EventDTO eventDTO);
}
