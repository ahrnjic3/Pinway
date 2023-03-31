package com.example.notificationservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity // This tells Hibernate to make a table out of this class
public class Notification {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;


    @NotNull
    @ManyToOne
    @JoinColumn(name="typeId")
    private NotificationType notificationType;

    @NotNull
    private Boolean open;

    @NotNull
    private Integer userId;

    @NotNull
    private Integer actionUserId;
    private Integer pinnedPost;
    private Integer likedComment;
    private Integer sharedCollection;
    @NotBlank(message = "Content is mandatory")
    @Size(max = 50, message = "Content must contain less than 50 characters")
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getActionUserId() {
        return actionUserId;
    }

    public void setActionUserId(Integer actionUserId) {
        this.actionUserId = actionUserId;
    }

    public Integer getPinnedPost() {
        return pinnedPost;
    }

    public void setPinnedPost(Integer pinnedPost) {
        this.pinnedPost = pinnedPost;
    }

    public Integer getLikedComment() {
        return likedComment;
    }

    public void setLikedComment(Integer likedComment) {
        this.likedComment = likedComment;
    }

    public Integer getSharedCollection() {
        return sharedCollection;
    }

    public void setSharedCollection(Integer sharedCollection) {
        this.sharedCollection = sharedCollection;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}