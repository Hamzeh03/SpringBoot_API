package com.hamzehSBJ.API.exception;

public class InvalidPageException extends RuntimeException {

    public InvalidPageException(int page) {
        super("Page number '" + page + "' is invalid.");
    }
}
