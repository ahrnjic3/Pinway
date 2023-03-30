package com.example.postservice.Validation;


public class Violation {

    public Violation() {
        this.fieldName = "";
        this.message = "";
    }

    public Violation(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
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