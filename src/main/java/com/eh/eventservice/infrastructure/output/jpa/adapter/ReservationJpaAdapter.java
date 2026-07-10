package com.eh.eventservice.infrastructure.output.jpa.adapter;

import com.eh.eventservice.domain.model.Reservation;
import com.eh.eventservice.domain.spi.IReservationPersistencePort;
import com.eh.eventservice.infrastructure.output.jpa.mapper.IReservationEntityMapper;
import com.eh.eventservice.infrastructure.output.jpa.repository.IReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationJpaAdapter implements IReservationPersistencePort {

    private final IReservationRepository repository;
    private final IReservationEntityMapper mapper;

    @Override
    public Reservation saveReservation(Reservation reservation) {
        return mapper.toDomain(repository.save(mapper.toEntity(reservation)));
    }

    @Override
    public Optional<Reservation> findByClientIdAndEventId(Long clientId, Long eventId) {
        return repository.findByClientIdAndEventId(clientId,eventId).map(mapper::toDomain);
    }
}
