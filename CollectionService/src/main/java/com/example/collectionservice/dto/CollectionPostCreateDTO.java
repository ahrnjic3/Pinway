package com.example.collectionservice.dto;

public class CollectionPostCreateDTO {
    private Long postId;

    public CollectionPostCreateDTO() {
    }

    public CollectionPostCreateDTO(Long postId) {
        this.postId = postId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
