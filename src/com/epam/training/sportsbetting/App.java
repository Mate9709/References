package com.epam.training.sportsbetting;

import com.epam.training.sportsbetting.data.DummyDataStore;
import com.epam.training.sportsbetting.domain.Outcome;
import com.epam.training.sportsbetting.domain.Player;
import com.epam.training.sportsbetting.domain.User;
import com.epam.training.sportsbetting.domain.Wager;
import com.epam.training.sportsbetting.service.AuthenticationException;
import com.epam.training.sportsbetting.service.DefaultSportsBettingService;
import com.epam.training.sportsbetting.service.LowBalanceException;
import com.epam.training.sportsbetting.view.ConsoleView;
import com.epam.training.sportsbetting.view.View;

import java.math.BigDecimal;
import java.util.List;

public class App {
    public static void main(String[] args) {
        DummyDataStore dds = new DummyDataStore();
        ConsoleView view = new ConsoleView();
        DefaultSportsBettingService dsbs = new DefaultSportsBettingService();

        while(true) {
            try {
                dsbs.authenticateUser(view.readCredentials());
                if(dsbs.getLoggedPlayer() != null){
                    break;
                }


            } catch (AuthenticationException ae) {
                ae.printStackTrace();
            }
        }
        if (dsbs.getLoggedPlayer() != null) {
            view.printWelcomeMessage(dsbs.getLoggedPlayer());
            while (true) {
                view.printOutcomes(dsbs.findAllBets());
                Outcome currentOutcome = view.selectOutcome(dsbs.findAllBets());

                if (currentOutcome == null) {
                    break;
                }
                BigDecimal amount = view.requestAmountForBet();
                try {
                    Wager wager = dsbs.createWager(dsbs.getLoggedPlayer(), currentOutcome, amount);
                    view.printWagerSaved(wager);
                } catch (LowBalanceException lowBalanceException) {
                    lowBalanceException.printStackTrace();
                }

            }
            dsbs.calculateResults();
            view.printResults(dsbs.getLoggedPlayer(), dsbs.findAllWagers());
        }

    }







    }
