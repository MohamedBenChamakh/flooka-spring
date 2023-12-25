package com.project.content.controller.impl;

import com.project.content.service.ContentService;
import com.project.content.controller.ContentController;
import com.project.content.dto.ContentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContentControllerImpl implements ContentController {

    private final ContentService contentService;

    public ContentControllerImpl(ContentService contentService) {
        this.contentService = contentService;
    }


    @Override
    public ResponseEntity<List<ContentDTO>> getAllContents() {
        return ResponseEntity.ok(contentService.getAllContents());
    }

    @Override
    public ResponseEntity<ContentDTO> getContentById(String contentId) {
        return ResponseEntity.ok(contentService.getContentById(contentId));
    }

    @Override
    public ResponseEntity<List<ContentDTO>> getContentsByCategoryId(String categoryId) {
        return ResponseEntity.ok(contentService.getContentByCategoryId(categoryId));
    }
}
