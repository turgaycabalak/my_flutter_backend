package com.flutterbackend.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException e) {
        // 1. Create payload containing exception details
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(
                e.getMessage(),
                httpStatus,
                LocalDateTime.now()
        );
        // 2. Return response entity
        return new ResponseEntity<>(apiException, httpStatus);
    }

    @ExceptionHandler(PasswordNotCorrectException.class)
    public ResponseEntity<Object> handlePasswordNotCorrectException(PasswordNotCorrectException e) {
        // 1. Create payload containing exception details
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(
                e.getMessage(),
                httpStatus,
                LocalDateTime.now()
        );
        // 2. Return response entity
        return new ResponseEntity<>(apiException, httpStatus);
    }

}
