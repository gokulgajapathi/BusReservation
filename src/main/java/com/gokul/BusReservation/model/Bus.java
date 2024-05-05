package com.gokul.BusReservation.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Bus {

    private  int busNo;
    private boolean ac;
    private int capacity;

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


    @Override
    public String toString() {
        return "\n"+"Bus{" +
                "Bus No=" +busNo +
                ", AC=" + (ac ? "Yes" : "No") +
                ", Capacity=" + capacity +
                '}';
    }
}
