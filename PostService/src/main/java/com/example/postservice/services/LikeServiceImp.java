package com.example.postservice.services;

import com.example.postservice.exception.PinwayError;
import com.example.postservice.models.Comment;
import com.example.postservice.models.Like;
import com.example.postservice.models.Post;
import com.example.postservice.repositories.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImp implements  LikeService{
    @Autowired
    public LikeRepository likeRepository;

    @Override
    public Like Create(Like like){
        Like newLike = likeRepository.save(like);
        return  newLike;
    }

    @Override
    public Boolean Delete (Long id){
        Like like = likeRepository.findById(id).orElse(null);
        if(like == null) {
            throw new PinwayError("Not found Post with id = " + id);
        }
        likeRepository.deleteById(id);
        return true;
    }
}
