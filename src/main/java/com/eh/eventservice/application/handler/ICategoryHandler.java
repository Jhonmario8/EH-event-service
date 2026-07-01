package com.eh.eventservice.application.handler;

import com.eh.eventservice.application.dto.CategoryDTO;

public interface ICategoryHandler {
    CategoryDTO createCategory(CategoryDTO categoryDTO);
}
