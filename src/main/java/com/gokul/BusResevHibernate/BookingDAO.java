package com.gokul.BusResevHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class BookingDAO {

	public Integer getBookedCount(int busNo) {
		SessionFactory sf = DbConnection.getSessionFactory();
		Session sessionBook = sf.openSession();
		sessionBook.beginTransaction();

		Query q = sessionBook.createNativeQuery("select count(*) from Booking");
		Integer bookedCount = ((Number) q.uniqueResult()).intValue();

		sessionBook.getTransaction().commit();
		sessionBook.close();
		return bookedCount;
	}

	public void add(Booking b) {
		SessionFactory sf = DbConnection.getSessionFactory();
		Session sessionBook = sf.openSession();
		sessionBook.beginTransaction();

		sessionBook.save(b);
		sessionBook.getTransaction().commit();
		System.out.print("Successfully added! ");
		System.out.println("Passanger ID: " + b.id + "Passanger Name: " + b.passengerName +", Bus No: " + b.busNo + ", DATE: " + b.date);

	}

	public void cancel(int a) {
		SessionFactory sf = DbConnection.getSessionFactory();
		Session sessionBook = sf.openSession();
		sessionBook.beginTransaction();
		
		Query q = sessionBook.createNativeQuery("delete from Booking where id =:b");
		q.setParameter("b",a);
		int bookedCount = q.executeUpdate();

		sessionBook.getTransaction().commit();
		sessionBook.close();

	}

}
