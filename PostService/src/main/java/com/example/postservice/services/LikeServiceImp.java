package com.example.postservice.services;

import com.example.postservice.exception.PinwayError;
import com.example.postservice.infrastructure.EventService;
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

    @Autowired
    private EventService eventService;

    @Override
    public Like Create(Like like){
        try {
            Like newLike = likeRepository.save(like);
            eventService.LikeCreated(newLike);
            return  newLike;
        } catch (Exception e) {
            System.out.println(e);
        }
        return  null;
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
