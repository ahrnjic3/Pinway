package com.example.notificationservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

@Component
public class NotificationTypeDataLoader implements CommandLineRunner{

    @Autowired
    NotificationTypeRepository notificationTypeRepository;

    @Override
    public void run(String... args) throws Exception {
        loadNotificationData();
    }

    private void loadNotificationData() {
        if (notificationTypeRepository.count() == 0) {
            NotificationType notificationType1 = new NotificationType();
            notificationType1.setType("SHARED");
            NotificationType notificationType2 = new NotificationType();
            notificationType2.setType("LIKED");
            NotificationType notificationType3 = new NotificationType();
            notificationType3.setType("FOLLOWED");
            NotificationType notificationType4 = new NotificationType();
            notificationType4.setType("PINED");

            notificationTypeRepository.save(notificationType1);
            notificationTypeRepository.save(notificationType2);
            notificationTypeRepository.save(notificationType3);
            notificationTypeRepository.save(notificationType4);
        }
        System.out.println(notificationTypeRepository.count());
    }
}
