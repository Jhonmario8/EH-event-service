package com.eh.eventservice.application.dto;

import com.eh.eventservice.application.constants.ApplicationConstants;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDTO {

    @NotBlank(message = ApplicationConstants.MSG_CATEGORY_NAME_NOT_BLANK)
    @Size(min = 3, max = 100, message = ApplicationConstants.MSG_CATEGORY_NAME_BETWEEN_SIZE)
    private String name;
    @Size(max = 500,message = ApplicationConstants.MSG_CATEGORY_DESCRIPTION_MAX_SIZE)
    private String description;


}
