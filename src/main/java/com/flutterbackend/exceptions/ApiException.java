package com.flutterbackend.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ApiException {

    private final boolean success = false;
    private final String message;
    private final HttpStatus httpStatus;
    private final LocalDateTime timestamp;

}