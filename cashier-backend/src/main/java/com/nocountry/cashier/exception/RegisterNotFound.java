package com.nocountry.cashier.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RegisterNotFound extends RuntimeException{

    public RegisterNotFound(String message){
        super(message);
    }
}
