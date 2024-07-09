package com.igdy.igeodaeyeo.global.exception;

import com.igdy.igeodaeyeo.global.entity.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException e) {
        return toResponse(e.getErrorCode(), e.getMessage());
    }

    private static ResponseEntity<ApiResponse<Void>> toResponse(ErrorCode errorCode, String message) {
        return ResponseEntity.status(errorCode.getHttpStatus())
                .body(new ApiResponse<>(errorCode.getHttpStatus().value(), message, null));
    }
}
