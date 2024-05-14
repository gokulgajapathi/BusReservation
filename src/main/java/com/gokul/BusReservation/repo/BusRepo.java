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


    public void save(Bus b) {

        String sql = "INSERT INTO bus (busNo, ac, capacity, driverName, startingPoint, endingPoint) VALUES (?, ?, ?, ?, ?, ?)";
        int rows = jdbc.update(sql,b.getBusNo(), b.getAc(), b.getCapacity(), b.getDriverName(), b.getStartingPoint(), b.getEndingPoint());
        System.out.println(rows+" rows affected");
    }

    //      with lambda expression
    public List<Bus> findAll() {
        String sql = "select * from bus";
        return jdbc.query(sql, (rs,  rowNum) -> {
                    Bus bus = new Bus();
                    bus.setBusNo(rs.getInt("busno"));
                    bus.setAc(rs.getBoolean("ac"));
                    bus.setCapacity(rs.getInt("capacity"));
                    bus.setEndingPoint(rs.getString("endingPoint"));
                    bus.setDriverName(rs.getString("driverName"));
                    bus.setStartingPoint(rs.getString("startingPoint"));
                    return bus;
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

    public int getCapacity(int busNo) {
        String sql = "select capacity from bus where busno=?";
        Integer capacity = (Integer) jdbc.queryForObject(
                sql, new Object[] { busNo }, Integer.class);

        return capacity;
    }

    public int getBookedCount(int busNo) {
        String sql = "select count(*) from booking";
        Integer bookedCount = (Integer) jdbc.queryForObject(
                sql, Integer.class);

        return bookedCount != null ? bookedCount : 0;
    }

    public void remove(int no) {
        String sql = "delete from bus where busNo=?";
        int rows = jdbc.update(sql,no);
        System.out.println(rows+" rows affected");
    }
}
