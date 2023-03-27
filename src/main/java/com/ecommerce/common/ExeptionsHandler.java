package com.ecommerce.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ecommerce.common.exceptions.DataSourceException;
import com.ecommerce.common.exceptions.InvalidRequestException;
import com.ecommerce.common.exceptions.IsAlreadyExist;


@RestControllerAdvice
public class ExeptionsHandler {
    
    @ExceptionHandler({IsAlreadyExist.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public Error handleAuthenticationException(IsAlreadyExist e){

        return new Error(409, e.getMessage());
    }

    @ExceptionHandler({InvalidRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handleInvalidRequestException(InvalidRequestException e){

        return new Error(400, e.getMessage());
    }

    @ExceptionHandler({DataSourceException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public Error handleDataSourceException(DataSourceException e){

        return new Error(500, e.getMessage());
    }
}
