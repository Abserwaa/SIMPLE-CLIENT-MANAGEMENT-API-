package com.georgia.SimpleClientManagement.Exception;

import org.springframework.http.HttpStatus;

public class ClientException {
    private final String message;
    private final HttpStatus httpStatus;

    public ClientException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
