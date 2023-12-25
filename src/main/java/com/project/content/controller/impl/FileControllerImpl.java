package com.project.content.controller.impl;

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

@RestController
public class FileControllerImpl implements FileController {

    @Autowired
    private StreamingService streamingService;

    @GetMapping(value = "video/{title}", produces = "video/mp4")
    public Mono<Resource> getVideo(@PathVariable String title, @RequestHeader("Range") String range) {
        return streamingService.getVideo(title);
    }

    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        File path = new File("./src/main/resources/images/" + file.getOriginalFilename());
        path.createNewFile();
        return ResponseEntity.ok("./src/main/resources/images/\" + file.getOriginalFilename()");
    }
}
