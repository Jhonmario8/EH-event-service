package com.eh.eventservice.infrastructure.output.jpa.mapper;

import com.eh.eventservice.domain.model.PageModel;
import com.eh.eventservice.domain.model.Reservation;
import com.eh.eventservice.infrastructure.output.jpa.entity.ReservationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.data.domain.Page;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IReservationEntityMapper {

    ReservationEntity toEntity(Reservation reservation);

    Reservation toDomain(ReservationEntity reservationEntity);

    @Mapping(target = "content", source = "content")
    @Mapping(target = "pageNumber", source = "number")
    @Mapping(target = "pageSize", source = "size")
    @Mapping(target = "totalElements", source = "totalElements")
    @Mapping(target = "totalPages", source = "totalPages")
    PageModel<Reservation> toPageModel(Page<ReservationEntity> pageResult);

}
