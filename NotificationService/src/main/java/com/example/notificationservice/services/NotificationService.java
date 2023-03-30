package com.example.notificationservice.services;


import com.example.notificationservice.models.Notification;
import com.example.notificationservice.models.NotificationType;

import java.util.List;
import java.util.Optional;

public interface NotificationService {
    Notification Create(Notification notification);

    Iterable<Notification> List();

    Optional<Notification> Details(Integer id);

    boolean Delete(Integer id);

    boolean Update(Integer id, Notification notification);

    NotificationType CreateNotificationType(NotificationType notificationType);

    Iterable<NotificationType> ListNotificationTypes();


}
