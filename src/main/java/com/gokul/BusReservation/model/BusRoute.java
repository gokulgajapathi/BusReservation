package com.gokul.BusReservation.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@Scope("prototype")
public class BusRoute {
    private char stopName;
    private LocalTime time;

    public BusRoute(char stopName, LocalTime time) {
        this.stopName= stopName;
        this.time=time;
    }


    public LocalTime getStopTime() {
        return time;
    }


    public void setStopTime(LocalTime time) {
        this.time = time;
    }
    

    public char getStopName() {
        return stopName;
    }


    public void setStopName(char stopName) {
        this.stopName = stopName;
    }


}
