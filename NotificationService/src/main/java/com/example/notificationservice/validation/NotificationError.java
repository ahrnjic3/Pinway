package com.example.notificationservice.validation;
import java.util.Date;

public class NotificationError {

    private Date timestamp;
    private String message;
    private String details;


    public Date getTimestamp() {
        return timestamp;
    }

    public NotificationError setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public NotificationError setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public NotificationError setDetails(String details) {
        this.details = details;
        return this;
    }

    public NotificationError() {
    }
}