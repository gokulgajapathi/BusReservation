package com.gokul.BusResevHibernate;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbConnection {
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration().configure().addAnnotatedClass(Bus.class).addAnnotatedClass(Booking.class); 
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create SessionFactory object: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
        
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

