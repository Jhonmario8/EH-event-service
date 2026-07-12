package com.eh.eventservice.application.handler;

import com.eh.eventservice.application.dto.EventCancelledDTO;
import com.eh.eventservice.application.dto.EventDTO;
import com.eh.eventservice.application.dto.EventResponseDTO;
import com.eh.eventservice.application.dto.PageResponseDTO;
import com.eh.eventservice.application.mapper.IEventMapper;
import com.eh.eventservice.domain.api.IEventServicePort;
import com.eh.eventservice.domain.model.Event;
import com.eh.eventservice.domain.model.EventStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EventHandler implements IEventHandler{

    private final IEventServicePort eventServicePort;
    private final IEventMapper mapper;

    @Override
    public EventResponseDTO createEvent(EventDTO eventDTO) {
        return mapper.toResponseDTO(eventServicePort.createEvent(mapper.toDomain(eventDTO)));
    }

    @Override
    public EventResponseDTO openEvent(Long eventId) {
        return mapper.toResponseDTO(eventServicePort.opneEvent(eventId));
    }

    @Override
    public EventResponseDTO updateEvent(Long eventId, EventDTO eventDTO) {
        return mapper.toResponseDTO(eventServicePort.updateEvent(eventId, mapper.toDomain(eventDTO)));
    }

    @Override
    public PageResponseDTO<EventResponseDTO> getEvents(Long categoryId, String city, LocalDate eventDate, EventStatus status, int page, int size) {
        return mapper.toPageResponseDTO(eventServicePort.getEvents(categoryId, city, eventDate, status, page, size));
    }

    @Override
    public EventResponseDTO finalizeEvent(Long eventId) {
        return mapper.toResponseDTO(eventServicePort.finalizeEvent(eventId));
    }

    @Override
    public EventCancelledDTO cancelEvent(Long eventId) {

        Map<String, Object> cancelledDTO = eventServicePort.cancelEvent(eventId);

        EventCancelledDTO eventCancelledDTO = new EventCancelledDTO();
        eventCancelledDTO.setEvent(mapper.toResponseDTO((Event)  cancelledDTO.get("event")));
        eventCancelledDTO.setCancelledReservationsCount((Integer) cancelledDTO.get("cancelledReservations"));
        return eventCancelledDTO;
    }

}
