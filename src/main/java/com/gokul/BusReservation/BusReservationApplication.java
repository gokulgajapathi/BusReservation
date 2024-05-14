package com.gokul.BusReservation;

import com.gokul.BusReservation.Users.Admin;
import com.gokul.BusReservation.Users.Passenger;
import com.gokul.BusReservation.model.*;
import com.gokul.BusReservation.service.BookingService;
import com.gokul.BusReservation.service.BusRouteService;
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
		Booking booking = context.getBean(Booking.class);
		BookingService bookingService = context.getBean(BookingService.class);
		BusRouteService busRouteService = context.getBean(BusRouteService.class);


		Admin admin = context.getBean(Admin.class);
		admin.setUsername("admin");
		admin.setPassword("password-admin");

		Passenger passenger = context.getBean(Passenger.class);
		passenger.setUsername("passenger");
		passenger.setPassword("password-passenger");

		Scanner sc = new Scanner(System.in);
		boolean choice = true;

		while (choice) {
			System.out.println( " Choose Login\n" +
								" 1. Admin Login\n" +
								" 2. Passenger Login\n" +
								" 3. Exit");
			int login = sc.nextInt();
			String username;
			String password;

			if(login == 1){

				System.out.println(" Welcome Admin");
				System.out.println(" Enter User Name: ");
				username = sc.next();

				System.out.println(" Enter Password: ");
				password = sc.next();
				if (!admin.getUsername().equalsIgnoreCase(username) || !admin.getPassword().equalsIgnoreCase(password)) {
					System.out.println("Wrong credentials for Admin");
					break;

				} else {
					while (true) {
						System.out.println(" Welcome Admin ");
						System.out.println(" -------------");
						System.out.println("Test Admin");
						System.out.println( " 1. Add bus\n" +
											" 2. Cancel bus\n" +
											" 3. View all bookings\n" +
											" 4. Exit from Admin");
						int adminOpt = sc.nextInt();

						if(adminOpt==1) {

                            // Get bus no from the user
							System.out.print(" Enter Bus No: ");
							int busNo = sc.nextInt();
							bus.setBusNo(busNo);

							// Get AC from the user
							System.out.print(" Enter AC: ");
                            boolean ac = sc.nextBoolean();
							bus.setAc(ac);

							// Get capacity from the user
							System.out.print("Enter capacity: ");
                            int capacity = sc.nextInt();
							bus.setCapacity(capacity);

							// Get driver name from the user
							System.out.print("Enter driver name: ");
							String driverName = sc.next();
							bus.setDriverName(driverName);

							// Get starting point from the user
							System.out.print("Enter starting point: ");
							String startingPoint = sc.next();
							bus.setStartingPoint(startingPoint);

							// Get ending point from user
							System.out.print(" Enter ending point: ");
							String endingPoint = sc.next();
							bus.setEndingPoint(endingPoint);

                            // Get bus route from user
							//bus.setRoute(busRouteService.addBus(busNo));

							// Add Bus
							busService.addBus(bus);
                        } else if (adminOpt==2) {
							// Cancel the booking
							System.out.print("Please enter your BusNo: ");
							int no = sc.nextInt();
							busService.cancel(no);
							System.out.println("Bus cancelled successfully.");


						} else if (adminOpt==3) {
							//Display Bus info
							bookingService.displayInfo();

						} else if (adminOpt == 4) {
							System.out.println("---------You are exit from Admin Login---------------");
							System.out.println("=====================================================");
							break;

						} else {
							System.out.println("Invalid user choice, Enter an valid user choice");
						}
					}
				}
			} else if(login == 2) {

				System.out.println(" Welcome Passenger");
				System.out.println(" Enter User Name: ");
				username = sc.next();

				System.out.println(" Enter Password: ");
				password = sc.next();
				int bookingCount = 0;

				if (!passenger.getUsername().equalsIgnoreCase(username) || !passenger.getPassword().equalsIgnoreCase(password)) {
					System.out.println("Wrong credentials for Passenger");
					break;

				} else {
					while(true){
					System.out.println(" Welcome to Bus Reservation");
					System.out.println("--------------------------");
					System.out.println( " 1. Book bus ticket\n" +
										" 2. Cancel bus ticket\n" +
										" 3. View all buses\n" +
										" 4. Exit from Passenger Login\n");
					int userOpt = sc.nextInt();

					if (userOpt == 1) {
						System.out.println(" Bus Details:");
						System.out.println(" -------------");

						//bus info
						List<Bus> buses = busService.getBuses();
						System.out.println(buses);

						//get values from user
						Booking booked = bookingService.setValues(booking);

						if (busService.isAvailable(booked.getBusNo())) {
							// Add the booking
							bookingService.add(booked);
							bookingCount+=1;
							System.out.println(" Your booking is confirmed");
							System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXX\n");

						} else {
							throw new RuntimeException("Capacity is full!");
						}
					} else if (userOpt == 2) {

						if(bookingCount<1) {
							System.out.println("No Booking Found!");
						} else {
							// Cancel the booking
							System.out.print("Please enter your Passenger ID: ");
							int id = sc.nextInt();
							int rows = bookingService.cancel(id);
							if(rows==0) {
								System.out.println("No Booking Found!");
							} else {
								bookingCount-=1;
								System.out.println("Booking cancelled successfully.");
								System.out.println("==========================================================================================================================================================================================\n\n\n");
							}
						}
					} else if (userOpt == 3) {
						//bus info
						List<Bus> buses = busService.getBuses();
						System.out.println(buses);

					} else if (userOpt == 4) {
						System.out.println("---------You are exit from Passenger Login---------------");
						System.out.println("=====================================================");
						break;

					} else {
						System.out.println("Invalid user choice, Enter an valid user choice");
					}
				}
				}
			} else if (login==3) {
				System.out.println("Exit from Bus Reservation");
				break;
			} else {
					System.out.println("Invalid login choice, Enter an valid login choice");
				}
		}
	}
}
