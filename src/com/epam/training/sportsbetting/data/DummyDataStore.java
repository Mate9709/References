package com.epam.training.sportsbetting.data;

import com.epam.training.sportsbetting.domain.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Array;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DummyDataStore {

    public List<Player> playerDatastore = new ArrayList<>();
    public List<Outcome> outcomeDatastore = new ArrayList<>();
    public List<SportEvent> sportEventDataStore = new ArrayList<>();
    public List<Wager> wagerDatastore = new ArrayList<>();
    public List<User> userDataStore = new ArrayList<>();
    public List<Bet> betDataStore = new ArrayList<>();


    public DummyDataStore(){
        initUserDatastore();
        initPlayerDatastore();
        initSportEventDatastore();
        initBetDatastore();

    }

    public void initPlayerDatastore(){
        Player player = new Player("Mate_Koma@epam.com","nincsjelszo","Mate",BigDecimal.valueOf(100),Currency.EUR);
        Player player2 = new Player("Balazs_Cservenak@epam.com","nemtudom","Balazs",BigDecimal.valueOf(200),Currency.HUF);
        Player player3 = new Player("Attila_Nagy@epam.com","eztsem","Attila",BigDecimal.valueOf(300),Currency.USD);
        Player player4 = new Player("Gabor_Orosz@epam.com","eztsem","Gabor",BigDecimal.valueOf(240),Currency.HUF);
        Player player5 = new Player("Nandor_Talpai@epam.com","eztsem","Nandor",BigDecimal.valueOf(40),Currency.EUR);
        playerDatastore.add(player);
        playerDatastore.add(player2);
        playerDatastore.add(player3);
        playerDatastore.add(player4);
        playerDatastore.add(player5);

    }
    public void initUserDatastore(){
        User user = new User("Mate_Koma@epam.com","nincsjelszo");
        User user2 = new User("Balazs_Cservenak@epam.com","nemtudom");
        User user3 = new User("Attila_Nagy@epam.com","eztsem");
        User user4 = new User("Gabor_Orosz@epam.com","eztsem");
        User user5 = new User("Nandor_Talpai@epam.com","eztsem");
        userDataStore.add(user);
        userDataStore.add(user2);
        userDataStore.add(user3);
        userDataStore.add(user4);
        userDataStore.add(user5);

    }

    public void initSportEventDatastore(){
        SportEvent sportEvent1 = new FootballSportEvent("Arsenal vs Chelsea", LocalDateTime.of(2016, Month.OCTOBER,16,19,00,00));
        sportEventDataStore.add(sportEvent1);

    }
    public void initBetDatastore(){
        Bet bet1 = new Bet();
        Bet bet2 = new Bet();
        Bet bet3 = new Bet();


        bet1.setSportEvent(sportEventDataStore.get(0));
        bet2.setSportEvent(sportEventDataStore.get(0));
        bet3.setSportEvent(sportEventDataStore.get(0));


        bet1.setDescription("player Oliver Giroud score");
        bet2.setDescription("number of scored goals");
        bet3.setDescription("winner");


        List<Outcome> outcomesForBet1 = new ArrayList<>();
        List<Outcome> outcomesForBet2 = new ArrayList<>();
        List<Outcome> outcomesForBet3 = new ArrayList<>();


        outcomesForBet1.add(createOutcome("1", BigDecimal.valueOf(2), bet1,false));
        outcomesForBet1.add(createOutcome("2",BigDecimal.valueOf(4), bet1,true));
        outcomesForBet2.add(createOutcome("3",BigDecimal.valueOf(3), bet2,true));
        outcomesForBet3.add(createOutcome("Arsenal",BigDecimal.valueOf(2),bet3,true));
        outcomesForBet3.add(createOutcome( "Chelsea", BigDecimal.valueOf(3),bet3,false));

        bet1.setOutcome(outcomesForBet1);
        bet2.setOutcome(outcomesForBet2);
        bet3.setOutcome(outcomesForBet3);

        betDataStore.add(bet1);
        betDataStore.add(bet2);
        betDataStore.add(bet3);
    }
    private Outcome createOutcome(String description, BigDecimal odd, Bet bet, boolean win)

    {

        Outcome outcome = new Outcome();
        outcome.setDescription(description);
        outcome.setOdd(odd);
        outcome.setBet(bet);
        outcome.setWin(win);
        return outcome;

    }
    public List<Bet> findAllBetVariations(){
    List<Bet> allbetVariations = new ArrayList<>();
    List<Bet> bets = getBetDataStore();
        for(int i = 0; i < bets.size(); i++){
        for(int j = 0; j < bets.get(i).getOutcome().size(); j++) {
            List<Outcome> outcome = new ArrayList<>();
            outcome.add(bets.get(i).getOutcome().get(j));
            Bet bet = new Bet(bets.get(i).getSportEvent(), bets.get(i).getDescription(), outcome);
            allbetVariations.add(bet);
        }}
        return allbetVariations;
    }



    public List<Bet> getBetDataStore() {
        return betDataStore;
    }

    public List<User> getUserDataStore() {
        return userDataStore;
    }

    public List<Player> getPlayerDatastore() {
        return playerDatastore;
    }

    public List<Outcome> getOutcomeDatastore() {
        return outcomeDatastore;
    }

    public List<SportEvent> getSportEventDataStore() {
        return sportEventDataStore;
    }

    public List<Wager> getWagerDatastore() {
        return wagerDatastore;
    }

    @Override
    public String toString() {
        return "DummyDataStore{" +
                "playerDatastore=" + playerDatastore +
                ", outcomeDatastore=" + outcomeDatastore +
                ", sportEventDataStore=" + sportEventDataStore +
                ", wagerDatastore=" + wagerDatastore +
                ", userDataStore=" + userDataStore +
                ", betDataStore=" + betDataStore +
                '}';
    }
}
