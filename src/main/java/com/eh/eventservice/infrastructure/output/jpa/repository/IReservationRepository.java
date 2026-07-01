package com.eh.eventservice.infrastructure.output.jpa.repository;

import com.eh.eventservice.infrastructure.output.jpa.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservationRepository extends JpaRepository<ReservationEntity, Long> {
}
