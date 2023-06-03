package com.example.userservice.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RoleDTO {

    private UUID id;
    @NotBlank(message = "Name can't be blank")
    private String role;

    public RoleDTO() {
    }

    public RoleDTO(String role) {
        this.role = role;
    }
}