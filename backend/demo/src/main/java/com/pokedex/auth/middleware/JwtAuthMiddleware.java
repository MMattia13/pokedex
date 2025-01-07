package com.pokedex.auth.middleware;

import com.pokedex.auth.util.JwtUtil;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class JwtAuthMiddleware implements Handler {

    @Override
    public void handle(Context ctx) throws Exception {
        String authHeader = ctx.header("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            ctx.status(401).result("Missing or invalid token");
            return;
        }

        String token = authHeader.replace("Bearer ", "");
        try {
            String userid = JwtUtil.validateToken(token);
            ctx.attribute("userid", userid);
        } catch (Exception e) {
            ctx.status(401).result("Invalid or expired token");
        }
    }
}