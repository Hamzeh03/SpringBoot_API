package com.hamzehSBJ.API.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleCategoryNotFound(CategoryNotFoundException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("code", "CATEGORY_NOT_FOUND");
        error.put("message", ex.getMessage());
        return new ResponseEntity<>(Map.of("error", error), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidPageException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidPage(InvalidPageException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("code", "INVALID_PAGE");
        error.put("message", ex.getMessage());
        return new ResponseEntity<>(Map.of("error", error), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
