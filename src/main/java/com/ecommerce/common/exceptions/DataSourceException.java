package com.ecommerce.common.exceptions;

public class DataSourceException extends RuntimeException {
    
    public DataSourceException() {
        super("Something went wrong when communicating with the database");
    }

}
