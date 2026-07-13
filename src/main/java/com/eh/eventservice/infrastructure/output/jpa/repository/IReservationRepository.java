package com.eh.eventservice.infrastructure.output.jpa.repository;

import com.eh.eventservice.domain.model.ReservationStatus;
import com.eh.eventservice.infrastructure.output.jpa.entity.ReservationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IReservationRepository extends JpaRepository<ReservationEntity, Long> {


    Optional<ReservationEntity> findByClientIdAndEventId(Long clientId, Long eventId);
    List<ReservationEntity> findByEventIdAndStatus(Long eventId, ReservationStatus status);
    Page<ReservationEntity> findByClientId(Long clientId, Pageable pageable);
}
