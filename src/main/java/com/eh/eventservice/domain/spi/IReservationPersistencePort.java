package com.eh.eventservice.domain.spi;

import com.eh.eventservice.domain.model.Reservation;

import java.util.Optional;

public interface IReservationPersistencePort {

    Reservation saveReservation(Reservation reservation);
    Optional<Reservation> findByClientIdAndEventId(Long clientId, Long eventId);
    Optional<Reservation> findById(Long id);

}
