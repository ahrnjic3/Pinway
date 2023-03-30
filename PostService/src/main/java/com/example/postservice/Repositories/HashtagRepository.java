package com.example.postservice.Repositories;

import com.example.postservice.Models.Hashtag;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface HashtagRepository extends CrudRepository<Hashtag, Long> {

}
