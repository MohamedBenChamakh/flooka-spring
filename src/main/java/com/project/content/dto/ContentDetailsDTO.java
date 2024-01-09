package com.project.content.dto;

import com.project.content.domain.Like;

import java.util.List;

public class ContentDetailsDTO extends  ContentDTO{

    private CategoryDTO category;


    public ContentDetailsDTO() {
        super();
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }


}
