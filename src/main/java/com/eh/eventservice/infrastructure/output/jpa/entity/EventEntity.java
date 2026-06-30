package com.eh.eventservice.infrastructure.output.jpa.entity;

import com.eh.eventservice.domain.model.EventStatus;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "events")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Column(name = "event_date")
    private LocalDate eventDate;
    @Column(name = "start_time")
    private LocalTime startTime;
    @Column(name = "end_time")
    private LocalTime endTime;
    private String city;
    private String address;
    private Integer capacity;
    @Column(name = "available_tickets")
    private Integer availableTickets;
    private Double price;
    private EventStatus status;
    @Column(name = "category_id")
    private Long categoryId;
    @Column(name = "organizer_id")
    private Long organizerId;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Nullable
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
