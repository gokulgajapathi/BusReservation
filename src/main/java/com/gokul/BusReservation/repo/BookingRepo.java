package com.gokul.BusReservation.repo;

import com.gokul.BusReservation.model.Booking;
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
        return jdbc.query(sql, (rs, rowNum) -> {
            Booking booking = new Booking();
            booking.setId(rs.getInt("id"));
            // Remove the next line if the busno column doesn't exist
            booking.setBusNo(rs.getInt("bus_no"));
            booking.setPassengerName(rs.getString("passenger_name"));
            booking.setDestination(rs.getString("destination"));
            booking.setDate(rs.getDate("date_of_journey"));
            return booking;
            }
        );
    }

    public void save(Booking booking) {
        String sql = "insert into booking (bus_no, passenger_name, destination, date_of_journey) values (?, ?, ?, ?) ";
        int rows = jdbc.update(sql,booking.getBusNo(), booking.getPassengerName(), booking.getDestination(), booking.getDate());
        System.out.println(rows+" rows affected");
    }

    public int remove(int id) {
        String sql = "delete from booking where id=?";
        int rows = jdbc.update(sql,id);
        System.out.println(rows+" rows affected");
        return rows;
    }

    public Integer getLastBusNo() {
        String sql = "select max(bus_no) from bus";
        Integer last_bus_no = (Integer) jdbc.queryForObject(
                sql, Integer.class);

        return last_bus_no;
    }

    public List<String> findDestination(int busNo) {
        String sql = "SELECT stop_name FROM route WHERE bus_no=?";
        return jdbc.queryForList(sql, String.class, busNo);
    }
}
