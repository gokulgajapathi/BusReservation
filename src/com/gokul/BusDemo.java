package com.gokul;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;

public class BusDemo {

    public static void main(String[] args) throws SQLException {

        BusDAO busdao = new BusDAO();
        busdao.displayBusInfo();

        String userOpt;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter \"Start\" to book and \"Stop\" to exit");
        userOpt = sc.nextLine();

        while(true){

            if(userOpt.toLowerCase().equals("start")){
                System.out.println("===============================");
                System.out.println("Welcome to ");
                Booking booking = new Booking();
                if(booking.isAvailable()) {
                    BookingDAO bookingdao = new BookingDAO();
                    bookingdao.addBooking(booking);
                    System.out.println("Your booking is confirmed");
                } else {
                    throw new RuntimeException("Capacity is full!");
                }
            }else {
                System.out.println("---------you are exit---------------");
                break;
            }
        }
        sc.close();
    }
}
