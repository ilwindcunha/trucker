package com.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }
}