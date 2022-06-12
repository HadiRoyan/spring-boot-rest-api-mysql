package com.hadroy.SchoolManagementSystem.controller;

import com.hadroy.SchoolManagementSystem.error.NotFoundException;
import com.hadroy.SchoolManagementSystem.model.ResponseError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<Object> validationHandler(ConstraintViolationException constraintViolationException) {
        return new ResponseEntity<>(
                new ResponseError(HttpStatus.BAD_REQUEST.value(),"BAD REQUEST", Arrays.asList(constraintViolationException.getMessage())),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> notFoundHandler(NotFoundException notFoundException) {
        return new ResponseEntity<>(
                new ResponseError(HttpStatus.NOT_FOUND.value(),"NOT FOUND", Arrays.asList(notFoundException.getMessage())),
                HttpStatus.NOT_FOUND
        );
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }

        return new ResponseEntity<>(
                new ResponseError(HttpStatus.BAD_REQUEST.value(), "BAD REQUEST", errors),
                HttpStatus.BAD_REQUEST
        );
    }
}
