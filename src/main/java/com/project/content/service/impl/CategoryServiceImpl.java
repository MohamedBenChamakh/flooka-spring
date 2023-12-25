package com.project.content.service.impl;

import com.project.content.dto.CategoryDTO;
import com.project.content.mapper.CategoryMapper;
import com.project.content.repository.CategoryRepository;
import com.project.content.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<CategoryDTO> getAllCategories() {
        return CategoryMapper.INSTANCE.toDto(categoryRepository.findAll());
    }
}
