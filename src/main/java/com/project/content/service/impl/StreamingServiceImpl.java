package com.project.content.service.impl;

import com.project.content.service.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class StreamingServiceImpl implements StreamingService {

    private static final String FORMAT = "classpath:videos/%s.mp4";

    @Autowired
    private ResourceLoader resourceLoader;

    public Mono<Resource> getVideo(String title) {
        return Mono.fromSupplier(() -> this.resourceLoader.getResource(String.format(FORMAT, title)));
    }
}
