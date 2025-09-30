package org.daniel.database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private  final static String URL = "jdbc:mysql://localhost:3307/gestor_usuarios";
    private  final static String USER = "root";
    private  final static String PASSWORD = "1234";
    private static Connection connection;

    private DatabaseConnection(){}

    public static Connection getConnection() throws SQLException {

        if(connection == null) {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

        }

        return connection;

    }

}
