package com.example.photo.services;

import com.example.photo.domain.models.Comment;
import com.example.photo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    public void delete(Long id) {
        commentRepository.deleteById(id);
    }

    public List<Comment> getCommentsByPhotoId(Long id) {
        return commentRepository.findCommentsByPhotoId(id);
    }
}
