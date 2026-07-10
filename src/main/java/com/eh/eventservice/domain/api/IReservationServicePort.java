package com.eh.eventservice.domain.api;

import com.eh.eventservice.domain.model.Reservation;

import java.util.Map;


public interface IReservationServicePort {

    Reservation createReservation(Reservation reservation);
    Map<String, Object> cancelReservation(Long reservationId);

}
