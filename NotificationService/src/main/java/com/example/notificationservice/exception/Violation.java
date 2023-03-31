package com.example.notificationservice.exception;

public class Violation {

    public Violation(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public Violation() {
        this.fieldName = "";
        this.message = "";
    }

    private final String fieldName;

    private final String message;

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }
}