package com.gokul.BusReservation.service;

import com.gokul.BusReservation.model.Bus;
import com.gokul.BusReservation.repo.BusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusService {

    private BusRepo busRepo;



    public void addBus(Bus b) {
        busRepo.save(b);
    }

    public BusRepo getBusRepo() {
        return busRepo;
    }

    @Autowired
    public void setBusRepo(BusRepo busRepo) {
        this.busRepo = busRepo;
    }

    public List<Bus> getBuses() {
        return busRepo.findAll();

    }

    public boolean isAvailable(int busNo) {

        int capacity = busRepo.getCapacity(busNo);
        int booked = busRepo.getBookedCount(busNo);
        int availableSeats = (int) (capacity-(++booked));

        System.out.print("booked tickets:  "+(booked));
        System.out.print(", capacity: "+capacity);
        System.out.println(", Available Seats: "+availableSeats);

        if(availableSeats==0){
            System.out.println("No more booking in this bus, Try another bus!");
        }

        return booked<=capacity;
    }

    public void cancel(int no) {
        busRepo.remove(no);
    }
}
