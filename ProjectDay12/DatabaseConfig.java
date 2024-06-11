package com.example.DemoGroup.day4.session3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    private static final String URL = "jdbc:sqlite:src\\main\\java\\com\\example\\DemoGroup\\day4\\hr.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}