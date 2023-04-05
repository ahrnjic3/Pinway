package com.example.postservice.services;

import com.example.postservice.dto.PostDTO;
import com.example.postservice.exception.PinwayError;
import com.example.postservice.models.Hashtag;
import com.example.postservice.models.Post;
import com.example.postservice.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PostServiceImp implements PostService{
    @Autowired
    private PostRepository postRepository;

    @Override
    public Post Create(Post post){
        Post newPost = postRepository.save(post);
        return  newPost;
    }
    @Override
    public  Iterable<Post> List(){
        Iterable<Post> posts = postRepository.findAll();
        return  posts;
    }
    @Override
    public  Iterable<Post> FindAllByIds(Iterable<Long> ids){
        Iterable<Post> posts = postRepository.findAllById(ids);
        return  posts;
    }
    @Override
    public Post FindById( Long id){
        Post post = postRepository.findById(id).orElse(null);
        return post;
    }
    @Override
    public Boolean Delete (Long id){
        Post post = postRepository.findById(id).orElse(null);
        if(post == null) {
            throw new PinwayError("Not found Post with id = " + id);
        }
        postRepository.deleteById(id);
        return true;
    }

    @Override
    public Post Update(PostDTO postDTO, Iterable<Hashtag> hashtags){
        Post post = postRepository.findById(postDTO.getId()).orElse(null);
        if(post == null){
            throw new PinwayError("Not found Post with id = " + postDTO.getId());
        }
        post.setTitle(postDTO.getTitle());
        post.setImage_path(postDTO.getImage_path());
        post.setDescription(postDTO.getDescription());
        post.setHashtags((Set<Hashtag>) hashtags);
        postRepository.save(post);
        return  post;
    }
}