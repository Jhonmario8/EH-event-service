package com.eh.eventservice.infrastructure.output.jpa.mapper;

import com.eh.eventservice.domain.model.Event;
import com.eh.eventservice.infrastructure.output.jpa.entity.EventEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IEventEntityMapper {

    Event toDomain(EventEntity event);

    EventEntity toEntity(Event event);

}
