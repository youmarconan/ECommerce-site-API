package com.ecommerce.common.exceptions;

public class InvalidRequestException extends RuntimeException {
    
    public InvalidRequestException(String message) {
        super(message);
    }

    public InvalidRequestException() {
        super("Invalid request data provided!");
    }

}
