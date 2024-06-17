package com.example.photo.repository;

import com.example.photo.domain.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select c from Comment c where c.photo.id = ?1")
    List<Comment> findCommentsByPhotoId(Long id);
}
