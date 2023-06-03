package com.example.userservice.controllers;

import com.example.userservice.dto.RoleDTO;
import com.example.userservice.services.RoleService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/roles", produces = MediaType.APPLICATION_JSON_VALUE)
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getRole(@PathVariable final UUID id) {
        return ResponseEntity.ok(roleService.get(id));
    }

    @PostMapping
    public ResponseEntity<UUID> createRole(@RequestBody @Valid final RoleDTO roleDTO) {
        return new ResponseEntity<>(roleService.create(roleDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRole(@PathVariable final UUID id, @RequestBody @Valid final RoleDTO roleDTO) {
        roleService.update(id, roleDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable final UUID id) throws InternalError {
        RoleDTO roleDTO=roleService.get(id);
        if(Objects.equals(roleDTO.getRole(), "Administrator") || Objects.equals(roleDTO.getRole(), "User")){
            throw new InternalError("Administrator and User role can't be deleted");
        }
        else {
            roleService.delete(id);
        }
        return ResponseEntity.ok().build();
    }

}