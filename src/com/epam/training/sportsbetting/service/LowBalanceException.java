package com.epam.training.sportsbetting.service;

import com.epam.training.sportsbetting.domain.Currency;

public class LowBalanceException extends RuntimeException{
    public LowBalanceException(String message, Currency curr) {
        System.out.println("You don't have enough money. Your balance is: " + message + " " +  curr);



    }

}
