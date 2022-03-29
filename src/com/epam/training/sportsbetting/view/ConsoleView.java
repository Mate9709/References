package com.epam.training.sportsbetting.view;

import com.epam.training.sportsbetting.App;
import com.epam.training.sportsbetting.domain.*;
import com.epam.training.sportsbetting.service.DefaultSportsBettingService;

import java.math.BigDecimal;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class ConsoleView implements View {
    public ConsoleView() {
    }

    @Override
    public User readCredentials() {
        System.out.println("Enter player email address:");
        Scanner scanner = new Scanner(System.in);
        String email= scanner.nextLine();
        System.out.println("Enter player password:");
        String password = scanner.nextLine();
        User user = new User(email,password);
        return user;

    }

    @Override
    public void printWelcomeMessage(Player player) {
        System.out.println("Welcome " + player.getName() + "!");
        System.out.println("Your balance is: " + player.getBalance() + " " + player.getCurrency());

    }

    @Override
    public void printOutcomes(List<Bet> bets) {
        int counter = 1;
        for(int i = 0; i < bets.size(); i++){
            System.out.print(counter +": "+  bets.get(i));
            counter++;
        }

    }

    @Override
    public Outcome selectOutcome(List<Bet> bets) {
        System.out.println("What do you want to bet on?" + " (choose a number or q for quit)");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        ;
        if(input.equals("q") || input.equals("Q")){
            return null;
        }
        else {
            int counter = 0;
            for (Bet bet: bets) {
                for (Outcome outcome: bet.getOutcome()) {
                    if (counter == Integer.parseInt(input) - 1 ) {

                        outcome.setBet(bet);
                        return outcome;
                    }
                    counter++;
                }
            }
        }
        throw new RuntimeException();
    }

    @Override
    public BigDecimal requestAmountForBet() {
        System.out.println("What amount do you want to bet on it?");
        Scanner scanner = new Scanner(System.in);
        BigDecimal amount = scanner.nextBigDecimal();
        return amount;
    }

    @Override
    public void printLowBalanceMessage(Player player) {
        System.out.println("You don't have enough money, your balance is: " + player.getBalance() + " "+ player.getCurrency());

    }

    @Override
    public void printWagerSaved(Wager wager) {
        System.out.println("Wager saved for: "+ wager.getOutcome().getBet().getDescription()+"=" + wager.getOutcome().getDescription() + " of " + wager.getOutcome().getBet().getSportEvent().getTitle()  +" Odd:" +  wager.getOutcome().getOdd() + " Amount:" + wager.getAmount() + " is saved!"+"\n");

    }

    @Override
    public void printResults(Player player, List<Wager> wagers) {
        for(int i = 0; i < wagers.size(); i++){
            if(wagers.get(i).getPlayer().equals(player)){
                System.out.println("Wager: " + wagers.get(i).getOutcome().getBet().getDescription()+ "="+ wagers.get(i).getOutcome().getDescription() + " of " +"'"+ wagers.get(i).getOutcome().getBet().getSportEvent().getTitle() +"'" + "[odd: " + wagers.get(i).getOutcome().getOdd() + " amount: " + wagers.get(i).getAmount()+"]" + " win:"+wagers.get(i).getOutcome().isWin());

            }

        }
        System.out.println("Your Balance: " + player.getBalance() +" "+ player.getCurrency());
    }
}
