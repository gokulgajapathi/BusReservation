package com.gokul.BusResevHibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.annotations.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
@Entity
@Table
public class Booking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    int id;
    int busNo;
    String passengerName;
    Date date;

    /**
	 * @return the id
	 */
	public int getId() {
		return id;
	}





	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}





	public void setValues() {
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





    public boolean isAvailable()  {

    	BusDAO busdao = new BusDAO();
        BookingDAO bookingdao = new BookingDAO();
        int capacity = busdao.getCapacity(busNo);
        int booked = bookingdao.getBookedCount(busNo);
        int availableSeats = (int) (capacity-(++booked));

		System.out.print("booked tickets:  "+(booked));
        System.out.print(", capacity: "+capacity);
        System.out.println(", Available Seats: "+availableSeats);

        if(availableSeats==0){
            System.out.println("No more booking in this bus, Try another bus!");
        }

        return booked<=capacity;
    }
}
