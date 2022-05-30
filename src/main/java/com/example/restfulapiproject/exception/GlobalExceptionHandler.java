package com.example.restfulapiproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidIdException.class)
    public ResponseEntity handleInvalidIdException() {
        return new ResponseEntity("Invalid id, try again with a valid id.", HttpStatus.NOT_FOUND);
    }

}
