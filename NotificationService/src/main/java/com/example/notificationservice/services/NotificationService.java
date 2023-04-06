package com.example.notificationservice.services;


import com.example.notificationservice.models.Notification;
import com.example.notificationservice.models.NotificationType;

import java.util.List;
import java.util.Optional;

public interface NotificationService {
    Notification Create(Notification notification);

    Iterable<Notification> List();

    Notification Details(Integer id);

    Boolean Delete(Integer id);

    Notification Update(Integer id, Notification notification);

    Iterable<NotificationType> ListNotificationTypes();

    Iterable<Notification> List10NotificationsByOpen();


}
