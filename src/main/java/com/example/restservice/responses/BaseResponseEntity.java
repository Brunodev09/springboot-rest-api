package com.example.restservice.responses;

public abstract class BaseResponseEntity {
    private final long statusCode;
    private final String message;

    public BaseResponseEntity(long statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public long getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}