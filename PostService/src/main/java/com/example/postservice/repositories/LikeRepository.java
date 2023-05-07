package com.example.postservice.repositories;

import com.example.postservice.models.Like;
import org.springframework.data.repository.CrudRepository;

public interface LikeRepository  extends CrudRepository<Like, Long> {
}
