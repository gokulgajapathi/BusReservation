package com.gokul;
import java.text.ParseException;
import java.util.*;

public class Booking {
    String passengerName;
    int busNo;
    String date;

    Booking(){
        this("default name",0,"default date");

    }

    public Booking(String passengerName, int busNo, String date) {
        this.busNo = busNo;
        this.passengerName=passengerName;
        this.date=date;
    }

    public Booking newBooking(Bus busNo1, Bus busNo2, Bus busNo3,Booking b) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter bus no:");
        System.out.println("1.Chennai, capacity: "+busNo1.getCapacity());
        System.out.println("2.Coimbatore, capacity: "+busNo2.getCapacity());
        System.out.println("3.Bangalore, capacity: "+busNo3.getCapacity());
        b.busNo = sc.nextInt();
        if(b.busNo>3 || b.busNo<1){
            throw new RuntimeException("Enter correct Bus no!");
        }

        if(b.busNo==busNo1.getBusNo() && busNo1.getCapacity()>0 || b.busNo==busNo2.getBusNo() && busNo2.getCapacity()>0 || b.busNo==busNo3.getBusNo() && busNo3.getCapacity()>0) {
            System.out.println("Enter passenger name");
            b.passengerName = sc.next();
            System.out.println("Enter Date dd-mm-yyyy");
            b.date = sc.next();

            System.out.println("please wait..");
            return b;
        } else{
            throw new RuntimeException("Sorry bus capacity is full! Try another bus");
        }
    }

    public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {

        int busNoCheckIndex =0;

        for(Bus bus:buses){
            if(bus.getCapacity()>0){
                if(bus.getBusNo() == bookings.get(busNoCheckIndex).busNo){
                    System.out.println("bus-class"+bus.getBusNo());
                    System.out.println("booking-class"+bookings.get(busNoCheckIndex).busNo);
                    bus.setCapacity(bus.getCapacity() -1);
                    System.out.println("cap");
                    if (bookings.get(busNoCheckIndex).date.length()==10) {
                        System.out.println("book");
                        return true;
                    } else {
                        bookings.remove(busNoCheckIndex);
                        throw new RuntimeException("Enter correct Bus booking date!");
                    }
                }
            } else {
                throw new RuntimeException("Bus capacity is full, choose another bus!");
            }
        }
        return false;
    }
}
