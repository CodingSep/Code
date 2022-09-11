package com.jpmc.theater.web;

import java.time.LocalDateTime;
import java.util.Objects;

public class ScheduleResponse {
    private int sequenceOfTheDay;
    private LocalDateTime showStartTime;
    private String title;
    private int runningTime;
    private double ticketPrice;

    public ScheduleResponse() {
    }

    public ScheduleResponse(int sequenceOfTheDay, LocalDateTime showStartTime, String title, int runningTime, double ticketPrice) {
        this.sequenceOfTheDay = sequenceOfTheDay;
        this.showStartTime = showStartTime;
        this.title = title;
        this.runningTime = runningTime;
        this.ticketPrice = ticketPrice;
    }

    public int getSequenceOfTheDay() {
        return sequenceOfTheDay;
    }

    public LocalDateTime getShowStartTime() {
        return showStartTime;
    }

    public String getTitle() {
        return title;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScheduleResponse)) return false;
        ScheduleResponse that = (ScheduleResponse) o;
        return sequenceOfTheDay == that.sequenceOfTheDay &&
                runningTime == that.runningTime &&
                Double.compare(that.ticketPrice, ticketPrice) == 0 &&
                Objects.equals(showStartTime, that.showStartTime) &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sequenceOfTheDay, showStartTime, title, runningTime, ticketPrice);
    }
}
