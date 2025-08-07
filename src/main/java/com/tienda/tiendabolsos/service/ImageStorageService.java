package com.tienda.tiendabolsos.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ImageStorageService {

    public String saveImage(MultipartFile file) {
        try {
            String uploadsDir = "uploads/";
            String filename = UUID.randomUUID() + "-" + file.getOriginalFilename();
            Path path = Paths.get(uploadsDir + filename);
            Files.createDirectories(path.getParent());
            Files.write(path, file.getBytes());
            return "http://localhost:8080/uploads/" + filename;
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar la imagen", e);
        }
    }
}
