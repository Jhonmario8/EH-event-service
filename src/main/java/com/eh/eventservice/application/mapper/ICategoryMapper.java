package com.eh.eventservice.application.mapper;

import com.eh.eventservice.application.dto.CategoryDTO;
import com.eh.eventservice.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ICategoryMapper {

    CategoryDTO toDto(Category category);

    Category toDomain(CategoryDTO categoryDTO);

}
