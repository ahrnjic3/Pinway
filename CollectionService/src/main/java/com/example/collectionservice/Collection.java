package com.example.collectionservice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;
import java.time.LocalDate;

@Entity // This tells Hibernate to make a table out of this class
public class Collection {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    private LocalDate created_at;
    private Integer num_of_posts;

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

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public Integer getNum_of_posts() {
        return num_of_posts;
    }

    public void setNum_of_posts(Integer num_of_posts) {
        this.num_of_posts = num_of_posts;
    }

    public CollectionVisibilityType getVisibilityType() {
        return visibilityType;
    }

    public void setVisibilityType(CollectionVisibilityType visibilityType) {
        this.visibilityType = visibilityType;
    }

    private CollectionVisibilityType visibilityType;

}