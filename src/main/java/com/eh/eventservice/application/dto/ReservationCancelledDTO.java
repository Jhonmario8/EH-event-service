package com.eh.eventservice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservationCancelledDTO {

    private String message;
    private ReservationResponseDTO responseDTO;

}
