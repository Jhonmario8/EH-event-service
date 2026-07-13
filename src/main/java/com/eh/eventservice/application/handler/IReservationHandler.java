package com.eh.eventservice.application.handler;

import com.eh.eventservice.application.dto.*;

public interface IReservationHandler {

    ReservationResponseDTO createReservation(ReservationDTO reservationDTO);
    ReservationCancelledDTO cancelReservation(Long reservationId);
    PageResponseDTO<MyReservationResponseDTO> getReservationsByClientId(int page, int size);
}
