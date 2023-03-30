package com.example.postservice.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PostDTO {
    private Long Id;
    @Size(min = 1, message = "Title must contain at least 1 character")
    @Size(max = 50, message = "Title must contain less than 50 characters")
    private String title;
    @Size(max = 500, message = "Title must contain less than 50 characters")
    private String description;

    @NotBlank(message = "Image is mandatory")
    private String image_path;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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
}
