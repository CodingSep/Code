package com.jpmc.theater.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="showing")
public class Showing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Long movieId;
    @Column
    private int sequenceOfTheDay;
    @Column
    private LocalDateTime showStartTime;

    public Showing() {
    }

    public Showing(Long movieId, int sequenceOfTheDay, LocalDateTime showStartTime) {
        this.movieId = movieId;
        this.sequenceOfTheDay = sequenceOfTheDay;
        this.showStartTime = showStartTime;
    }

    public Long getMovieId() {
        return movieId;
    }

    public int getSequenceOfTheDay() {
        return sequenceOfTheDay;
    }

    public LocalDateTime getShowStartTime() {
        return showStartTime;
    }

    public Long getId() {
        return id;
    }


}
