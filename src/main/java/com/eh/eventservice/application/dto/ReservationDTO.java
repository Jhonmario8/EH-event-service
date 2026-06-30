package com.eh.eventservice.application.dto;

import com.eh.eventservice.application.constants.ApplicationConstants;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationDTO {

    @NotNull(message = ApplicationConstants.MSG_RESERVATION_EVENT_ID_NOT_NULL)
    private Long eventId;
    @NotNull(message = ApplicationConstants.MSG_RESERVATION_CLIENT_ID_NOT_NULL)
    private Long clientId;
    @NotBlank(message = ApplicationConstants.MSG_RESERVATION_CLIENT_EMAIL_NOT_BLANK)
    private String clientEmail;
    @NotNull(message = ApplicationConstants.MSG_RESERVATION_QUANTITY_NOT_NULL)
    @Min(value = 1, message = ApplicationConstants.MSG_RESERVATION_QUANTITY_MIN_VALUE)
    @Max(value = 6, message = ApplicationConstants.MSG_RESERVATION_QUANTITY_MAX_VALUE)
    private Integer quantity;


}
