package org.example.exceptions;

public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException(String message) {
        super(message);
    }
}
