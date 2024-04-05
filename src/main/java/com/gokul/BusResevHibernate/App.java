package com.gokul.BusResevHibernate;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {
	public static void main(String[] args) throws HibernateException, SQLException {
		Bus bus1 = new Bus();
		bus1.setBusNo(1);
		bus1.setAc(false);
		bus1.setCapacity(2);
		
		Bus bus2 = new Bus();
		bus2.setBusNo(2);
		bus2.setAc(true);
		bus2.setCapacity(20);
	
		Bus bus3 = new Bus();
		bus3.setBusNo(3);
		bus3.setAc(false);
		bus3.setCapacity(42);
		
		BusDAO operationsOnBus = new BusDAO();
	
		 
		//b1
		operationsOnBus.add(bus1);
		
		//b2
		operationsOnBus.add(bus2);
		
		//b3
		operationsOnBus.add(bus3);
		
		 
		//bus info
		operationsOnBus.displayBusInfo();
		
		
		Scanner sc = new Scanner(System.in);
		boolean choice = true;

        while (choice) {
                System.out.println("==========================================================================================================================================================================================\n\n\n");
                System.out.println("Welcome to ");
                Booking booking = new Booking();
                booking.setValues();
                if (booking.isAvailable()) {
                    BookingDAO bookingdao = new BookingDAO();
                    // Add the booking
                    bookingdao.add(booking);
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
                        bookingdao.cancel(id);
                        System.out.println("Booking cancelled successfully.");
                        
                    } else if (userOpt.equalsIgnoreCase("B")) {
                        System.out.println("---------you are exit---------------");
                        choice = false;
                    	sc.close();
                        DbConnection.getSessionFactory().close();
                        break;
                        
                    } else if(userOpt.equalsIgnoreCase("Y")) {
                    	choice = true;
                    }
                }else {
                	sc.close();
                    DbConnection.getSessionFactory().close();
                        throw new RuntimeException("Capacity is full!");
                }
        }

		System.out.println();
		
		
	}
}
