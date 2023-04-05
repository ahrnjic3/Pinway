package com.example.collectionservice.repositories;

import com.example.collectionservice.models.Collection;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CollectionRepository extends CrudRepository<Collection, Integer> {
    List<Collection> findAll();
}