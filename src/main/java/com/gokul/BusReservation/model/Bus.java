package com.gokul.BusReservation.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class Bus {

    private  int busNo;
    private boolean ac;
    private int capacity;
    private String driverName;
    private String startingPoint;
    private String endingPoint;


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

    public String getEndingPoint() {
        return endingPoint;
    }

    public void setEndingPoint(String endingPoint) {
        this.endingPoint = endingPoint;
    }




    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bus{")
                .append("busNo=").append(busNo)
                .append(", ac=").append(ac)
                .append(", capacity=").append(capacity)
                .append(", driverName='").append(driverName).append('\'')
                .append(", startingPoint='").append(startingPoint).append('\'')
                .append(", endingPoint='").append(endingPoint).append('\'').append("]}");

        stringBuilder.append('\n');

        return stringBuilder.toString();
    }

}
