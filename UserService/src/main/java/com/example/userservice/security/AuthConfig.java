package com.example.userservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class AuthConfig {
    public PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/roles","/api/users","/api/auth/register","/api/auth/login", "/api/auth/validate", "/api/auth/token")
                .permitAll()
                .and()
                .build();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        //potrebno nam je jer AuthService.save ce sacuvati
        //password korisnika kao obican string
        passwordEncoder= new BCryptPasswordEncoder();
        return passwordEncoder;
    }
}
