package com.project.content.controller;

import com.project.content.dto.ContentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ContentController {

    @GetMapping("/content")
     ResponseEntity<List<ContentDTO>> getAllContents();

    @GetMapping("/content/{contentId}")
    ResponseEntity<ContentDTO> getContentById(@PathVariable String contentId);

    @GetMapping("/category/{categoryId}")
    ResponseEntity<List<ContentDTO>> getContentsByCategoryId(@PathVariable String categoryId);
}
