package com.eh.eventservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reservation {

    private Long id;
    private Long eventId;
    private Long clientId;
    private String clientEmail;
    private Integer quantity;
    private ReservationStatus status=ReservationStatus.ACTIVE;
    private LocalDateTime reservedAt=LocalDateTime.now();
    private LocalDateTime canceledAt;
}
