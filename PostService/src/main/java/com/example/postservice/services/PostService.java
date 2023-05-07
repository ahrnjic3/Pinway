package com.example.postservice.services;


import com.example.postservice.dto.PostDTO;
import com.example.postservice.models.Hashtag;
import com.example.postservice.models.Post;

public interface PostService {

     Post Create(Post post);
     Iterable<Post> List();
     Iterable<Post> FindAllByIds(Iterable<Long> ids);
     Post FindById( Long id);
     Boolean Delete (Long id);
     Post Update(PostDTO postDTO, Iterable<Hashtag> hashtags);
}
