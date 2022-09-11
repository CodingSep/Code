package com.jpmc.theater.services;

import com.jpmc.theater.model.ReservationRequest;
import com.jpmc.theater.web.ReservationResponse;
import com.jpmc.theater.web.ScheduleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    @Autowired
    ScheduleService scheduleService;
    private List<ScheduleResponse> scheduleResponses;

    public ReservationResponse reserve(ReservationRequest request) {
        try {
            scheduleResponses = scheduleService.getScheduleJsonResponse().stream().filter(s -> s.getSequenceOfTheDay() == request.getSequence()).collect(Collectors.toList());
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            throw new IllegalStateException("not able to find any showing for given sequence " + request.getSequence());
        }
        return new ReservationResponse(request.getCustomer(), !scheduleResponses.isEmpty() ? scheduleResponses.get(0) : new ScheduleResponse(), request.getNumberOfTickets());
    }

}
