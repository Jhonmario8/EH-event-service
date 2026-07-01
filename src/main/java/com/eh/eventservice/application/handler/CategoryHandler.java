package com.eh.eventservice.application.handler;

import com.eh.eventservice.application.dto.CategoryDTO;
import com.eh.eventservice.application.mapper.ICategoryMapper;
import com.eh.eventservice.domain.api.ICategoryServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryHandler implements ICategoryHandler{

    private final ICategoryServicePort categoryServicePort;
    private final ICategoryMapper mapper;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        return mapper.toDto(categoryServicePort.createCategory(mapper.toDomain(categoryDTO)));
    }
}
