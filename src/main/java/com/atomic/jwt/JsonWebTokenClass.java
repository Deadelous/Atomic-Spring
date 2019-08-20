package com.atomic.jwt;

import com.atomic.models.Account;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JsonWebTokenClass {
   private SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(Account account) {
        Date date = new Date();
        long time = date.getTime();
        // The expirationTime is set for 20 minutes;
        Date expirationTime = new Date(time + 1200000);

        String jwtToken = Jwts.builder().setSubject(account.getAccountname())
                .claim("accountname", account.getAccountname())
                .setIssuedAt(new Date())
                .setExpiration(expirationTime)
                .signWith(key).compact();

        return jwtToken;
    }
}
