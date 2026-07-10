package com.eh.eventservice.application.handler;

import com.eh.eventservice.application.dto.ReservationDTO;
import com.eh.eventservice.application.dto.ReservationResponseDTO;
import com.eh.eventservice.application.mapper.IReservationMapper;
import com.eh.eventservice.domain.api.IReservationServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationHandler implements IReservationHandler {

    private final IReservationServicePort reservationServicePort;
    private final IReservationMapper mapper;


    @Override
    public ReservationResponseDTO createReservation(ReservationDTO reservationDTO) {
        return mapper.toDto(reservationServicePort.createReservation(mapper.toDomain(reservationDTO))) ;
    }
}
