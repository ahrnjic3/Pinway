package com.example.userservice.services;

import com.example.userservice.dto.UserCollectionCreateDTO;
import com.example.userservice.dto.UserResponseDTO;
import com.example.userservice.models.User;

public interface UserCollectionService {

    User AddCollection(Integer id, UserCollectionCreateDTO userCollectionCreateDTO);

    UserResponseDTO GetAllCollectionsForUser(Integer id);
}
