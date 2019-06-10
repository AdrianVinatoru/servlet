package com.main.demo.servlets.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class to demonstrate a datasource to a PostgresSQl database.
 */
public class DbConnection {

    private static final String USERNAME = "postgres";

    private static final String PASSWORD = "postgres";

    private static final String SERVER_URL = "jdbc:postgresql://localhost:5432/postgres";


    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection(SERVER_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Could not connect to database");
        }

        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException("Could not close onnection", e);
        }
    }

}
