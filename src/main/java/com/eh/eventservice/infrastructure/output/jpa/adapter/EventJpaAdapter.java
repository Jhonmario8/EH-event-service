package com.eh.eventservice.infrastructure.output.jpa.adapter;

import com.eh.eventservice.domain.model.Event;
import com.eh.eventservice.domain.spi.IEventPersistencePort;
import com.eh.eventservice.infrastructure.output.jpa.mapper.IEventEntityMapper;
import com.eh.eventservice.infrastructure.output.jpa.repository.IEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventJpaAdapter implements IEventPersistencePort {

    private final IEventRepository eventRepository;
    private final IEventEntityMapper mapper;

    @Override
    public Event saveEvent(Event event) {
        return mapper.toDomain(eventRepository.save(mapper.toEntity(event)));
    }
}
