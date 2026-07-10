package com.eh.eventservice.infrastructure.output.jpa.mapper;

import com.eh.eventservice.domain.model.Reservation;
import com.eh.eventservice.infrastructure.output.jpa.entity.ReservationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IReservationEntityMapper {

    ReservationEntity toEntity(Reservation reservation);

    Reservation toDomain(ReservationEntity reservationEntity);

}
