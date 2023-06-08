package com.example.notificationservice.dto;

public class CommentInfo {

    private Long id;
    private String content;
    private String message;

    public CommentInfo(Long id, String content, String message) {
        this.id = id;
        this.content = content;
        this.message = message;
    }

    public CommentInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
