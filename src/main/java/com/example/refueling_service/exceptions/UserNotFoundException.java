package com.example.refueling_service.exceptions;

public class UserNotFoundException extends RuntimeException{
    UserNotFoundException(String message){
        super(message);
    }
}
