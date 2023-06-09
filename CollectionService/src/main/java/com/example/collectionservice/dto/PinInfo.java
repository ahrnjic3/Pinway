package com.example.collectionservice.dto;

public class PinInfo {

    private Long id;

    private Integer collectionId;
    private String message;

    public PinInfo() {
    }

    public PinInfo(Long id, Integer collectionId, String message) {
        this.id = id;
        this.collectionId = collectionId;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
