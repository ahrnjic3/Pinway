package com.example.userservice.services;

import com.example.userservice.dto.CollectionDTO;
import com.example.userservice.dto.UserCollectionCreateDTO;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.dto.UserResponseDTO;
import com.example.userservice.models.User;

public interface UserCollectionService {

    UserDTO AddCollection(Integer id, UserCollectionCreateDTO userCollectionCreateDTO);

    UserResponseDTO GetAllCollectionsForUser(Integer id);

    Iterable<CollectionDTO> GetSharedAndPublicCollectionsForUserFromUser(Integer actionUserId, Integer userId);
}
