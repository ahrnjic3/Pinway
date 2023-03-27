package com.example.postservice.models;

import com.example.postservice.models.Comment;
import com.example.postservice.models.Hashtag;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    private String image_path;

    private Long user_id;

    private Integer pin_counter;

    private LocalDate created_at;


    @ManyToMany
    @JoinTable(
            name ="hashtag_post",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "hashtag_id"))
    Set<Hashtag> hashtags;

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Integer getPin_counter() {
        return pin_counter;
    }

    public void setPin_counter(Integer pin_counter) {
        this.pin_counter = pin_counter;
    }
    public Set<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(Set<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }
    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }
}