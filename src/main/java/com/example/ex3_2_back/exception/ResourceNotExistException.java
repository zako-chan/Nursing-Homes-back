package com.example.ex3_2_back.exception;

public class ResourceNotExistException extends RuntimeException {
    public ResourceNotExistException(String message) {
        super(message);
    }
}
