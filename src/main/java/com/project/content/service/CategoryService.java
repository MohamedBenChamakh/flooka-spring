package com.project.content.service;

import com.project.content.dto.CategoryDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {


    List<CategoryDTO> getAllCategories();
}
