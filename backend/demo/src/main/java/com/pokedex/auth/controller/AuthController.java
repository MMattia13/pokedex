package com.pokedex.auth.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.pokedex.auth.util.JwtUtil;
import com.pokedex.models.User;
import com.pokedex.services.UserServices;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class AuthController {

    private UserServices userServices = new UserServices();

    public void registerRoutes(Javalin app) {
        app.post("/login", this::login);
    }

    public void login(Context ctx) {
        try {

            String email = ctx.formParam("email");
            String password = ctx.formParam("password");
            User user = userServices.getUserByEmail(email);

             if (user != null && password == user.getPassword()) {
                 String token = JwtUtil.generateToken(user.getUuid().toString());
                 ctx.json(new TokenResponse(token));
             } else {
                 ctx.status(401).result("Invalid credentials");
             }
        } catch (Exception e) {
            ctx.status(400).result("Invalid request");
        }
    }

    private static class TokenResponse {
        public final String token;

        public TokenResponse(String token) {
            this.token = token;
        }
    }
}
