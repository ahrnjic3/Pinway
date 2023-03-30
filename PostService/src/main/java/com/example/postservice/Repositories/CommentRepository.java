package com.example.postservice.Repositories;

import com.example.postservice.Models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
