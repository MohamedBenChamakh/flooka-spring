package com.project.content.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileController {

    @PostMapping("/file")
    ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException;
}
