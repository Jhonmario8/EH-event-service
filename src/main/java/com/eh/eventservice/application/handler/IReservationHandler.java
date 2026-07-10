package com.eh.eventservice.application.handler;

import com.eh.eventservice.application.dto.ReservationCancelledDTO;
import com.eh.eventservice.application.dto.ReservationDTO;
import com.eh.eventservice.application.dto.ReservationResponseDTO;

public interface IReservationHandler {

    ReservationResponseDTO createReservation(ReservationDTO reservationDTO);
    ReservationCancelledDTO cancelReservation(Long reservationId);
}
