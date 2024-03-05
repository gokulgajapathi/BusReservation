package com.gokul;

import java.util.Scanner;
import java.util.ArrayList;

public class BusDemo {

    public static void main(String[] args) {

        String userOpt;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter \"Start\" to book and \"Stop\" to exit");
        userOpt = sc.nextLine();
        ArrayList<Bus> buses = new ArrayList<Bus>();
        ArrayList<Booking> bookings = new ArrayList<Booking>();

        buses.add(new Bus(1,true,2));
        buses.add(new Bus(2,false,1));
        buses.add(new Bus(3,true,1));

        for (Bus b:buses) {
            b.displayBusInfo();
        }
        while(true)//In Bus constructor,create variable busName change while(busName.length)
            {


            if(userOpt.toLowerCase().equals("start")){
                System.out.println("===============================");
                System.out.println("Welcome to ");
                Booking booking = new Booking();
                bookings.add(booking.newBooking(buses.get(0),buses.get(1),buses.get(2),new Booking()));
                if(booking.isAvailable(bookings,buses)) {
                    System.out.println("Your booking is confirmed");
                }
            }else {
                System.out.println("---------you are exit---------------");
                break;
            }
        }
    }
}
