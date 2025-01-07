package com.pokedex.dao;

import com.pokedex.models.User;
import com.pokedex.utility.DatabaseConnection;

import java.sql.*;

public class UserDao {

    private Connection connection = DatabaseConnection.getInstance().getConnection();

    public void addUser(User user) {

        String insertAllUserSQL = "INSERT INTO public.utenti(\n" +
                "            id, email, password, name, surname)\n" +
                "    VALUES (?, ?, ?, ?, ?);";

        try {
            PreparedStatement psInsertUser = connection.prepareStatement(insertAllUserSQL);
            psInsertUser.setString(1, user.getUuid().toString());
            psInsertUser.setString(2, user.getEmail());
            psInsertUser.setString(3, user.getPassword());
            psInsertUser.setString(4, user.getName());
            psInsertUser.setString(5, user.getSurname());

            psInsertUser.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

