package com.eh.eventservice.application.handler;

import com.eh.eventservice.application.dto.CategoryDTO;

import java.util.List;

public interface ICategoryHandler {
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    List<CategoryDTO> getAllCategories();
}
