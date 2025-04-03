package com.example.schedule.exception;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CustomErrorResponse {
    private String message;
    private String path;
    private LocalDateTime timeStamp;

    public CustomErrorResponse(ExceptionErrorCode exceptionErrorCode, String path, LocalDateTime timeStamp) {
        this.message = exceptionErrorCode.getMessage();
        this.path = path;
        this.timeStamp = LocalDateTime.now();
    }
}
