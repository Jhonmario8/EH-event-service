package com.eh.eventservice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventCancelledDTO {

    private EventResponseDTO event;
    private Integer cancelledReservationsCount;

}
