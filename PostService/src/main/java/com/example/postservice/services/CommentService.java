package com.example.postservice.services;

import com.example.postservice.dto.CommentDTO;
import com.example.postservice.models.Comment;

public interface CommentService {
    Comment FindById( Long id);
    public Comment Create(CommentDTO commentDTO);
    public Comment Update(CommentDTO commentDTO);
    public Boolean Delete(Long id);
}
