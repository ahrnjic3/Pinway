package com.example.postservice.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private Long user_id;
    private String content;
    public Integer getId() {
        return id;
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name ="post_id", nullable = false)
    private Post post;


    @OneToMany(mappedBy = "comment",  cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Like> likes;

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Set<Like> getLikes() {
        return likes;
    }

    public void setLikes(Set<Like> likes) {
        this.likes = likes;
    }
}
