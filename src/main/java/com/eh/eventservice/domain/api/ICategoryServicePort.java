package com.eh.eventservice.domain.api;

import com.eh.eventservice.domain.model.Category;

public interface ICategoryServicePort {
    Category createCategory(Category category);
}
