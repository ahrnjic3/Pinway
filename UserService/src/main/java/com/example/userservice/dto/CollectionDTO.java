package com.example.userservice.dto;


import jakarta.validation.constraints.*;

import java.time.LocalDate;


public class CollectionDTO {

    private Integer id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 20, message = "Name must contain less than 20 characters")
    private String name;

    @NotNull
    private CollectionVisibilityTypeDTO collectionVisibilityTypeDTO;

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

    public CollectionVisibilityTypeDTO getCollectionVisibilityTypeDTO() {
        return collectionVisibilityTypeDTO;
    }

    public void setCollectionVisibilityTypeDTO(CollectionVisibilityTypeDTO collectionVisibilityTypeDTO) {
        this.collectionVisibilityTypeDTO = collectionVisibilityTypeDTO;
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
