package com.eh.eventservice.infrastructure.input.controller;

import com.eh.eventservice.application.dto.CategoryDTO;
import com.eh.eventservice.application.handler.ICategoryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryHandler categoryHandler;

    @PostMapping()
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
        CategoryDTO dto = categoryHandler.createCategory(categoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }


}
