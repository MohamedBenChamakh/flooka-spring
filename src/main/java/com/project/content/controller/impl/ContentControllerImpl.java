package com.project.content.controller.impl;

import com.project.content.dto.ContentDetailsDTO;
import com.project.content.service.ContentService;
import com.project.content.controller.ContentController;
import com.project.content.dto.ContentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class ContentControllerImpl implements ContentController {

    private final ContentService contentService;

    public ContentControllerImpl(ContentService contentService) {
        this.contentService = contentService;
    }


    @Override
    public ResponseEntity<List<ContentDTO>> getAllContents(@RequestParam("page") int page) {
        return ResponseEntity.ok(contentService.getAllContents(page));
    }

    @Override
    public ResponseEntity<ContentDTO> createContent(ContentDetailsDTO contentDTO) {
        return ResponseEntity.ok(contentService.createContent(contentDTO));
    }

    @Override
    public ResponseEntity<ContentDTO> getContentById(String contentId) {
        return ResponseEntity.ok(contentService.getContentById(contentId));
    }

    @Override
    public ResponseEntity<List<ContentDTO>> getContentsByCategoryId(String categoryId, int page) {
        return ResponseEntity.ok(contentService.getContentByCategoryId(categoryId, page));
    }

    @Override
    public ResponseEntity<ContentDTO> likeContent(String contentId, Principal principal) {
        ContentDTO contentDTO = contentService.likeContent(contentId, principal);
        if (contentDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(contentDTO);
    }
}
