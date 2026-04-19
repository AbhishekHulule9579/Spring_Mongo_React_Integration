package com.practice.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
    private static final String secert="HiMyNameIsAbhishekGorakshnathHululeandIamLearningtheJWT";

    public static String generateToken(String username){
        return Jwts.builder()
        .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
                .signWith(SignatureAlgorithm.HS256,secert)
                .compact();
    }
}
