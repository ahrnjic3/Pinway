package com.example.postservice.Repositories;

import com.example.postservice.Models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface PostRepository extends CrudRepository<Post, Long> {

}