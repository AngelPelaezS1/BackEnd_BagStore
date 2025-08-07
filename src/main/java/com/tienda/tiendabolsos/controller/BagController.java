package com.tienda.tiendabolsos.controller;

import com.tienda.tiendabolsos.dto.CreateBagRequest;
import com.tienda.tiendabolsos.service.BagService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

public class BagController {

    private final BagService bagService;

    public BagController(BagService bagService) {
        this.bagService = bagService;
    }

    @PostMapping("/api/bags")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createBag(
            @RequestPart("bag") CreateBagRequest request,
            @RequestPart("mainImage") MultipartFile mainImage,
            @RequestPart(value = "extraImages", required = false) MultipartFile[] extraImages
    ) {
        bagService.createBag(request, mainImage, extraImages);
        return ResponseEntity.ok().build();
    }
}

