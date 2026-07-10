package com.eh.eventservice.application.mapper;

import com.eh.eventservice.application.dto.ReservationDTO;
import com.eh.eventservice.application.dto.ReservationResponseDTO;
import com.eh.eventservice.domain.model.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IReservationMapper {

    Reservation toDomain(ReservationDTO reservationDTO);

    ReservationResponseDTO toDto(Reservation reservation);
}
