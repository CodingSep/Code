package com.jpmc.theater.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long movieId;
    @Column(name="title")
    private String title;
    @Column(name="description")
    private String description;
    @Column(name="runningTime")
    private int runningTime;
    @Column(name="ticketPrice")
    private double ticketPrice;
    @Column(name="specialCode")
    private int specialCode;

    public Movie() {
    }

    public Movie(String title, String description, int runningTime, double ticketPrice, int specialCode) {
        this.title = title;
        this.description = description;
        this.runningTime = runningTime;
        this.ticketPrice = ticketPrice;
        this.specialCode = specialCode;
    }

    public Long getMoiveId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public int getSpecialCode() {
        return specialCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.ticketPrice, ticketPrice) == 0 &&
                specialCode == movie.specialCode &&
                Objects.equals(title, movie.title) &&
                Objects.equals(description, movie.description) &&
                Objects.equals(runningTime, movie.runningTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, description, runningTime, ticketPrice, specialCode);
    }
}
