package com.gokul.BusReservation.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@Scope("prototype")
public class BusRoute {

    private String stopName;
    private LocalTime time;
    private int busNo;

    @Override
    public String toString() {
        return "com.gokul.BusReservation.model.BusRoute{" +
                "stopName='" + getStopName() + '\'' +
                ", time=" + getTime() +
                '}';
    }

    public int getBusNo() {
        return busNo;
    }

    public void setBusNo(int busNo) {
        this.busNo = busNo;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalTime getStopTime() {
        return time;
    }

    public void setStopTime(LocalTime time) {
        this.time = time;
    }
    

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }
}
