package com.gokul.BusResevHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


@Entity
public class Bus {
	
	@Id
    private  int busNo;
    private boolean ac;
    private int capacity; 

    Bus(int busNo, boolean ac, int capacity){
        this.busNo = busNo;
        this.ac = ac;
        this.capacity = capacity;
    }

    public Bus() {
        this(0,true,0);
    }

    public int getCapacity() {
        return capacity;
    }

    public int getBusNo() {
        return busNo;
    }

    public boolean getAc() {
        return ac;
    }
    
    public void setBusNo(int busNo) {
		this.busNo = busNo;
	}

    public void setAc(boolean ac) {
        this.ac = ac;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    

	


}
