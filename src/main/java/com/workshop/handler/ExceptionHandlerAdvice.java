package com.workshop.handler;

import com.workshop.handler.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorAdvice> resourceNotFound(ResourceNotFoundException exception, HttpServletRequest request) {
        ErrorAdvice error = new ErrorAdvice(Instant.now(), request.getRequestURI(), HttpStatus.NOT_FOUND.value(), exception.getClass().getSimpleName(), exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
