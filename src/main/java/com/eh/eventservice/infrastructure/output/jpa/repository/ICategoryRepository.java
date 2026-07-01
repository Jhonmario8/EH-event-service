package com.eh.eventservice.infrastructure.output.jpa.repository;

import com.eh.eventservice.infrastructure.output.jpa.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {

    Optional<CategoryEntity> findByNameIgnoreCase(String name);
    Optional<CategoryEntity> findByIdAndActive(Long id, Boolean active);
}
