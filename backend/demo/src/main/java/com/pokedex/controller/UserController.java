package com.pokedex.controller;

import com.pokedex.models.User;
import com.pokedex.services.UserServices;
import io.javalin.Javalin;

import java.util.List;
import java.util.UUID;

public class UserController {
    private UserServices userServices = new UserServices();
    private String apiVersionV1 = "/api/u1";

    public void registerRoutes(Javalin app){

        app.get(apiVersionV1 + "/user", ctx -> {
            UUID UserID= UUID.fromString(ctx.pathParam("id"));
            User user = userServices.getUserByID(UserID);

            ctx.json(user);
        });
    }
}
