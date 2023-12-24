package com.autoparts.userservice.security.jwt;

import com.autoparts.userservice.security.MyUserDetails;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class JwtTokenUtil {
    private final JwtProperty jwtProperty;

    public JwtTokenUtil(JwtProperty jwtProperty) {
        this.jwtProperty = jwtProperty;
    }

    public String generateToken(MyUserDetails user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuer(jwtProperty.getJwtIssuer())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+ jwtProperty.getJwtLifetime().toMillis()))
                .claim("id", user.getId().toString())
                .claim("email", user.getUsername())
                .claim("role", user.getRole().name())
                .signWith(SignatureAlgorithm.HS512,jwtProperty.getJwtSecret())
                .compact();
    }

    public String getUsername(String token) {
        return getAllClaimsFromToken(token).getSubject();
    }

    public String getUserRole(String token) {
        return getAllClaimsFromToken(token).get("role", String.class);
    }

    public String getUserEmail(String token) {
        return getAllClaimsFromToken(token).get("email", String.class);
    }

    public String getUserId(String token) {
        return getAllClaimsFromToken(token).get("id", String.class);
    }
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtProperty.getJwtSecret())
                .parseClaimsJws(token)
                .getBody();
    }
    public boolean validate(String token) {
        try {
            Jwts.parser().setSigningKey(jwtProperty.getJwtSecret()).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            //logger.error("Invalid JWT signature - {}", ex.getMessage());
        } catch (MalformedJwtException ex) {
            //logger.error("Invalid JWT token - {}", ex.getMessage());
        } catch (ExpiredJwtException ex) {
            //logger.error("Expired JWT token - {}", ex.getMessage());
        } catch (UnsupportedJwtException ex) {
            //logger.error("Unsupported JWT token - {}", ex.getMessage());
        } catch (IllegalArgumentException ex) {
            //logger.error("JWT claims string is empty - {}", ex.getMessage());
        }
        return false;
    }
}