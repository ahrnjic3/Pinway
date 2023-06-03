package com.example.userservice.repositories;


import java.util.List;
import java.util.UUID;

import com.example.userservice.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
    List<Role> findAll();
    Role save(Role newRole);

    @Override
    <S extends Role> List<S> saveAll(Iterable<S> entities);
}
