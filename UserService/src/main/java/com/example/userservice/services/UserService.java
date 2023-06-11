package com.example.userservice.services;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.models.User;
import com.example.userservice.models.UserVisibilityType;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public interface UserService {
        User Create(User user);

        Iterable<User> List();

        UserDTO Details(Integer id);

        Boolean Delete(Integer id);

        User Update(Integer id, User user);

        Iterable<UserVisibilityType> ListUserVisibilityTypes();

        UserDTO AddFollower(Integer userId, Integer followingId);

        List<UserDTO> GetAllFollowersForUser(Integer userId);
        User addRoleToUser(String username, String name);
        Mono<User> getByUsername(String username);

        User registerUser(User user);
}