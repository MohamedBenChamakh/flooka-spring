package com.project.content.dto;

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
