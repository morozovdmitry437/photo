package com.example.photo.controllers;

import com.example.photo.domain.models.Comment;
import com.example.photo.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/post")
    public ResponseEntity<String> saveComment(Comment comment) {
        commentService.save(comment);
        return ResponseEntity.ok("Comment saved");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable long id) {
        commentService.delete(id);
        return ResponseEntity.ok("Comment deleted");
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Comment>> getCommentsByPhotoId(@PathVariable long id) {
        List<Comment> list = commentService.getCommentsByPhotoId(id);
        return ResponseEntity.ok(list);
    }


}
