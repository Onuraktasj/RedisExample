package com.redis.RedisExample.exception;

import com.redis.RedisExample.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalRestExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorResponse> notFoundExcepton(final Exception exception){
        var customRestError = ErrorResponse.builder()
                .message(exception.getMessage())
                .build();
        return responseEntity(HttpStatus.NOT_FOUND, customRestError);
    }


    @ExceptionHandler(CategoryAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> alreadyExistException(final Exception exception){
        var customRestError = ErrorResponse.builder()
                .message(exception.getMessage())
                .build();
        return responseEntity(HttpStatus.CONFLICT, customRestError);
    }



    private static ResponseEntity<ErrorResponse> responseEntity(HttpStatus httpStatus, ErrorResponse errorResponse){
        return ResponseEntity.status(httpStatus.value())
                .body(errorResponse);
    }


}
