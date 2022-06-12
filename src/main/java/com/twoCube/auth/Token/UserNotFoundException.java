package com.twoCube.auth.Token;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String socialId){
        super(socialId + " NotFoundException");
    }
}
