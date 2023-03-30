package com.example.postservice.Validation;


public class Violation {

    public Violation(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    private final String fieldName;

    private final String message;

}
