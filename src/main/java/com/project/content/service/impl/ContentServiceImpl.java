package com.project.content.service.impl;

import com.project.content.dto.ContentDTO;
import com.project.content.dto.ContentDetailsDTO;
import com.project.content.mapper.ContentMapper;
import com.project.content.repository.ContentRepository;
import com.project.content.service.ContentService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    private final ContentRepository contentRepository;

    public ContentServiceImpl(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Override
    public List<ContentDTO> getAllContents(int page) {
        int pageSize = 10;
        Pageable paging = PageRequest.of(page, pageSize);
        return ContentMapper.INSTANCE.toDTO(contentRepository.findAll(paging).getContent());
    }

    @Override
    public ContentDTO getContentById(String contentId) {
        return ContentMapper.INSTANCE.toDTO(contentRepository.findById(contentId).orElse(null));
    }

    @Override
    public List<ContentDTO> getContentByCategoryId(String categoryId, int page) {
        int pageSize = 10;
        Pageable paging = PageRequest.of(page, pageSize);
        return ContentMapper.INSTANCE.toDTO(contentRepository.findByCategory_id(categoryId, paging).getContent());
    }

    @Override
    public ContentDTO createContent(ContentDetailsDTO contentDTO) {
        return ContentMapper.INSTANCE.toDTO(contentRepository
                .save(ContentMapper.INSTANCE.toEntity(contentDTO)));
    }
}
