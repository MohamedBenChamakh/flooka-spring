package com.project.content.controller.impl;

import com.project.content.dto.FileDTO;
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
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.io.IOUtils;
@RestController
public class FileControllerImpl implements FileController {
    @Autowired
    private StreamingService streamingService;


    public Mono<Resource> getVideo(@PathVariable String title, @RequestHeader("Range") String range) {
        return streamingService.getVideo(title);
    }

    @Override
    public byte[] getImage(String title) throws IOException {
        InputStream in = getClass()
                    .getResourceAsStream("/images/"  + title+".jpg");

        if (in == null) {
            // Log a message or handle the null case appropriately
            System.out.println("Resource not found: " + title+".jpg");
            return null;
        }
        return IOUtils.toByteArray(in);
    }


    public ResponseEntity<FileDTO> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        String extension =file.getContentType().split("/")[0];
        String fileName;
        if(extension.equals("image")){
            fileName=FileManager.optimizeImage(file);
        }else if(extension.equals("video")){
            fileName=FileManager.convertToMp4(file);
        }else{
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(new FileDTO(fileName));

    }
}
