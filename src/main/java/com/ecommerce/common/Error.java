package com.ecommerce.common;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Error {
    
    private int statusCode;
    private String message;
    private String time;
    

    public Error(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
        this.time = LocalDateTime.now().toString();
    }
    
}
