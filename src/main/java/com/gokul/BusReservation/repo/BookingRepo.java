package com.gokul.BusReservation.repo;

import com.gokul.BusReservation.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookingRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Booking booking) {
        String sql = "insert into booking (busno, passengername, dateofjourney) values (?,?,?)";
        int rows = jdbc.update(sql,booking.getBusNo(), booking.getPassengerName(), booking.getDate());
        System.out.println(rows+" rows affected");
    }

    public void remove(int id) {
        String sql = "delete from booking where id=?";
        int rows = jdbc.update(sql,id);
        System.out.println(rows+" rows affected");
    }
}
