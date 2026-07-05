package com.eh.eventservice.application.handler;

import com.eh.eventservice.application.dto.EventDTO;
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
    public EventDTO createEvent(EventDTO eventDTO) {
        return mapper.toDTO(eventServicePort.createEvent(mapper.toDomain(eventDTO)));
    }

    @Override
    public EventDTO openEvent(Long eventId) {
        return mapper.toDTO(eventServicePort.opneEvent(eventId));
    }

}
