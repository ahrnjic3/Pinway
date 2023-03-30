package com.example.notificationservice.validation;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotificationResponse <T> {

    public enum Status {
        OK,
        BAD_REQUEST,
        UNAUTHORIZED,
        VALIDATION_EXCEPTION,
        EXCEPTION,
        WRONG_CREDENTIALS,
        ACCESS_DENIED,
        NOT_FOUND,
        DUPLICATE_ENTITY
    }

    private Status status;
    private T payload;
    private List<Object> errors = new ArrayList<>();
    private Object metadata;

    public static <T> NotificationResponse<T> badRequest() {
        NotificationResponse<T> response = new NotificationResponse<>();
        response.setStatus(Status.BAD_REQUEST);
        return response;
    }

    public static <T> NotificationResponse<T> ok() {
        NotificationResponse<T> response = new NotificationResponse<>();
        response.setStatus(Status.OK);
        return response;
    }

    public static <T> NotificationResponse<T> unauthorized() {
        NotificationResponse<T> response = new NotificationResponse<>();
        response.setStatus(Status.UNAUTHORIZED);
        return response;
    }

    public static <T> NotificationResponse<T> validationException() {
        NotificationResponse<T> response = new NotificationResponse<>();
        response.setStatus(Status.VALIDATION_EXCEPTION);
        return response;
    }

    public static <T> NotificationResponse<T> wrongCredentials() {
        NotificationResponse<T> response = new NotificationResponse<>();
        response.setStatus(Status.WRONG_CREDENTIALS);
        return response;
    }

    public static <T> NotificationResponse<T> accessDenied() {
        NotificationResponse<T> response = new NotificationResponse<>();
        response.setStatus(Status.ACCESS_DENIED);
        return response;
    }

    public static <T> NotificationResponse<T> exception() {
        NotificationResponse<T> response = new NotificationResponse<>();
        response.setStatus(Status.EXCEPTION);
        return response;
    }

    public static <T> NotificationResponse<T> notFound() {
        NotificationResponse<T> response = new NotificationResponse<>();
        response.setStatus(Status.NOT_FOUND);
        return response;
    }

    public static <T> NotificationResponse<T> duplicateEntity() {
        NotificationResponse<T> response = new NotificationResponse<>();
        response.setStatus(Status.DUPLICATE_ENTITY);
        return response;
    }

    public Status getStatus() {
        return status;
    }

    public NotificationResponse setStatus(Status status) {
        this.status = status;
        return this;
    }

    public T getPayload() {
        return payload;
    }

    public NotificationResponse setPayload(T payload) {
        this.payload = payload;
        return this;
    }

    public Object getErrors() {
        return errors;
    }

    public NotificationResponse setErrors(List<Object> errors) {
        this.errors = errors;
        return this;
    }

    public Object getMetadata() {
        return metadata;
    }

    public NotificationResponse setMetadata(Object metadata) {
        this.metadata = metadata;
        return this;
    }

    public NotificationResponse addErrorMsgToResponse(String errorMsg, Exception ex) {
        NotificationError error = new NotificationError()
                .setDetails(errorMsg)
                .setMessage(ex.getMessage())
                .setTimestamp(new Date());
        errors.add(error);
        return this;
    }

}