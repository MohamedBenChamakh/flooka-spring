package com.project.content.controller;

import com.project.content.dto.ContentDTO;
import com.project.content.dto.ContentDetailsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ContentController {

    @GetMapping("/content")
    ResponseEntity<List<ContentDTO>> getAllContents(@RequestParam(value = "page") int page);

    @PostMapping("/content")
    ResponseEntity<ContentDTO> createContent(@RequestBody ContentDetailsDTO contentDTO);

    @GetMapping("/content/{contentId}")
    ResponseEntity<ContentDTO> getContentById(@PathVariable String contentId);

    @GetMapping("/category/{categoryId}")
    ResponseEntity<List<ContentDTO>> getContentsByCategoryId(@PathVariable String categoryId, @RequestParam(value = "page") int page);
}
