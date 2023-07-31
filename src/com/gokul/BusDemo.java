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


            if(userOpt.equals("Start")){
                System.out.println("Welcome to ");
                Booking booking = new Booking();
                if(booking.isAvailable(bookings,buses)){
                    bookings.add(booking);
                    System.out.println("Your booking is confirmed");
                }else {
                    System.out.println("Sorry bus is full, Try another bus");
                }
            }else {
                break;
            }
        }
    }
}
