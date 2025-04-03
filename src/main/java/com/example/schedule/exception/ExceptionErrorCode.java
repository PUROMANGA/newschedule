package com.example.schedule.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor

public enum ExceptionErrorCode implements ErrorCode {
    EMAIL_ERROR_MESSAGE(HttpStatus.BAD_REQUEST,"옳바른 이메일 형식이 아닙니다."),
    PATHVARIABLE_ERROR( HttpStatus.BAD_REQUEST, "옳바른 경로가 아닙니다."),
    DEFAULT_ERROR_MESSAGE(HttpStatus.BAD_REQUEST,  "옳바른 형식이 아닙니다."),
    LOGIN_ERROR_MESSAGE(HttpStatus.BAD_REQUEST,  "로그인 정보가 다릅니다"),
    FINDID_ERROR_MESSAGE(HttpStatus.BAD_REQUEST,  "해당 ID에 대한 정보가 없습니다.");

    private final HttpStatus httpStatus;
    private final String message;

    @Override
    public HttpStatus gethttpStatus() {
        return httpStatus;
    }
}
