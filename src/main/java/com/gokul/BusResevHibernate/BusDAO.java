package com.gokul.BusResevHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class BusDAO {
	

	public void add(Bus b) {
		SessionFactory sf = DbConnection.getSessionFactory();
		Session sessionBus   = sf.openSession(); 
		sessionBus.beginTransaction();
		
		sessionBus.save(b);
		sessionBus.getTransaction().commit();
	}

	public void displayBusInfo(){
		SessionFactory sf = DbConnection.getSessionFactory();
		Session sessionBusInfo   = sf.openSession(); 
		sessionBusInfo.beginTransaction();
		
		Query q = sessionBusInfo.createQuery("SELECT b.busNo, b.ac, b.capacity FROM Bus b");
		List<Object[]> buses = (List<Object[]>) q.list();
		System.out.println("\n Welcome you all, Kindly check the capacity before booking tickets\n");
		for (Object[] bus :buses) {
            System.out.println(" Bus No-> "+bus[0] +" : AC Availability-> "+bus[1] +" : Capacity-> "+bus[2]);
        }
		sessionBusInfo.getTransaction().commit();
		sessionBusInfo.close();
				
	}
	
	public int getCapacity(int id)  {
		SessionFactory sf = DbConnection.getSessionFactory();
		Session sessionBusInfo   = sf.openSession(); 
		sessionBusInfo.beginTransaction();
		Bus b = new Bus();
		b = (Bus)sessionBusInfo.get(Bus.class, id);//to fetch the data from DB
		sessionBusInfo.close();
		
		return b.getCapacity();
    }
}
