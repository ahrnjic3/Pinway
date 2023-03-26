package com.example.notificationservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class NotificationDataLoader implements CommandLineRunner{

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    NotificationTypeRepository notificationTypeRepository;

    @Override
    public void run(String... args) throws Exception {
        loadNotificationData();
    }

    private void loadNotificationData() {
        if (notificationRepository.count() == 0) {
            Notification notification1 = new Notification();
            notification1.setOpen(false);
            notification1.setContent("User1 Liked your Comment.");
            notification1.setLikedComment(0);
            notification1.setActionUserId(1);
            notification1.setUserId(3);

            Iterable<NotificationType> notificationTypes = notificationTypeRepository.findAll();
            notification1.setNotificationType(notificationTypes.iterator().next());

            notificationRepository.save(notification1);
        }
        System.out.println(notificationRepository.count());
    }
}
