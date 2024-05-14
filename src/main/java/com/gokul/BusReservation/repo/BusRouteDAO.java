package com.gokul.BusReservation.repo;

import com.gokul.BusReservation.model.BusRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BusRouteDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveBusStop(BusRoute busStop) {
        String sql = "INSERT INTO bus_stops (stop_name, stop_time) VALUES (?, ?)";
        jdbcTemplate.update(sql, busStop.getStopName(), busStop.getStopTime());
    }

}
