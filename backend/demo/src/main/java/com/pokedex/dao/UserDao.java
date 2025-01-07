package com.pokedex.dao;

import com.pokedex.models.User;
import com.pokedex.utility.DatabaseConnection;

import java.sql.*;
import java.util.UUID;

public class UserDao {

    private Connection connection = DatabaseConnection.getInstance().getConnection();

    public User addUser(User user) {

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
        return user;
    }

    public User getUserByID (UUID id){
        String getUserSQL = "SELECT * FROM user WHERE id = ? ";
        User user = new User();
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(getUserSQL);

            user.setUuid(UUID.fromString(rs.getString("id")));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setName(rs.getString("name"));
            user.setSurname(rs.getString("surname"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }
    public User getUserByEmail (String email){
        String getUserSQL = "SELECT * FROM user WHERE email = ? ";
        User user = new User();
        try {
            PreparedStatement stm = connection.prepareStatement(getUserSQL);
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();

            user.setUuid(UUID.fromString(rs.getString("id")));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setName(rs.getString("name"));
            user.setSurname(rs.getString("surname"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }
    }




