package com.banking.system.bank.authentication.service;

import com.banking.system.bank.authentication.util.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Component
public class JwtServiceImpl implements JwtService{

    /*
            Code to Generate new JWT token for valid user with valid password
    */
    @Override
    public String generateToken(String userId) {
        Map<String, Objects> claims = new HashMap<>();
        return createToken(claims, userId);
    }

    private String createToken(Map<String, Objects> claims, String userId){
        return Jwts.builder()
                .claims(claims)
                .subject(userId)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10))
                .signWith(getSignKey()).compact();
    }
    private SecretKey getSignKey(){
        byte[] keyBytes = Decoders.BASE64.decode(Constants.SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    /*
            Code to validate given JWT token represents a valid user with valid password and token should not expired
    */

    @Override
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && Boolean.FALSE.equals(isTokenExpired(token)));
    }

    @Override
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    @Override
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    @Override
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }


    private Claims extractAllClaims(String token){
        return Jwts
                .parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }


}
