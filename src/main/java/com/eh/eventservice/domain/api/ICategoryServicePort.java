package com.eh.eventservice.domain.api;

import com.eh.eventservice.domain.model.Category;

import java.util.List;

public interface ICategoryServicePort {
    Category createCategory(Category category);
    List<Category> getAllCategories();
}
