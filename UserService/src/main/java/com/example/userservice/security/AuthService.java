package com.example.userservice.security;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.repositories.UserRepository;
import com.example.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.stereotype.Service;

@Service
@ComponentScan("ba.unsa.etf.userservice")
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    //method to generate and validate a token
    @Autowired
    private JwtService jwtService;


    @Autowired
    private AuthConfig authConfig;
    //inject-amo PasswordEncoder iz AuthConfig
    //da mozemo u saveUser da sacuvamo enkriptovan password

    public String saveUser(UserDTO userDTO){
        userDTO.setPassword(authConfig.passwordEncoder.encode(userDTO.getPassword()));
        //userRepository.save(userDTO);
        userService.create(userDTO);
        return "User added";
    }

    public String encodePassword(String password){
        return authConfig.passwordEncoder.encode(password);
    }

    public String generateToken(String username){
        return jwtService.generateToken(username);
    }

    public void validateToken(String token){
        jwtService.validateToken(token);
    }

    public UserDTO getUserByUsername(String username) {
        return userService.getUserByUsername(username);
    }
}