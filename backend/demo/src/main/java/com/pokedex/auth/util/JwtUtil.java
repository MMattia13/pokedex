package com.pokedex.auth.util;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

public class JwtUtil {

    private static final String SECRET = "chiave_molto_segreta_che_non_andrebbe_committata";
    private static final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET);
    private static final JWTVerifier VERIFIER = JWT.require(ALGORITHM).build();
    private static final long EXPIRATION_TIME = 3600000; // 1 ora

    public static String generateToken(String userid) {
        return JWT.create()
                .withSubject(userid)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(ALGORITHM);
    }

    public static String validateToken(String token) throws JWTVerificationException {
        DecodedJWT jwt = VERIFIER.verify(token);
        return jwt.getSubject(); 
    }
}
