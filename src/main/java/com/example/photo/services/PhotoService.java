package com.example.photo.services;

import com.example.photo.domain.models.Photo;
import com.example.photo.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    public Photo savePhoto(MultipartFile file, String title) throws IOException {
        Photo photo = new Photo();
        photo.setTitle(title);
        photo.setData(file.getBytes());
        return photoRepository.save(photo);
    }

    public Photo getPhoto(Long id) {
        return photoRepository.findById(id).orElse(null);
    }

    public List<Photo> getAllPhotos() {
        return photoRepository.findAll();
    }

    public void deletePhoto(Long id) {
        photoRepository.deleteById(id);
    }
}
