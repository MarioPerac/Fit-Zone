package org.unibl.etf.ip.consultingapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/fit_zone";
    private static final String USER = "root";
    private static final String PASSWORD = "ep2024";

    public static Connection getConnection() {
        Connection connection = null;
        try {
        	DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
