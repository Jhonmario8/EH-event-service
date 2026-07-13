package com.eh.eventservice.infrastructure.output.jpa.adapter;

import com.eh.eventservice.domain.model.Event;
import com.eh.eventservice.domain.model.EventStatus;
import com.eh.eventservice.domain.model.PageModel;
import com.eh.eventservice.domain.spi.IEventPersistencePort;
import com.eh.eventservice.infrastructure.output.jpa.mapper.IEventEntityMapper;
import com.eh.eventservice.infrastructure.output.jpa.repository.IEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventJpaAdapter implements IEventPersistencePort {

    private final IEventRepository eventRepository;
    private final IEventEntityMapper mapper;

    @Override
    public Event saveEvent(Event event) {
        return mapper.toDomain(eventRepository.save(mapper.toEntity(event)));
    }

    @Override
    public Optional<Event> findById(Long eventId) {
        return eventRepository.findById(eventId).map(mapper::toDomain);
    }

    @Override
    public PageModel<Event> findEvents(Long categoryId, String city, LocalDate eventDate,
                                       EventStatus status, int page, int size) {

        var result = eventRepository.findEvents(
                categoryId,
                city,
                eventDate,
                status,
                PageRequest.of(page, size)
        );

        return mapper.toPageModel(result);
    }

    @Override
    public List<Event> findByIds(List<Long> eventIds) {
        return eventRepository.findByIdIn(eventIds).stream().map(mapper::toDomain).toList();
    }


}
