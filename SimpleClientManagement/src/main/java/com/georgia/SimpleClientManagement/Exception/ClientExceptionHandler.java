package com.georgia.SimpleClientManagement.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ClientExceptionHandler {

    @ExceptionHandler(value = { ClientNotFoundException.class })
    public ResponseEntity<Object> handleClientNotFoundException(ClientNotFoundException clientNotFoundException) {
        ClientException clientException = new ClientException(
                clientNotFoundException.getMessage(),
                HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(clientException, HttpStatus.NOT_FOUND);
    }
}
