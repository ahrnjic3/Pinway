package com.example.notificationservice;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface NotificationTypeRepository extends CrudRepository<NotificationType, Integer> {

}