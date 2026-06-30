package com.eh.eventservice.infrastructure.output.jpa.entity;

import com.eh.eventservice.domain.model.ReservationStatus;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "event_id")
    private Long eventId;
    @Column(name = "client_id")
    private Long clientId;
    @Column(name = "client_email")
    private String clientEmail;
    private Integer quantity;
    private ReservationStatus status;
    @Column(name = "reserved_at")
    private LocalDateTime reservedAt;
    @Column(name = "canceled_at")
    @Nullable
    private LocalDateTime canceledAt;
}
