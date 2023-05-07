package com.example.collectionservice.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity // This tells Hibernate to make a table out of this class
public class Collection {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 20, message = "Name must contain less than 20 characters")
    private String name;

    @NotNull
    @ManyToOne
    @JoinColumn(name="typeId")
    private CollectionVisibilityType collectionVisibilityType;

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

    public CollectionVisibilityType getCollectionVisibilityType() {
        return collectionVisibilityType;
    }

    public void setCollectionVisibilityType(CollectionVisibilityType collectionVisibilityType) {
        this.collectionVisibilityType = collectionVisibilityType;
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