package com.example.postservice.services;


import com.example.postservice.dto.CommentDTO;
import com.example.postservice.dto.CommentResponseDTO;
import com.example.postservice.dto.PostResponseDTO;
import com.example.postservice.dto.UserDTO;
import com.example.postservice.exception.PinwayError;
import com.example.postservice.models.Comment;
import com.example.postservice.models.Post;
import com.example.postservice.repositories.CommentRepository;
import com.example.postservice.repositories.PostRepository;
import jdk.jfr.RecordingState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImp implements CommentService{

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Comment FindById(Long id) {
        Comment comment = commentRepository.findById(id).orElse(null);
        return comment;
    }

    @Override
    public Iterable<CommentResponseDTO>  FindByPost(Long postId){
        Optional<Post> post = postRepository.findById(postId);
        if(!post.isPresent()) return new ArrayList<CommentResponseDTO>();
        List<Comment> comments = commentRepository.findByPost(postId);
        ArrayList<CommentResponseDTO> res = new ArrayList<CommentResponseDTO>();
        for (Comment comment: comments) {
            Long param = comment.getUser_id();
            ResponseEntity<UserDTO> responseEntity = restTemplate.getForEntity("http://user-service/api/users/{id}",
                    UserDTO.class, param);
            UserDTO userDTO = responseEntity.getBody();
            CommentDTO commentDTO = new CommentDTO();
            commentDTO.setId(comment.getId());
            commentDTO.setContent(comment.getContent());
            commentDTO.setPost_id(comment.getPost().getId());
            CommentResponseDTO commentResponseDTO = new CommentResponseDTO();
            commentResponseDTO.setUserDTO(userDTO);
            commentResponseDTO.setCommentDTO(commentDTO);
            res.add(commentResponseDTO);
        }
        Iterable<CommentResponseDTO> response = res;
        return  response;
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
