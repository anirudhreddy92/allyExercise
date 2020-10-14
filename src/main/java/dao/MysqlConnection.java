package dao;

import java.sql.*;

public class MysqlConnection {
    public static Connection getConnnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/customerdb";
        String uName = "root";
        String pass = "root";
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, uName, pass);
    }

}
