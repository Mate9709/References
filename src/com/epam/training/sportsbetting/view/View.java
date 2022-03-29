package com.epam.training.sportsbetting.view;

import com.epam.training.sportsbetting.domain.*;

import java.math.BigDecimal;
import java.util.List;

public interface View {

    public User readCredentials();
    public void printWelcomeMessage(Player player);
    public void printOutcomes(List<Bet> bets);
    public Outcome selectOutcome(List<Bet> bets);
    public BigDecimal requestAmountForBet();
    public void printLowBalanceMessage(Player player);
    public void printWagerSaved(Wager wager);
    public void printResults(Player player, List<Wager> wagers);


}
