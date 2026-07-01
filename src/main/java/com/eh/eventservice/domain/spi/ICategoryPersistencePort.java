package com.eh.eventservice.domain.spi;

import com.eh.eventservice.domain.model.Category;

import java.util.Optional;

public interface ICategoryPersistencePort {

    Category saveCategory(Category category);
    Optional<Category> findByName(String name);
}
