package com.roomer.app.exception.controller;

import com.roomer.app.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFound(UserNotFoundException e) {
        // logic handling what should be seen by user
        // for now there is only String passed to the user informing about the exception
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
