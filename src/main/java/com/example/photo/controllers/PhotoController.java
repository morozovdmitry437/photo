package com.example.photo.controllers;

import com.example.photo.domain.models.Photo;
import com.example.photo.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller

public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadPhoto(@RequestParam("title") String title, @RequestParam("file") MultipartFile file) {
        try {
            Photo savedPhoto = photoService.savePhoto(file, title);
            return ResponseEntity.ok("Photo saved with ID: " + savedPhoto.getId());
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error saving photo: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getPhoto(@PathVariable Long id) {
        Photo photo = photoService.getPhoto(id);
        if (photo != null) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + photo.getTitle() + "\"")
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(photo.getData());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Photo>> getAllPhotos() {
        List<Photo> photos = photoService.getAllPhotos();
        return new ResponseEntity<>(photos, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deletePhoto(@PathVariable Long id) {
        photoService.deletePhoto(id);
        return ResponseEntity.ok("Photo deleted");
    }
}
