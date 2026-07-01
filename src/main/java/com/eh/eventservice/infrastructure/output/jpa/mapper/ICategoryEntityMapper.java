package com.eh.eventservice.infrastructure.output.jpa.mapper;

import com.eh.eventservice.domain.model.Category;
import com.eh.eventservice.infrastructure.output.jpa.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ICategoryEntityMapper {

    CategoryEntity toEntity(Category category);

    Category toDomain(CategoryEntity categoryEntity);

}
