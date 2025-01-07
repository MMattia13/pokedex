package com.pokedex.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    private final String UrlDB = "jdbc:postgresql://localhost:5432/pokedex";
    private final String userDB = "postgres";
    private final String pwdDB = "Po773rdb";

    private DatabaseConnection(){
        try {
            //  Class.forName("com.mysql.jdbc.Driver")
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(UrlDB, userDB, pwdDB);
            connection.setAutoCommit(true);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DatabaseConnection getInstance(){
        if (instance == null){
            instance = new DatabaseConnection();
        }

        return instance;
    }

    public Connection getConnection(){
        return connection;
    }

}