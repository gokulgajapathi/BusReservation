package com.gokul.BusReservation.service;

import com.gokul.BusReservation.model.Booking;
import com.gokul.BusReservation.repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Scanner;

@Service
public class BookingService {

    private BookingRepo bookingRepo;

    public BookingRepo getBookingRepo() {
        return bookingRepo;
    }

    @Autowired
    public void setBookingRepo(BookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    public Booking setValues(Booking booking) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter bus no:\n 1.Chennai\n 2.Coimbatore\n 3.Bangalore\n");
        booking.setBusNo(sc.nextInt());
        int busNo = booking.getBusNo();

        if(busNo>3 || busNo<1){
            throw new RuntimeException("Enter correct Bus no!");
        }

        System.out.println("Enter passenger name");
        booking.setPassengerName(sc.next());
        System.out.println("Enter date dd-mm-yyyy");
        String dateInput = sc.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try{
            booking.setDate(dateFormat.parse(dateInput));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        System.out.println("please wait..we will check");
        return booking;
    }


    public void add(Booking booking) {
        bookingRepo.save(booking);
    }

    public int cancel(int id) {
        int rows = bookingRepo.remove(id);
        return rows;
    }

    public void displayInfo() {
        if(bookingRepo.findAll().isEmpty()) System.out.println("No Bookings Found");

    }
}
