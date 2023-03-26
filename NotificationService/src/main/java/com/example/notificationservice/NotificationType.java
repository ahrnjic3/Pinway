package com.example.notificationservice;

import jakarta.persistence.*;

import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
public class NotificationType {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String type;


    @OneToMany(mappedBy = "notificationType")
    private List<Notification> notifications;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

}
