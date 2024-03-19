package com.gokul;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Booking {
    String passengerName;
    int busNo;
    Date date;

    Booking(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter bus no:");
        System.out.println("1.Chennai");
        System.out.println("2.Coimbatore");
        System.out.println("3.Bangalore");
        busNo = sc.nextInt();

        if(busNo>3 || busNo<1){
            throw new RuntimeException("Enter correct Bus no!");
        }

            System.out.println("Enter passenger name");
            passengerName = sc.next();
            System.out.println("Enter date dd-mm-yyyy");
            String dateInput = sc.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

            try{
                date = dateFormat.parse(dateInput);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println("please wait..");


    }





    public boolean isAvailable() throws SQLException {


        BusDAO busdao = new BusDAO();
        BookingDAO bookingdao = new BookingDAO();
        int capacity = busdao.getCapacity(busNo);
        int booked = bookingdao.getBookedCount(busNo)+1;
        int availableSeats = capacity-booked;

        System.out.println("capacity: "+capacity);
        System.out.println("Available Seats :"+availableSeats);

        if(availableSeats==0){
            System.out.println("No more booking in this bus, Try another bus!");
        }

        return booked<=capacity;
    }
}
