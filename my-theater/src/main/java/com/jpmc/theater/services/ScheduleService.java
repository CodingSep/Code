package com.jpmc.theater.services;

import com.jpmc.theater.model.Showing;
import com.jpmc.theater.repository.MovieJPA;
import com.jpmc.theater.repository.ShowingJPA;
import com.jpmc.theater.web.ScheduleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    MovieJPA movieJPA;
    ShowingJPA showingJPA;

    @Autowired
    public ScheduleService(MovieJPA movieJPA, ShowingJPA showingJPA) {
        this.movieJPA = movieJPA;
        this.showingJPA = showingJPA;
    }

    public List<ScheduleResponse> getScheduleJsonResponse() {
        List<Showing> showings = showingJPA.findAll();
        return showings.stream().map(s -> new ScheduleResponse(s.getSequenceOfTheDay(), s.getShowStartTime(), movieJPA.findById(s.getMovieId()).get().getTitle(), movieJPA.findById(s.getMovieId()).get().getRunningTime(), movieJPA.findById(s.getMovieId()).get().getTicketPrice())).collect(Collectors.toList());

    }

    public List<String> getScheduleTextResponse() {
        List<Showing> showings = showingJPA.findAll();
        List<ScheduleResponse> scheduleResponses = showings.stream().map(s -> new ScheduleResponse(s.getSequenceOfTheDay(), s.getShowStartTime(), movieJPA.findById(s.getMovieId()).get().getTitle(), movieJPA.findById(s.getMovieId()).get().getRunningTime(), movieJPA.findById(s.getMovieId()).get().getTicketPrice())).collect(Collectors.toList());
        return scheduleResponses.stream().map(s -> new String(s.getSequenceOfTheDay() + ": " + s.getShowStartTime() + " " + s.getTitle() + " " + humanReadableFormat(s.getRunningTime()) + " $" + s.getTicketPrice())).collect(Collectors.toList());

    }


    public String humanReadableFormat(int duration) {
        long hour = duration / 60;
        long remainingMin = duration % 60;

        return String.format("(%s hour%s %s minute%s)", hour, handlePlural(hour), remainingMin, handlePlural(remainingMin));
    }

    // (s) postfix should be added to handle plural correctly
    private String handlePlural(long value) {
        if (value == 1) {
            return "";
        } else {
            return "s";
        }
    }
}
