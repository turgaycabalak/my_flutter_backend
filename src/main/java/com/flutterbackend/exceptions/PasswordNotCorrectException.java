package com.flutterbackend.exceptions;

public class PasswordNotCorrectException extends RuntimeException{
    public PasswordNotCorrectException(String message) {
        super(message);
    }
}
