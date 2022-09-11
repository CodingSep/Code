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
public class ScheduleServiceTest {
    @Mock
    MovieJPA movieJPA;
    @Mock
    ShowingJPA showingJPA;
    @InjectMocks
    ScheduleService scheduleServiceMock;

    @Test
    public void getScheduleJsonResponseTest() {
        Showing showing = Mockito.mock(Showing.class);
        when(showing.getSequenceOfTheDay()).thenReturn(1);
        when(showing.getShowStartTime()).thenReturn(LocalDateTime.now());
        when(showing.getMovieId()).thenReturn(1L);

        Movie movie = Mockito.mock(Movie.class);
        when(movie.getTitle()).thenReturn("Superman");
        when(movie.getTicketPrice()).thenReturn(12.5);
        when(movie.getRunningTime()).thenReturn(90);

        when(showingJPA.findAll()).thenReturn(List.of(showing));
        when(movieJPA.findById(any())).thenReturn(Optional.of(movie));

        assert (scheduleServiceMock.getScheduleJsonResponse().get(0).getTicketPrice() == 12.5);
    }
    //TODO: similarly write testcase of other methods
}
