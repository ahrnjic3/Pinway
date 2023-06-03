package com.example.userservice.services;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.models.User;
import com.example.userservice.models.UserVisibilityType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    User Create(User user);

    Iterable<User> List();

    User Details(UUID id);

    Boolean Delete(UUID id);

    User Update(UUID id, User user);

    Iterable<UserVisibilityType> ListUserVisibilityTypes();

    User AddFollower(UUID userId, UUID followingId);

    List<UserDTO> GetAllFollowersForUser(UUID userId);


}