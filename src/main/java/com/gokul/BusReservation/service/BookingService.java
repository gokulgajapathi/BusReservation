package com.gokul.BusReservation.service;

import com.gokul.BusReservation.model.Booking;
import com.gokul.BusReservation.repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
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
        System.out.println("Enter bus no:\n 1.Chennai\n 2.Coimbatore\n 3.Bangalore\n 4.Chennai\n 5.Bangalore");
        booking.setBusNo(sc.nextInt());
        Integer busNo = booking.getBusNo();

        Integer lastBusNo = bookingRepo.getLastBusNo();
        if(busNo>=lastBusNo || busNo<1){
            throw new RuntimeException("Enter correct Bus no!");
        }

        System.out.print("Enter passenger name: " );
        booking.setPassengerName(sc.next());

        System.out.print("Enter destination: " );
        String destination = sc.next();
        List<String> destinationDB = bookingRepo.findDestination(busNo);
        for (String stop : destinationDB){
            if(stop.equalsIgnoreCase(destination)) {
                booking.setDestination(destination);
                System.out.println("checked");
                break;
            }
        }

        System.out.print("Enter date (dd-mm-yyyy): ");
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

    public List<Booking> displayInfo() {
        return bookingRepo.findAll();
    }
}
