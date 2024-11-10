package com.example.newSystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RestTemplateException extends RuntimeException {
    public RestTemplateException(String message) {
        super(message);
    }
}