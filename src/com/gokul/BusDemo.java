package com.gokul;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;

public class BusDemo {

    public static void main(String[] args) throws SQLException {

        BusDAO busdao = new BusDAO();
        busdao.displayBusInfo();
        Scanner sc = new Scanner(System.in);

        while (true) {
                System.out.println("===============================");
                System.out.println("Welcome to ");
                Booking booking = new Booking();
                if (booking.isAvailable()) {
                    BookingDAO bookingdao = new BookingDAO();
                    // Add the booking
                    bookingdao.addBooking(booking);
                    System.out.println("Your booking is confirmed");
                    System.out.println("If you want to cancel your booking, enter cancel");
                    System.out.println("If you want to break the program, enter break");
                    String userOpt = sc.nextLine();
                    if (userOpt.equalsIgnoreCase("cancel")) {
                        // Cancel the booking
                        bookingdao.cancelBooking(booking);
                        System.out.println("Booking cancelled successfully.");
                    } else if (userOpt.equalsIgnoreCase("break")) {
                        System.out.println("---------you are exit---------------");
                        break;
                    }
                }else {
                        throw new RuntimeException("Capacity is full!");
                }
        }
        sc.close();
    }
}
