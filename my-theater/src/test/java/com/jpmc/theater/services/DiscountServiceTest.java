package com.jpmc.theater.services;


import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Showing;
import com.jpmc.theater.repository.MovieJPA;
import com.jpmc.theater.repository.ShowingJPA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DiscountServiceTest {
    @Mock
    MovieJPA movieJPAMock;
    @Mock
    ShowingJPA showingJPAMock;
    @InjectMocks
    DiscountService discountServiceMock;

    @Test
    public void calculateTicketPriceTest() {
        Movie movie = Mockito.mock(Movie.class);
        when(movie.getTicketPrice()).thenReturn(12.5);
        when(movie.getSpecialCode()).thenReturn(0);

        Showing showing = Mockito.mock(Showing.class);
        when(showing.getSequenceOfTheDay()).thenReturn(1);
        when(showing.getShowStartTime()).thenReturn(LocalDateTime.now());

        when(movieJPAMock.findById(any())).thenReturn(Optional.of(movie));
        when(showingJPAMock.findAll()).thenReturn(List.of(showing));

        assert (discountServiceMock.calculateTicketPrice(1) == 9.5);
    }

    @Test
    public void getDiscountTest() {
        Movie movie = Mockito.mock(Movie.class);
        when(movie.getSpecialCode()).thenReturn(0);

        Showing showing = Mockito.mock(Showing.class);
        when(showing.getSequenceOfTheDay()).thenReturn(1);
        when(showing.getShowStartTime()).thenReturn(LocalDateTime.now());

        assert (discountServiceMock.getDiscount(showing, movie) == 3);
    }
}
