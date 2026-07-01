package com.eh.eventservice.infrastructure.output.jpa.repository;

import com.eh.eventservice.infrastructure.output.jpa.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEventRepository extends JpaRepository<EventEntity, Long> {
}
