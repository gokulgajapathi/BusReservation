package com.gokul;
import java.util.Date;
import java.sql.*;

public class BookingDAO {

    public int getBookedCount(int busNo) throws SQLException{

        String query = "select count(passenger_name) from booking where bus_no=?";
        Connection con = DbConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, busNo);
        ResultSet rs = pst.executeQuery();
        rs.next();
        return rs.getInt(1);
    }
    public void addBooking(Booking booking) throws SQLException{
        String query = "Insert into booking values(?,?,?)";
        Connection con = DbConnection.getConnection();
        java.sql.Date sqldate = new java.sql.Date(booking.date.getTime());
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, booking.passengerName);
        pst.setInt(2, booking.busNo);
        pst.setDate(3, sqldate);

        pst.executeUpdate();

    }

    public void cancelBooking(Booking booking) throws SQLException{
        String query = "Delete from booking where passenger_name=? and bus_no=? and travel_date=?";
        Connection con = DbConnection.getConnection();
        java.sql.Date sqldate = new java.sql.Date(booking.date.getTime());
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, booking.passengerName);
        pst.setInt(2, booking.busNo);
        pst.setDate(3, sqldate);

        pst.executeUpdate();

    }
}
