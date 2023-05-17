package com.example.userservice.dto;

import java.util.List;

public class UserResponseDTO {
    private UserDTO userDTO;
    private List<CollectionDTO> collectionDTOS;

    public UserResponseDTO(UserDTO userDTO, List<CollectionDTO> collectionDTOS) {
        this.userDTO = userDTO;
        this.collectionDTOS = collectionDTOS;
    }

    public UserResponseDTO() {
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public List<CollectionDTO> getCollectionDTOS() {
        return collectionDTOS;
    }

    public void setCollectionDTOS(List<CollectionDTO> collectionDTOS) {
        this.collectionDTOS = collectionDTOS;
    }
}
