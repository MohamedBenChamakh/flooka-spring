package com.project.content.controller.impl;

import com.project.content.utils.FileManager;
import com.project.content.controller.FileController;
import com.project.content.service.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileControllerImpl implements FileController {
    @Autowired
    private StreamingService streamingService;

    private final Path basePath = Paths.get("src/main/resources/upload/");

    public Mono<Resource> getVideo(@PathVariable String title, @RequestHeader("Range") String range) {
        return streamingService.getVideo(title);
    }

    public ResponseEntity<Path> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        try {
            Files.createDirectories(basePath);
            Path filePath = Paths.get(basePath + File.separator + file.getOriginalFilename());
            //FileManager.optimizeImage(file);
            FileManager.convertToMp4(file);
            //Files.write(filePath, file.getBytes());
            return ResponseEntity.ok().body(filePath);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
