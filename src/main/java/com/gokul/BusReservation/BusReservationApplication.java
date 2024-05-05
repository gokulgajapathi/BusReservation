package com.gokul.BusReservation;

import com.gokul.BusReservation.model.Booking;
import com.gokul.BusReservation.model.Bus;
import com.gokul.BusReservation.service.BookingService;
import com.gokul.BusReservation.service.BusService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BusReservationApplication {


	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(BusReservationApplication.class,args);

		Bus bus = context.getBean(Bus.class);
		BusService busService = context.getBean(BusService.class);

		Scanner sc = new Scanner(System.in);
		boolean choice = true;

		while (choice) {
			System.out.println("==========================================================================================================================================================================================\n\n\n");
			System.out.println("Welcome to Bus Reservation");
			System.out.println("Bus Details:");
			System.out.println("-------------");

			//bus info
			List<Bus> buses = busService.getBuses();
			System.out.println(buses);

			//get values from user
			Booking booking = context.getBean(Booking.class);
			BookingService bookingService = context.getBean(BookingService.class);
			Booking booked = bookingService.setValues(booking);

			if (busService.isAvailable(booked.getBusNo())) {

				// Add the booking
				bookingService.add(booked);
				System.out.println("Your booking is confirmed");
				System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n\n");
				System.out.println("If you want to cancel your booking, enter n or N");
				System.out.println("If you want to continue the program, enter y or Y");
				System.out.println("If you want to break the program, enter b or B");
				String userOpt = sc.nextLine();

				if (userOpt.equalsIgnoreCase("N")) {

					// Cancel the booking
					System.out.print("Please enter your Passenger ID: ");
					int id = sc.nextInt();
					bookingService.cancel(id);
					System.out.println("Booking cancelled successfully.");

				} else if (userOpt.equalsIgnoreCase("B")) {
					System.out.println("---------you are exit---------------");
					break;

				} else if(userOpt.equalsIgnoreCase("Y")) {
					choice = true;
				}
			}else {
				throw new RuntimeException("Capacity is full!");
			}
		}

		System.out.println();



	}


}
