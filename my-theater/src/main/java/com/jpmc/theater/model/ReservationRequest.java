package com.jpmc.theater.model;

public class ReservationRequest {
    private Customer customer;
    private int sequence;
    private int numberOfTickets;

    public ReservationRequest(Customer customer, int sequence, int numberOfTickets) {
        this.customer = customer;
        this.sequence = sequence;
        this.numberOfTickets = numberOfTickets;
    }

    public ReservationRequest() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getSequence() {
        return sequence;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }
}
