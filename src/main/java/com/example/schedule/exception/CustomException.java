package com.example.schedule.exception;

import lombok.Getter;

@Getter

public class CustomException extends RuntimeException {
    private final ExceptionErrorCode exceptionErrorCode;

    public CustomException(ExceptionErrorCode exceptionErrorCode) {
        super(exceptionErrorCode.getMessage());
        this.exceptionErrorCode = exceptionErrorCode;
    }
}