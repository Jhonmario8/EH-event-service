package com.eh.eventservice.application.handler;

import com.eh.eventservice.application.dto.EventDTO;
import com.eh.eventservice.application.dto.EventResponseDTO;
import com.eh.eventservice.application.mapper.IEventMapper;
import com.eh.eventservice.domain.api.IEventServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

}
