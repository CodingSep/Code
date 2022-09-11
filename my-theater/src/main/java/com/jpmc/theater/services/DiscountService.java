package com.jpmc.theater.services;

import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Showing;
import com.jpmc.theater.repository.MovieJPA;
import com.jpmc.theater.repository.ShowingJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DiscountService {
    @Autowired
    MovieJPA movieJPA;
    @Autowired
    ShowingJPA showingJPA;
    private static int MOVIE_CODE_SPECIAL = 1;

    public double getDiscount(Showing showing, Movie movie) {

        double discount = 0;

        if (MOVIE_CODE_SPECIAL == movie.getSpecialCode()) {
            discount = movie.getTicketPrice() * 0.2; // 20% discount for special movie
        }
        if (showing.getSequenceOfTheDay() == 1 && discount < 3) {
            discount = 3;
        }
        if (showing.getSequenceOfTheDay() == 2 && discount < 2) {
            discount = 2;
        }
        if (showing.getSequenceOfTheDay() == 7 && discount < 1) {
            discount = 1;
        }
        if (showing.getShowStartTime().getHour() >= 11 && showing.getShowStartTime().getHour() <= 16) {
            discount = movie.getTicketPrice() * 0.25 > discount ? movie.getTicketPrice() * 0.25 : discount;
        }
        return discount;
    }

    public double calculateTicketPrice(int showSequence) {
        Optional<Showing> showing = showingJPA.findAll().stream().filter(s -> s.getSequenceOfTheDay() == showSequence).findFirst();
        Optional<Movie> movie = movieJPA.findById(showing.get().getMovieId());
        return movie.get().getTicketPrice() - getDiscount(showing.get(), movie.get());
    }
}
