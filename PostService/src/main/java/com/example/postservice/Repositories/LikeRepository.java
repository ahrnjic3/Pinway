package com.example.postservice.Repositories;

import com.example.postservice.Models.Like;
import org.springframework.data.repository.CrudRepository;

public interface LikeRepository  extends CrudRepository<Like, Long> {
}
