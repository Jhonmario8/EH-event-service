package com.eh.eventservice.domain.spi;

import com.eh.eventservice.domain.model.PageModel;
import com.eh.eventservice.domain.model.Reservation;
import com.eh.eventservice.domain.model.ReservationStatus;


import java.util.List;
import java.util.Optional;

public interface IReservationPersistencePort {

    Reservation saveReservation(Reservation reservation);
    Optional<Reservation> findByClientIdAndEventId(Long clientId, Long eventId);
    Optional<Reservation> findById(Long id);
    List<Reservation> findByEventIdAndStatus(Long eventId, ReservationStatus status);
    PageModel<Reservation> findByClientId(Long clientId, int page, int size);

}
