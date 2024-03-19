package com.gokul;

import java.sql.*;

public class DbConnection {
    private static final String url = "jdbc:mysql://localhost:3306/busrev";
    private static final String userName = "root";
    private static final String passWord = "MySQL@22";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,userName,passWord);
    }
}
