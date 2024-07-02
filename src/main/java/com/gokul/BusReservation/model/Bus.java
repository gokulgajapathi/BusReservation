package com.gokul.BusReservation.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Bus {

    private  int busNo;
    private boolean ac;
    private int capacity;
    private String driverName;
    private String startingPoint;
    private String endingPoint;
    private int stops;
    private double fare;
    private List<BusRoute> route = getRoute();// this is null

    public boolean isAc() {
        return ac;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public int getStops() {
        return stops;
    }

    public void setStops(int stops) {
        this.stops = stops;
    }


    public List<BusRoute> getRoute() {
        return route;
    }


    public void setRoute(List<BusRoute> route) {
        this.route = route;
    }

    Bus(int busNo, boolean ac, int capacity){
        this.busNo = busNo;
        this.ac = ac;
        this.capacity = capacity;
    }

    public Bus() {
        this(0,true,0);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setBusNo(int busNo) {
        this.busNo = busNo;
    }

    public int getBusNo() {
        return busNo;
    }

    public boolean getAc() {
        return ac;
    }

    public void setAc(boolean ac) {
        this.ac = ac;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }


    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    @Override
    public String toString() {
        int stops = getStops();
        int busNo = getBusNo();
        String[] stopName;
        String[] stopTime;
        StringBuilder str = new StringBuilder();
        stopName=getStopName(stops,busNo);
        stopTime=getStopTime(stops,busNo);

        for (int i = 0; i < stops; i++) {
            str.append("stop name=").append(stopName[i]).append("-> stop time").append(stopTime[i]).append("\n");
        }

        return "Bus{" +
                "bus no=" + getBusNo() +
                ", ac=" + isAc() +
                ", capacity=" + getCapacity() +
                ", driver name='" + getDriverName() +
                ", starting point='" + getStartingPoint() +
                ", ending point='" + getEndingPoint() +
                ", stops=" + getStops() +
                ", fare=" + getFare() +"\n"+str;

    }

    private String[] getStopTime(int stops, int busNo) {
        String[] str = new String[stops];
        int i = 0;
        for(BusRoute getValue : route) {
            if(busNo==getValue.getBusNo() && i<stops) {
                str[i++] = getValue.getStopTime().toString();
            }
        }
        return str;
    }

    private String[] getStopName(int stops, int busNo) {
        String[] str = new String[stops];
        int i = 0;
        for(BusRoute getValue : route) {
            if(busNo==getValue.getBusNo() && i<stops) {
                str[i++] = getValue.getStopName();
            }
        }
        return str;
    }

    public String getEndingPoint() {
        return endingPoint;
    }

    public void setEndingPoint(String endingPoint) {
        this.endingPoint = endingPoint;
    }
}
