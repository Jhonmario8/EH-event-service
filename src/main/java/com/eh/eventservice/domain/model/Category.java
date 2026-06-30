package com.eh.eventservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Category {

    private Long id;
    private String name;
    private String description;
    private Boolean active=true;

}
