package com.example.postservice.services;


import com.example.postservice.dto.CommentDTO;
import com.example.postservice.exception.PinwayError;
import com.example.postservice.models.Comment;
import com.example.postservice.models.Post;
import com.example.postservice.repositories.CommentRepository;
import com.example.postservice.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentServiceImp implements CommentService{

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public Comment FindById(Long id) {
        Comment comment = commentRepository.findById(id).orElse(null);
        return comment;
    }

    @Override
    public Comment Create(CommentDTO commentDTO){
        Comment new_comment = new Comment();
        new_comment.setContent(commentDTO.getContent());
        Post post = postRepository.findById(commentDTO.getPost_id()).orElse(null);
        new_comment.setPost(post);
        new_comment.setCreatedAt(LocalDateTime.now());

        Comment newComment = commentRepository.save(new_comment);
        return  newComment;
    }

    @Override
    public Comment Update(CommentDTO commentDTO) {
        Comment new_comment = commentRepository.findById(commentDTO.getId()).orElse(null);
        if(new_comment == null){
            throw new PinwayError("Not found Post with id = " + commentDTO.getId());
        }
        new_comment.setContent(commentDTO.getContent());
        new_comment.setCreatedAt(LocalDateTime.now());
        commentRepository.save(new_comment);
        return  new_comment;
    }

    @Override
    public Boolean Delete(Long id) {
        Comment comment = commentRepository.findById(id).orElse(null);
        if(comment == null) {
            throw new PinwayError("Not found comment with id = " + id);
        }
        commentRepository.delete(comment);
        return true;
    }
}
