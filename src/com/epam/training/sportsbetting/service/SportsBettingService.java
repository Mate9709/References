package com.epam.training.sportsbetting.service;

import com.epam.training.sportsbetting.domain.*;

import java.math.BigDecimal;
import java.util.List;

public interface SportsBettingService {

    public Player authenticateUser(User user);
    public List<Bet> findAllBets();
    public Wager createWager(Player player, Outcome outcome, BigDecimal amount);
    public List<Wager> findAllWagers();
    public void calculateResults();
}
