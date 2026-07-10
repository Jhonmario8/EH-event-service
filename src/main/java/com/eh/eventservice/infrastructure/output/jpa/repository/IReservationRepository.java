package com.eh.eventservice.infrastructure.output.jpa.repository;

import com.eh.eventservice.infrastructure.output.jpa.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IReservationRepository extends JpaRepository<ReservationEntity, Long> {


    Optional<ReservationEntity> findByClientIdAndEventId(Long clientId, Long eventId);
}
