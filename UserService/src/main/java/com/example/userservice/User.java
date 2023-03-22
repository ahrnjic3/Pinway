package com.example.userservice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String guid;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private LocalDate createdAt;
    private UserVisibilityType visibilityType;
    private Integer numOfFollowing;
    private Integer numOfFollowers;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public UserVisibilityType getVisibilityType() {
        return visibilityType;
    }

    public void setVisibilityType(UserVisibilityType visibilityType) {
        this.visibilityType = visibilityType;
    }

    public Integer getNumOfFollowing() {
        return numOfFollowing;
    }

    public void setNumOfFollowing(Integer numOfFollowing) {
        this.numOfFollowing = numOfFollowing;
    }

    public Integer getNumOfFollowers() {
        return numOfFollowers;
    }

    public void setNumOfFollowers(Integer numOfFollowers) {
        this.numOfFollowers = numOfFollowers;
    }
}