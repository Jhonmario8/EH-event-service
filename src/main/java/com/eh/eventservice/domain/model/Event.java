package com.eh.eventservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Event {


    private Long id;
    private String name;
    private String description;
    private LocalDate eventDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String city;
    private String address;
    private Integer capacity;
    private Integer availableTickets;
    private Double price;
    private EventStatus status;
    private Long categoryId;
    private Long organizerId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
