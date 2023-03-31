package com.example.notificationservice.controllers;

import com.example.notificationservice.models.Notification;
import com.example.notificationservice.models.NotificationType;
import com.example.notificationservice.services.NotificationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller // This means that this class is a Controller
@RequestMapping(path="/api") // This means URL's start with /api/notification (after Application path)
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping(path="/notifications") // Map ONLY POST Requests
    public @ResponseBody ResponseEntity AddNotification (@Valid @RequestBody Notification requestBody) {
        Notification notification = notificationService.Create(requestBody);
        return ResponseEntity.status(201).body(notification);

    }


    @GetMapping(path="/notifications")
    public @ResponseBody ResponseEntity GetAllNotifications() {
        Iterable<Notification> notificationList = notificationService.List();
        return ResponseEntity.status(200).body(notificationList);
    }

    @GetMapping(path="/notifications/{id}")
    public @ResponseBody ResponseEntity GetDetails( @PathVariable("id") Integer id) {
        Notification notification = notificationService.Details(id);
        return ResponseEntity.status(200).body(notification);
    }

    @DeleteMapping(path="/notifications/{id}")
    public @ResponseBody ResponseEntity Delete(@PathVariable("id") Integer id) {
        notificationService.Delete(id);
        return ResponseEntity.status(204).build();

    }

    @PutMapping("/notifications/{id}")
    public @ResponseBody ResponseEntity Update(@PathVariable("id") Integer id, @Valid @RequestBody Notification requestBody) {
        Notification updated = notificationService.Update(id, requestBody);
        return ResponseEntity.status(200).body(updated);

    }

    @GetMapping(path="/notificationtypes")
    public @ResponseBody ResponseEntity GetAllNotificationTypes() {
        Iterable<NotificationType> notificationTypeList = notificationService.ListNotificationTypes();
        return ResponseEntity.status(200).body(notificationTypeList);

    }
}