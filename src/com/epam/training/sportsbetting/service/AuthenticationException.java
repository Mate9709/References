package com.epam.training.sportsbetting.service;

public class AuthenticationException extends RuntimeException{
    public AuthenticationException(String errorMessage) {
        System.out.println(errorMessage);
    }
}
