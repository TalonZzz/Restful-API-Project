package com.example.restfulapiproject.exception;

public class InvalidIdException extends RuntimeException{
    public InvalidIdException(String errorMessage) {
        super(errorMessage);
    }
}
