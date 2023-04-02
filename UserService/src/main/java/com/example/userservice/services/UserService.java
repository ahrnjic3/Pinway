package com.example.userservice.services;

import com.example.userservice.models.User;
import com.example.userservice.models.UserVisibilityType;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User Create(User user);

    Iterable<User> List();

    User Details(Integer id);

    Boolean Delete(Integer id);

    User Update(Integer id, User user);

    Iterable<UserVisibilityType> ListUserVisibilityTypes();


}