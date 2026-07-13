package com.eh.eventservice.domain.api;

import com.eh.eventservice.domain.model.MyReservationResponse;
import com.eh.eventservice.domain.model.PageModel;
import com.eh.eventservice.domain.model.Reservation;

import java.util.Map;


public interface IReservationServicePort {

    Reservation createReservation(Reservation reservation);
    Map<String, Object> cancelReservation(Long reservationId);
    PageModel<MyReservationResponse> getReservationsByClientId(int page, int size);
}
