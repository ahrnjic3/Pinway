package com.example.userservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

public class CollectionDTO {

    private Integer id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 20, message = "Name must contain less than 20 characters")
    private String name;

    @NotNull
    private UserVisibilityTypeDTO userVisibilityTypeDTO;

    @PastOrPresent
    @NotNull
    private LocalDate createdAt;

    @Positive(message = "Number of posts must be positive ")
    @NotNull
    private Integer numOfPosts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserVisibilityTypeDTO getUserVisibilityTypeDTO() {
        return userVisibilityTypeDTO;
    }

    public void setUserVisibilityTypeDTO(UserVisibilityTypeDTO userVisibilityTypeDTO) {
        this.userVisibilityTypeDTO = userVisibilityTypeDTO;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getNumOfPosts() {
        return numOfPosts;
    }

    public void setNumOfPosts(Integer numOfPosts) {
        this.numOfPosts = numOfPosts;
    }
}
