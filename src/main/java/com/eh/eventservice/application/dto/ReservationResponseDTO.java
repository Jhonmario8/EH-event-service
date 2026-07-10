package com.eh.eventservice.application.dto;

import com.eh.eventservice.domain.model.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponseDTO {

    private Long id;
    private Long eventId;
    private Long clientId;
    private String clientEmail;
    private Integer quantity;
    private ReservationStatus status;
    private LocalDateTime reservedAt;
    private LocalDateTime canceledAt;

}
