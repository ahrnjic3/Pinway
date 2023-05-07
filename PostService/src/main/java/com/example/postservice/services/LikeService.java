package com.example.postservice.services;

import com.example.postservice.models.Like;

public interface LikeService {
     Like Create(Like like);
     Boolean Delete (Long id);
}
