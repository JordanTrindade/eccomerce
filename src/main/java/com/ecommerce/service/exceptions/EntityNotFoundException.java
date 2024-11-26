package com.ecommerce.service.exceptions;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String msg){
        super(msg);
    }

    public EntityNotFoundException(String msg, Throwable cause){
        super(msg, cause);
    }
}
