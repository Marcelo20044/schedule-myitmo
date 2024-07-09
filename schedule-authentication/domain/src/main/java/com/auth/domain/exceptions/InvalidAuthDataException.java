package com.auth.domain.exceptions;

public class InvalidAuthDataException extends RuntimeException{
    public InvalidAuthDataException() {
    }

    public InvalidAuthDataException(String message) {
        super(message);
    }
}
