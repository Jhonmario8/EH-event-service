package com.eh.eventservice.application.mapper;

import com.eh.eventservice.application.dto.EventDTO;
import com.eh.eventservice.domain.model.Event;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IEventMapper {

    Event toDomain(EventDTO event);
    EventDTO toDTO(Event event);
}
