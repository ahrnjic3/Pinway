package com.example.notificationservice.controllers;

import com.example.notificationservice.models.Notification;
import com.example.notificationservice.models.NotificationType;
import com.example.notificationservice.services.NotificationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller // This means that this class is a Controller
@RequestMapping(path="/api") // This means URL's start with /api/notification (after Application path)
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping(path="/notifications") // Map ONLY POST Requests
    public @ResponseBody ResponseEntity AddNotification (@Valid @RequestBody Notification requestBody) {
        try {
            Notification notification = notificationService.Create(requestBody);
            return ResponseEntity.status(201).body(notification);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Something went wrong");
        }
    }


    @GetMapping(path="/notifications/all")
    public @ResponseBody ResponseEntity GetAllNotifications() {
        try {
            Iterable<Notification> notificationList = notificationService.List();
            return ResponseEntity.status(200).body(notificationList);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Something went wrong");
        }
    }

    @GetMapping(path="/notifications")
    public @ResponseBody ResponseEntity GetDetails(@RequestParam Integer id) {
        try {
            Optional<Notification> notification = notificationService.Details(id);
            return ResponseEntity.status(200).body(notification);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Something went wrong");
        }
    }

    @DeleteMapping(path="/notifications")
    public @ResponseBody ResponseEntity Delete(@RequestParam Integer id) {
        try {
            boolean deleted = notificationService.Delete(id);
            return ResponseEntity.status(200).body(deleted);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Something went wrong");
        }
    }

    @PutMapping("/notifications")
    public @ResponseBody ResponseEntity Update(@RequestParam Integer id, @Valid @RequestBody Notification requestBody) {
        try {
            boolean updated = notificationService.Update(id, requestBody);
            return ResponseEntity.status(200).body(updated);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Something went wrong");
        }
    }

    @PostMapping(path="/notificationtypes") // Map ONLY POST Requests
    public @ResponseBody ResponseEntity AddNotificationType (@Valid @RequestBody NotificationType requestBody) {
        try {
            NotificationType notificationType = notificationService.CreateNotificationType(requestBody);
            return ResponseEntity.status(201).body(notificationType);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Something went wrong");
        }
    }

    @GetMapping(path="/notificationtypes/all")
    public @ResponseBody ResponseEntity GetAllNotificationTypes() {
        try {
            Iterable<NotificationType> notificationTypeList = notificationService.ListNotificationTypes();
            return ResponseEntity.status(200).body(notificationTypeList);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Something went wrong");
        }
    }
}