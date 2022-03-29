package com.epam.training.sportsbetting.domain;

import java.time.LocalDateTime;

public abstract class SportEvent {


    protected String title;
    protected LocalDateTime startDate;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

}
