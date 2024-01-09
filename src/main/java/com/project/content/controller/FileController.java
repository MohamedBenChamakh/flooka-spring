package com.project.content.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Path;


public interface FileController {

    @GetMapping(value = "video/{title}", produces = "video/mp4")
    Mono<Resource> getVideo(@PathVariable String title, @RequestHeader("Range") String range);

    @GetMapping(
            value = "/image/{title}",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
     @ResponseBody byte[] getImage(@PathVariable String title) throws IOException;

    @PostMapping(value = "/file" )
    ResponseEntity<Path> uploadFile(@RequestParam("file") MultipartFile file ) throws IOException;
}
