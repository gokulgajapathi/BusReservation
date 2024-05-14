package com.gokul.BusReservation.repo;

import com.gokul.BusReservation.model.Booking;
import com.gokul.BusReservation.model.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<Booking> findAll() {
        String sql = "select * from booking";
        List<Booking> bookings = jdbc.query(sql, (rs, rowNum) -> {
            Booking booking = new Booking();
            booking.setId(rs.getInt("id"));
            // Remove the next line if the busno column doesn't exist
            booking.setBusNo(rs.getInt("busno"));
            booking.setPassengerName(rs.getString("passengerName"));
            booking.setDate(rs.getDate("date"));
            return booking;
        });

        return bookings;
    }

    public void save(Booking booking) {
        String sql = "insert into booking (busno, passengername, dateofjourney) values (?,?,?) ";
        int rows = jdbc.update(sql,booking.getBusNo(), booking.getPassengerName(), booking.getDate());
        System.out.println(rows+" rows affected");
    }

    public int remove(int id) {
        String sql = "delete from booking where id=?";
        int rows = jdbc.update(sql,id);
        System.out.println(rows+" rows affected");
        return rows;
    }
}
