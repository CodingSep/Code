package com.jpmc.theater.web;

import com.jpmc.theater.model.ReservationRequest;
import com.jpmc.theater.model.Showing;
import com.jpmc.theater.services.DiscountService;
import com.jpmc.theater.services.ReservationService;
import com.jpmc.theater.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TheaterController {

    @Autowired
    ScheduleService scheduleService;
    @Autowired
    ReservationService reservationService;
    @Autowired
    DiscountService discountService;

    @GetMapping("/getJsonSchedule")
    public List<ScheduleResponse> getJsonSchedule(){
        return scheduleService.getScheduleJsonResponse();
    }

    @GetMapping(value = "/getTextSchedule", produces = "text/plain")
    public String getTextSchedule(){
        return scheduleService.getScheduleTextResponse().toString();
    }

    @PostMapping(value = "/reservation", produces = "application/json")
    public ReservationResponse reserve(@RequestBody ReservationRequest request){
       return reservationService.reserve(request);
    }

    @PostMapping(value = "/calculateTicketPrice")
    public double calculateTicketPrice(@RequestParam int showSequence){
        return discountService.calculateTicketPrice(showSequence);
    }


}
