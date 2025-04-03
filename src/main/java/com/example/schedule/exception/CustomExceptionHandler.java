package com.example.schedule.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice

public class CustomExceptionHandler {

    /**
     * @RequestParm이나 @PathVariable 유효성 실패
     * @param e(ConstraintViolationException) 예외
     * @param request 서블릿
     * @return 상태
     */

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<CustomErrorResponse> handleArgumentNotValidException(ConstraintViolationException e, HttpServletRequest request) {
        log.error("[ValidException 발생] cause:{}, message: {}",
                NestedExceptionUtils.getMostSpecificCause(e),
                e.getMessage());

        ErrorCode errorCode = ExceptionErrorCode.EMAIL_ERROR_MESSAGE;

        CustomErrorResponse response = CustomErrorResponse.builder()
                .message(errorCode.getMessage())
                .path(request.getRequestURI())
                .timeStamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /**
     * @Vaild 유효성 검사
     * @param e MethodArgumentNotValidException 예외
     * @param request 서블릿
     * @return 상태
     */

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorResponse> handleArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        log.error("[MethodArgumentNotValidException 발생] cause:{}, path: {}",
                NestedExceptionUtils.getMostSpecificCause(e),
                e.getMessage());

        ErrorCode errorCode = ExceptionErrorCode.DEFAULT_ERROR_MESSAGE;

        CustomErrorResponse response = CustomErrorResponse.builder()
                .message(errorCode.getMessage())
                .path(request.getRequestURI())
                .timeStamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
