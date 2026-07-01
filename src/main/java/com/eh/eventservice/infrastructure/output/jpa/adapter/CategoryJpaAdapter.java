package com.eh.eventservice.infrastructure.output.jpa.adapter;

import com.eh.eventservice.domain.model.Category;
import com.eh.eventservice.domain.spi.ICategoryPersistencePort;
import com.eh.eventservice.infrastructure.output.jpa.mapper.ICategoryEntityMapper;
import com.eh.eventservice.infrastructure.output.jpa.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryJpaAdapter implements ICategoryPersistencePort {

    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;


    @Override
    public Category saveCategory(Category category) {
        return categoryEntityMapper.toDomain(categoryRepository.save(categoryEntityMapper.toEntity(category)));
    }

    @Override
    public Optional<Category> findByName(String name) {
        return categoryRepository.findByNameIgnoreCase(name).map(categoryEntityMapper::toDomain);
    }
}
