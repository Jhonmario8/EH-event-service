package com.eh.eventservice.application.handler;


import com.eh.eventservice.application.dto.EventCancelledDTO;
import com.eh.eventservice.application.dto.EventDTO;
import com.eh.eventservice.application.dto.EventResponseDTO;
import com.eh.eventservice.application.dto.PageResponseDTO;
import com.eh.eventservice.domain.model.EventStatus;

import java.time.LocalDate;

public interface IEventHandler {
    EventResponseDTO createEvent(EventDTO eventDTO);
    EventResponseDTO openEvent(Long eventId);
    EventResponseDTO updateEvent(Long eventId, EventDTO eventDTO);
    PageResponseDTO<EventResponseDTO> getEvents(Long categoryId, String city, LocalDate eventDate, EventStatus status, int page, int size);
    EventResponseDTO finalizeEvent(Long eventId);
    EventCancelledDTO cancelEvent(Long eventId);
}
