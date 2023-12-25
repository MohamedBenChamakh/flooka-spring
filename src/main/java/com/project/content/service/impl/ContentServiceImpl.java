package com.project.content.service.impl;

import com.project.content.dto.ContentDTO;
import com.project.content.mapper.ContentMapper;
import com.project.content.repository.ContentRepository;
import com.project.content.service.ContentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    private final ContentRepository contentRepository;

    public ContentServiceImpl(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Override
    public List<ContentDTO> getAllContents() {
        return ContentMapper.INSTANCE.toDTO(contentRepository.findAll());
    }

    @Override
    public ContentDTO getContentById(String contentId) {
        return ContentMapper.INSTANCE.toDTO(contentRepository.findById(contentId).orElse(null));
    }

    @Override
    public List<ContentDTO> getContentByCategoryId(String categoryId) {
        return ContentMapper.INSTANCE.toDTO(contentRepository.findByCategory_id(categoryId));
    }
}
