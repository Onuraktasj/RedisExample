package com.redis.RedisExample.exception;

public class CategoryAlreadyExistException extends RuntimeException {

    private final String messsage;

    public CategoryAlreadyExistException(String message){
        this.messsage = message;
    }

    @Override
    public String getMessage(){
        return messsage;
    }

}
