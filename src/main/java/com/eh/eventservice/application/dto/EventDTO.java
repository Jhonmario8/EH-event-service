package com.eh.eventservice.application.dto;


import com.eh.eventservice.application.constants.ApplicationConstants;
import com.eh.eventservice.domain.model.EventStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventDTO {

    @NotBlank(message = ApplicationConstants.MSG_EVENT_NAME_NOT_BLANK)
    private String name;
    @NotBlank(message = ApplicationConstants.MSG_EVENT_DESCRIPTION_NOT_BLANK)
    private String description;
    @NotNull(message = ApplicationConstants.MSG_EVENT_DATE_NOT_NULL)
    private LocalDate eventDate;
    @NotNull(message = ApplicationConstants.MSG_EVENT_START_TIME_NOT_NULL)
    private LocalTime startTime;
    @NotNull(message = ApplicationConstants.MSG_EVENT_END_TIME_NOT_NULL)
    private LocalTime endTime;
    @NotBlank(message = ApplicationConstants.MSG_EVENT_CITY_NOT_BLANK)
    private String city;
    @NotBlank(message = ApplicationConstants.MSG_EVENT_ADDRESS_NOT_BLANK)
    private String address;
    @NotNull(message = ApplicationConstants.MSG_EVENT_CAPACITY_NOT_NULL)
    @Min(value = 1, message = ApplicationConstants.MSG_EVENT_CAPACITY_MIN_VALUE)
    private Integer capacity;
    @NotNull(message = ApplicationConstants.MSG_EVENT_PRICE_NOT_NULL)
    @Min(value = 1, message = ApplicationConstants.MSG_EVENT_PRICE_MIN_VALUE)
    private Double price;
    private EventStatus status;
    @NotNull(message = ApplicationConstants.MSG_EVENT_CATEGORY_ID_NOT_NULL)
    private Long categoryId;

}
