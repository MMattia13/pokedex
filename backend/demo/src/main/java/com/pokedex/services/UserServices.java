package com.pokedex.services;

import com.pokedex.dao.UserDao;
import com.pokedex.models.User;

import java.util.UUID;

public class UserServices {
    private UserDao userDao= new UserDao();

    public void addUser(User user){
        userDao.addUser(user);
    }
    //public User getByUserID(UUID id){return user}
}
