package com.example.store.controller;


import com.example.store.models.Image;
import com.example.store.repository.ImageRepository;
import com.example.store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final ImageRepository imageRepository;
    private final ProductService productService;


    @GetMapping("/images/{id}")
    @Transactional
    public ResponseEntity<byte[]> getImageById(@PathVariable Long id) {
        Image image = productService.findById(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(image.getContentType()))
                .body(image.getBytes());
    }
}
