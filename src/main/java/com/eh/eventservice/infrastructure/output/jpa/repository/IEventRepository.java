package com.eh.eventservice.infrastructure.output.jpa.repository;

import com.eh.eventservice.domain.model.EventStatus;
import com.eh.eventservice.infrastructure.output.jpa.entity.EventEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IEventRepository extends JpaRepository<EventEntity, Long>, JpaSpecificationExecutor<EventEntity> {

    @Query("""
            SELECT e
            FROM EventEntity e
            WHERE (:categoryId IS NULL OR e.categoryId = :categoryId)
            AND (:city IS NULL OR LOWER(e.city) LIKE LOWER(CONCAT('%', :city, '%')))
            AND (:eventDate IS NULL OR e.eventDate = :eventDate)
            AND (:status IS NULL OR e.status = :status)
            """)
    Page<EventEntity> findEvents(
            @Param("categoryId") Long categoryId,
            @Param("city") String city,
            @Param("eventDate") LocalDate eventDate,
            @Param("status") EventStatus status,
            Pageable pageable
    );

    List<EventEntity> findByIdIn(List<Long> eventIds);

}
