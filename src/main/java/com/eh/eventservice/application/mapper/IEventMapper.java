package com.eh.eventservice.application.mapper;


import com.eh.eventservice.application.dto.EventDTO;
import com.eh.eventservice.application.dto.EventResponseDTO;
import com.eh.eventservice.application.dto.PageResponseDTO;
import com.eh.eventservice.domain.model.Event;
import com.eh.eventservice.domain.model.PageModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IEventMapper {

    Event toDomain(EventDTO event);

    EventResponseDTO toResponseDTO(Event event);

    PageResponseDTO<EventResponseDTO> toPageResponseDTO(PageModel<Event> pageModel);
}
