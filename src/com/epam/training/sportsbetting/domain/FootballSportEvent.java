package com.epam.training.sportsbetting.domain;

import java.time.LocalDateTime;

public class FootballSportEvent extends SportEvent{


    private String title;
    private LocalDateTime startDate;

    public FootballSportEvent(){

    }

    public FootballSportEvent(String title, LocalDateTime startDate) {
        this.title = title;
        this.startDate = startDate;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public LocalDateTime getStartDate() {
        return startDate;
    }

    @Override
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return
               title + " "+ "(start date: "+
                startDate +") ";
    }
}
