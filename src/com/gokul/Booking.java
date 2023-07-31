package com.gokul;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

public class Booking {
    String passengerName;
    static int busNo;
    static Date date;

    Booking(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of passenger: ");
        passengerName = sc.next();
        System.out.println("Enter date dd-mm-yyyy");
        String dataInput = sc.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");


        try {
            dateFormat.parse(dataInput);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
        int capacity = 0;
        Bus capChack = new Bus();
        for(Bus bus:buses){
            if(capChack.getBusNo() == busNo)
                capacity = bus.getCapacity();
        }

        int booked = 0;
        for (Booking b:bookings){
            if (b.busNo == busNo)
                if (b.date.equals(date)) {

                    booked++;
                }
        }
        return booked < capacity ? true : false;
    }
}
