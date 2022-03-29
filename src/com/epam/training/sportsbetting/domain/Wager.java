package com.epam.training.sportsbetting.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Wager {
    private Currency currency;
    private Player player;
    private Outcome outcome;
    private BigDecimal amount;
    private LocalDateTime timeStampCreated;
    private boolean win;
    private boolean processed;

    public Wager(){}
    public Wager(Player player, BigDecimal amount, Currency currency,Outcome outcome,  LocalDateTime timeStampCreated, boolean win, boolean processed) {
        this.currency = currency;
        this.player = player;
        this.outcome = outcome;
        this.amount = amount;
        this.timeStampCreated = timeStampCreated;
        this.win = win;
        this.processed = processed;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimeStampCreated() {
        return timeStampCreated;
    }

    public void setTimeStampCreated(LocalDateTime timeStampCreated) {
        this.timeStampCreated = timeStampCreated;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    @Override
    public String toString() {
        return "Wager{" +
                "currency=" + currency +
                ", player=" + player +
                ", outcome=" + outcome +
                ", amount=" + amount +
                ", timeStampCreated=" + timeStampCreated +
                ", win=" + win +
                ", processed=" + processed +
                '}';
    }
}