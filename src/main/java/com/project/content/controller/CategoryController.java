package com.project.content.controller;

import com.project.content.dto.CategoryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface CategoryController {

    @GetMapping(value="/category")
    ResponseEntity<List<CategoryDTO>> getAllCategories();
}
