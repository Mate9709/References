package com.epam.training.sportsbetting.domain;

import java.math.BigDecimal;

public class Player extends User{

    private String name;

    private BigDecimal balance;

    private Currency currency;

    public Player(){

    }
    public Player(String email, String password, String name, BigDecimal balance, Currency currency) {
        super(email, password);
        this.name = name;
        this.balance = balance;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", currency=" + currency +
                '}';
    }
}