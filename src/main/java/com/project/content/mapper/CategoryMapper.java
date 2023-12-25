package com.project.content.mapper;

import com.project.content.domain.Category;
import com.project.content.dto.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO toDto(Category category);

    List<CategoryDTO> toDto(List<Category> categoryList);
}
