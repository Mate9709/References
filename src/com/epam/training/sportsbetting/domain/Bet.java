package com.epam.training.sportsbetting.domain;

import java.util.ArrayList;
import java.util.List;

public class Bet {

    private SportEvent sportEvent;
    private String description;
    private List<Outcome> outcome = new ArrayList<>();

    public Bet(){

    }

    public Bet(SportEvent sportEvent, String description, List<Outcome> outcome) {
        this.sportEvent = sportEvent;
        this.description = description;
        this.outcome = outcome;
    }

    public SportEvent getSportEvent() {
        return sportEvent;
    }

    public void setSportEvent(SportEvent sportEvent) {
        this.sportEvent = sportEvent;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public List<Outcome> getOutcome() {
        return outcome;
    }

    public void setOutcome(List<Outcome> outcome) {
        this.outcome = outcome;
    }

    @Override
    public String toString() {
        return "Sport Event: " + sportEvent +
                ",Bet: " + description +
                "," + outcome +
                "\n".replaceAll("]", "").replace("[", "");
    }
}
