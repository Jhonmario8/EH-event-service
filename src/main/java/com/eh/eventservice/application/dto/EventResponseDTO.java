package com.eh.eventservice.application.dto;

import com.eh.eventservice.domain.model.EventStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventResponseDTO {

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
    private String categoryName;
    private Long organizerId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
