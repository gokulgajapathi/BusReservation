package com.gokul.BusReservation.repo;

import com.gokul.BusReservation.model.Bus;
import com.gokul.BusReservation.model.BusRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BusRepo {

    private JdbcTemplate jdbc;


    public void save(Bus bus) {
        String sql = "INSERT INTO bus (bus_no, ac, capacity, driver_name, starting_point, ending_point, stops, fare) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        int rows = jdbc.update(sql, bus.getBusNo(), bus.getAc(), bus.getCapacity(), bus.getDriverName(), bus.getStartingPoint(), bus.getEndingPoint(), bus.getStops(), bus.getFare());

        // Now insert routes for the bus
        for (BusRoute route : bus.getRoute()) {
            addRoute(bus.getBusNo(), route);
        }
        System.out.println(rows!=0);
    }

    private void addRoute(int busNo, BusRoute route) {
        String sql = "INSERT INTO route (stop_name, stop_time, bus_no) VALUES (?, ?, ?)";
        jdbc.update(sql, route.getStopName(), route.getStopTime(), busNo);
    }

    //      with lambda expression
    public List<Bus> findAll() {
        String sql = "select * from bus";
        return jdbc.query(sql, (rs,  rowNum) -> {
                    Bus bus = new Bus();
                    bus.setBusNo(rs.getInt("bus_no"));
                    bus.setAc(rs.getBoolean("ac"));
                    bus.setCapacity(rs.getInt("capacity"));
                    bus.setEndingPoint(rs.getString("ending_point"));
                    bus.setDriverName(rs.getString("driver_name"));
                    bus.setStartingPoint(rs.getString("starting_point"));
                    bus.setStops(rs.getInt("stops"));
                    bus.setFare(rs.getFloat("fare"));
                    bus.setRoute(findRoute());
                    return bus;
                }
        );
    }

    private List<BusRoute> findRoute() {
        String sql = "select * from route";
        return jdbc.query(sql, (rs,  rowNum) -> {
                    BusRoute route = new BusRoute();
                    route.setBusNo(rs.getInt("bus_no"));
                    route.setStopName(rs.getString("stop_name"));
                    route.setStopTime(rs.getTime("stop_time").toLocalTime());
                    return route;
                }
        );
    }



//      without lambda expression
//    public List<Bus> findAll() {
////        String sql = "select * from bus";
////
////        RowMapper<Bus> mapper = new RowMapper<Bus>() {
////            @Override
////            public Bus mapRow(ResultSet rs, int rowNum) throws SQLException {
////                Bus bus = new Bus();
////                bus.setBusNo(rs.getInt("busno"));
////                bus.setAc(rs.getBoolean("ac"));
////                bus.setCapacity(rs.getInt("capacity"));
////                return bus;
////            }
////        };
////        return jdbc.query(sql, mapper);
////    }

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Integer getCapacity(int busNo) {
        String sql = "select capacity from bus where bus_no=?";
        Integer capacity = (Integer) jdbc.queryForObject(
                sql, new Object[] { busNo }, Integer.class);

        return capacity;
    }

    public int getBookedCount() {
        String sql = "select count(*) from booking";
        Integer bookedCount = (Integer) jdbc.queryForObject(
                sql, Integer.class);

        return bookedCount != null ? bookedCount : 0;
    }

    public void remove(int no) {
        String sql = "delete from bus where bus_no=?";
        String query = "delete from route where bus_no=?";
        jdbc.update(query,no);
        int rows = jdbc.update(sql,no);
        System.out.println(rows+" rows affected");
    }
}
