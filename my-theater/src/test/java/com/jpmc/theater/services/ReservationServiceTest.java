package com.jpmc.theater.services;

import com.jpmc.theater.model.Customer;
import com.jpmc.theater.model.ReservationRequest;
import com.jpmc.theater.web.ScheduleResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReservationServiceTest {
    @Mock
    ScheduleService scheduleServiceMock;
    @InjectMocks
    ReservationService reservationServiceMock;

    @Test
    public void reserveTest() throws Exception {
        ScheduleResponse scheduleResponse = Mockito.mock(ScheduleResponse.class);
        when(scheduleResponse.getSequenceOfTheDay()).thenReturn(1);
        when(scheduleServiceMock.getScheduleJsonResponse()).thenReturn(List.of(scheduleResponse));

        Customer customer = Mockito.mock(Customer.class);

        ReservationRequest reservationRequest = Mockito.mock(ReservationRequest.class);
        when(reservationRequest.getCustomer()).thenReturn(customer);
        when(reservationRequest.getNumberOfTickets()).thenReturn(5);
        when(reservationRequest.getSequence()).thenReturn(1);

        assert (reservationServiceMock.reserve(reservationRequest).getAudienceCount() == 5);
    }

}
