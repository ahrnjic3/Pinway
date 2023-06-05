package com.example.userservice.security;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.exception.PinwayError;
import com.example.userservice.models.UsernamePassword;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@ComponentScan("ba.unsa.etf.userservice")
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthConfig authConfig;
    @Autowired
    private AuthService authService;

//    @PostMapping("/register")
//    public String addNewUser(UserDTO userDTO){
//        return authService.saveUser(userDTO);
//    }

    @PostMapping("/register")
    public ResponseEntity<?> addNewUser(@RequestBody @Valid final UserDTO userDTO){
        try{
            return new ResponseEntity<>(authService.saveUser(userDTO), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UsernamePassword user) {
        try {
            if(user.getUsername() == null || user.getPassword() == null) {
                throw new PinwayError("UserName or Password is Empty");
            }
            UserDTO userDTO = authService.getUserByUsername(user.getUsername());

            if(userDTO == null || !authConfig.passwordEncoder.matches(user.getPassword(),userDTO.getPassword() ) ){
                throw new PinwayError ("UserName or Password is Invalid: "+ userDTO.getPassword()+" \n"+ authService.encodePassword(user.getPassword()) );
            }
            return new ResponseEntity<>(authService.generateToken(userDTO.getUsername()), HttpStatus.OK);
        } catch (PinwayError e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/token")
    public String getToken(@RequestBody UserDTO userDTO){
        return authService.generateToken(userDTO.getUsername());
    }

    @GetMapping("/validate")
    public String validateToken( @RequestParam("token") String token){
        authService.validateToken(token);
        return "Token is valid";
    }

}
