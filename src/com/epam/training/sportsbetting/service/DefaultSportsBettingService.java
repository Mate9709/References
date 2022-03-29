package com.epam.training.sportsbetting.service;

import com.epam.training.sportsbetting.data.DummyDataStore;
import com.epam.training.sportsbetting.domain.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DefaultSportsBettingService implements SportsBettingService{

    DummyDataStore dds = new DummyDataStore();
    public List <Player> initializedPlayers = dds.getPlayerDatastore();
    public List<User> initializedUsers = dds.getUserDataStore();
    public List<Outcome> outcomeDatastore = dds.getOutcomeDatastore();
    public List<SportEvent> sportEventDataStore = dds.getSportEventDataStore();
    public List<Wager> wagerDatastore = dds.getWagerDatastore();
    public List<Bet> betsDataStore = dds.getBetDataStore();
    Player loggedPlayer;

    @Override
    public Player authenticateUser(User login) throws AuthenticationException {
        Player find = new Player();

        for (Player player : initializedPlayers) {
                if (login.getEmail().equals(player.getEmail()) && login.getPassword().equals(player.getPassword())) {
                    loggedPlayer = player;

                return loggedPlayer;
                }
        }
        throw new AuthenticationException("Incorrect email and/or password");
    }

    @Override
    public List<Bet> findAllBets() {
        return dds.findAllBetVariations();
    }

    @Override
    public Wager createWager(Player player, Outcome outcome, BigDecimal amount) throws LowBalanceException {

        Wager wager = new Wager();
        wager.setOutcome(outcome);
        wager.setPlayer(player);
        wager.setCurrency(player.getCurrency());
        wager.setTimeStampCreated(LocalDateTime.now());
        wager.setAmount(amount);
        if(getLoggedPlayer().getBalance().compareTo(amount) < 0){
            throw new LowBalanceException(loggedPlayer.getBalance().toString(), loggedPlayer.getCurrency());
        }
        getLoggedPlayer().setBalance(getLoggedPlayer().getBalance().subtract(amount));
        if(wager.getOutcome().isWin()){
            wager.setWin(true);
        }
        wagerDatastore.add(wager);
        return wager;
    }

    @Override
    public List<Wager> findAllWagers() {
        return wagerDatastore;
    }

    @Override
    public void calculateResults() {
        BigDecimal counter = BigDecimal.valueOf(0);
        for(int i = 0; i < wagerDatastore.size(); i++){

            if(wagerDatastore.get(i).isWin()){

                counter = counter.add(wagerDatastore.get(i).getOutcome().getOdd().multiply(wagerDatastore.get(i).getAmount()));
                wagerDatastore.get(i).getPlayer().setBalance(counter);
            }

        }
    }

    public Player getLoggedPlayer() {
        return loggedPlayer;
    }

    public void setLoggedPlayer(Player loggedPlayer) {
        this.loggedPlayer = loggedPlayer;
    }
}
