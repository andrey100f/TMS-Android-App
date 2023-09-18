package com.example.tms_app.models.exceptions.models;

public class ExceptionModel {
    private final Integer statusCode;
    private final String message;

    public ExceptionModel(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
