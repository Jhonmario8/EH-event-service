package com.eh.eventservice.domain.api;

import com.eh.eventservice.domain.model.Reservation;

public interface IReservationServicePort {

    Reservation createReservation(Reservation reservation);

}
