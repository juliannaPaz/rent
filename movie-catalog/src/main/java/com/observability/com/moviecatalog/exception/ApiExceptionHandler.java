package com.observability.com.moviecatalog.exception;

import com.observability.com.moviecatalog.service.exception.MovieNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<ApiErrorMessage> missingRequestMovieNotFoundExceptionHandler(final MovieNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiErrorMessage.create(ApiErrorType.NOT_FOUND, exception.getMessage()));
    }
}
