package com.example.userservice.services;

import com.example.userservice.dto.UserCollectionCreateDTO;
import com.example.userservice.dto.UserResponseDTO;
import com.example.userservice.models.User;

import java.util.UUID;

public interface UserCollectionService {

    User AddCollection(UUID id, UserCollectionCreateDTO userCollectionCreateDTO);

    UserResponseDTO GetAllCollectionsForUser(UUID id);
}
