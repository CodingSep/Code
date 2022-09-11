package com.jpmc.theater.web;

import com.jpmc.theater.model.Customer;

public class ReservationResponse {
    private Customer customer;
    private ScheduleResponse schedule;
    private int audienceCount;

    public ReservationResponse(Customer customer, ScheduleResponse schedule, int audienceCount) {
        this.customer = customer;
        this.schedule = schedule;
        this.audienceCount = audienceCount;
    }

    public ReservationResponse() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public ScheduleResponse getSchedule() {
        return schedule;
    }

    public int getAudienceCount() {
        return audienceCount;
    }

    public double totalFee() {
        return schedule.getTicketPrice() * audienceCount;
    }

}
