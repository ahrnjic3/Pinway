package com.example.postservice.controllers;

import com.example.postservice.dto.CommentDTO;
import com.example.postservice.dto.LikeDTO;
import com.example.postservice.dto.UserDTO;
import com.example.postservice.models.Comment;
import com.example.postservice.models.Like;
import com.example.postservice.services.CommentService;
import com.example.postservice.services.LikeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller // This means that this class is a Controller
@RequestMapping(path="/api/like") // This means URL's start with /demo (after Application path)
public class LikeController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private LikeService likeService;

    @Autowired
    private CommentService commentService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody ResponseEntity<Like> addNewLike (@Valid @RequestBody LikeDTO likeDTO) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        var like =  likeService.checkExistsByCommentLikeId(likeDTO.getCommentId(), likeDTO.getUserId());
        if ( like!= null){
            likeService.Delete(like.getId().longValue());
            return ResponseEntity.status(204).body(like);
        }
        like = new Like();
        Comment comment = commentService.FindById(likeDTO.getCommentId());
        like.setComment(comment);
        like.setUser_id(likeDTO.getUserId());
        Like newLike = likeService.Create(like);
        return ResponseEntity.status(201).body(newLike);
    }

    @DeleteMapping("/delete")
    public @ResponseBody ResponseEntity<Boolean> deleteLike(@RequestParam Long id){
        likeService.Delete(id);
        return ResponseEntity.status(204).body(true);
    }

}
