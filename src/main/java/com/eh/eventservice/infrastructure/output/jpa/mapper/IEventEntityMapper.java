package com.eh.eventservice.infrastructure.output.jpa.mapper;

import com.eh.eventservice.domain.model.Event;
import com.eh.eventservice.domain.model.PageModel;
import com.eh.eventservice.infrastructure.output.jpa.entity.EventEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.data.domain.Page;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IEventEntityMapper {

    Event toDomain(EventEntity event);

    EventEntity toEntity(Event event);

    @Mapping(target = "content", source = "content")
    @Mapping(target = "pageNumber", source = "number")
    @Mapping(target = "pageSize", source = "size")
    @Mapping(target = "totalElements", source = "totalElements")
    @Mapping(target = "totalPages", source = "totalPages")
    PageModel<Event> toPageModel(Page<EventEntity> pageResult);
}
