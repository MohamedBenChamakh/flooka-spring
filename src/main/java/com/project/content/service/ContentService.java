package com.project.content.service;


import com.project.content.dto.ContentDTO;

import java.util.List;

public interface ContentService {

    List<ContentDTO> getAllContents();

    ContentDTO getContentById(String contentId);

    List<ContentDTO> getContentByCategoryId(String categoryId);
}
