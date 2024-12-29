package com.Henry.auth.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtService {

    @Value("${jwt.secret.key}")
    private String SECRET_KEY;

    public String getToken(UserDetails user) {
        return getToken(new HashMap<>(),user);
    }

    private String getToken(Map<String,Object> extraClaims, UserDetails user) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername()) // no olvidar que el username es el email xd
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes); // permite una nueva instancia de nuestra secretKey
    }

    // creado después para el proceso de validación

    public String getUserNameFromToken(String token) {
        return getClaim(token,Claims::getSubject);
    }
    //debemos tener en cuenta la fecha de expiración:
    public boolean isTokenValid(String token, UserDetails userDetails) {
        //primero verificamos si el username corresponde con el que obtenemos del userDetails:
        final String username = getUserNameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    // metodo privado para obetner los claims del token:
    private Claims getAllClaims(String token){
        //Accedemos gracias a la libreria Jwts
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    //para la fecha de expiración:
    private Date getExpiration(String token){
        return getClaim(token,Claims::getExpiration);
    }
    private boolean isTokenExpired(String token){
        return getExpiration(token).before(new Date());
    }

    // metodo generico:
    // para obtener un claim en particular:
    public <T> T getClaim(String token, Function<Claims,T> claimResolver){
        final Claims claims = getAllClaims(token);
        return claimResolver.apply(claims);
    }
}
