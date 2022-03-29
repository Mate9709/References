package com.epam.training.sportsbetting.domain;

import java.time.LocalDateTime;

public class TennisSportEvent extends SportEvent {


    private String title;
    private LocalDateTime startDate;


    public TennisSportEvent(String title, LocalDateTime startDate) {
        this.title = title;
        this.startDate = startDate;
    }

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




    @Override
    public String toString() {
        return "TennisSportEvent{" +
                "title='" + title + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
