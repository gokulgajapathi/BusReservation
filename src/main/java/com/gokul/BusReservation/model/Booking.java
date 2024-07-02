package com.gokul.BusReservation.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Booking {

    private int id;
    private int busNo;
    private String passengerName;
    private String destination;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBusNo() {
        return busNo;
    }

    public void setBusNo(int busNo) {
        this.busNo = busNo;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id= " + getId() +
                ", busNo= " + getBusNo() +
                ", passengerName= " + getPassengerName() + '\'' +
                ", destination= " + getDestination() + '\'' +
                ", date= " + getDate() + '}';
    }
}
