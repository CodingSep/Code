package com.jpmc.theater;


import com.jpmc.theater.services.DiscountService;
import com.jpmc.theater.services.ReservationService;
import com.jpmc.theater.services.ScheduleService;
import com.jpmc.theater.web.ReservationResponse;
import com.jpmc.theater.web.ScheduleResponse;
import com.jpmc.theater.web.TheaterController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(value = MockitoJUnitRunner.class)
public class TheaterControllerTest {

    @Mock
    ScheduleService scheduleServiceMock;
    @Mock
    ReservationService reservationServiceMock;
    @Mock
    DiscountService discountServiceMock;
    @InjectMocks
    TheaterController theaterControllerMock;


    @Test
    public void getTestScheduleTest() throws Exception {
        List<String> response = List.of("4: 2012-09-17T18:47:52.069 Superman (1 hour 0 minutes) $25.0", "5: 2012-09-17T18:47:52.079 Spiderman (1 hour 30 minutes) $12.5");
        when(scheduleServiceMock.getScheduleTextResponse()).thenReturn(response);

        assert (theaterControllerMock.getTextSchedule().equals(response.toString()));
    }

    @Test
    public void getJsonScheduleTest() throws Exception {
        ScheduleResponse scheduleResponse = Mockito.mock(ScheduleResponse.class);
        when(scheduleServiceMock.getScheduleJsonResponse()).thenReturn(List.of(scheduleResponse));

        assert (theaterControllerMock.getJsonSchedule().equals(List.of(scheduleResponse)));
    }

    @Test
    public void reservationTest() throws Exception {
        ReservationResponse response = Mockito.mock(ReservationResponse.class);
        when(reservationServiceMock.reserve(any())).thenReturn(response);

        assert (theaterControllerMock.reserve(any()).equals(response));
    }

    @Test
    public void calculateTicketPriceTest() throws Exception {
        when(discountServiceMock.calculateTicketPrice(anyInt())).thenReturn(18.5);

        assert (theaterControllerMock.calculateTicketPrice(5) == 18.5);
    }
}
