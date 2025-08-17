package com.hamzehSBJ.API.exception;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(String category) {
        super("Category '" + category + "' not found.");
    }
}
