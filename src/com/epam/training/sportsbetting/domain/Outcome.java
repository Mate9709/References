package com.epam.training.sportsbetting.domain;

import java.math.BigDecimal;

public class Outcome {

    Bet bet;
    private String description;
    private BigDecimal odd;
    private boolean win;

    public Outcome(){
    }

    public Outcome( Bet bet,String description, BigDecimal odd, boolean win) {
        this.bet = bet;
        this.description = description;
        this.odd = odd;
        this.win = win;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getOdd() {
        return odd;
    }

    public void setOdd(BigDecimal odd) {
        this.odd = odd;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    @Override
    public String toString() {
        return "Outcome: " + description +
                ", Actual odd: " + odd ;
    }
}



