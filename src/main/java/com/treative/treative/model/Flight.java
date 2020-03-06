package com.treative.treative.model;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Flight {

    @Id
    private String id;
    private String departure;
    private String arrival;
    private int seatCount;
    private List<Tourist> touristList;
    private double ticketPrice;

    public Flight() {
    }

    public Flight(String departure, String arrival, int seatCount, List<Tourist> touristList, double ticketPrice) {
        this.departure = departure;
        this.arrival = arrival;
        this.seatCount = seatCount;
        this.touristList = touristList;
        this.ticketPrice = ticketPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public List<Tourist> getTouristList() {
        return touristList;
    }

    public void setTouristList(List<Tourist> touristList) {
        this.touristList = touristList;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
