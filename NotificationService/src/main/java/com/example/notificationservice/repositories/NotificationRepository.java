package com.example.notificationservice.repositories;

import com.example.notificationservice.models.Notification;
import com.example.notificationservice.models.NotificationType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete


public interface NotificationRepository extends CrudRepository<Notification, Integer> {
    List<Notification> findAll();
}