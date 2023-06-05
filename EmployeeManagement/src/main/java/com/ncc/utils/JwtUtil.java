package com.ncc.utils;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {
    private static Logger logger = LoggerFactory.getLogger(JwtUtil.class);
    private String SECRET_KEY = "secret";
    private static final long JWT_TOKEN_VALIDITY = 60 * 60;

    // lấy tên người dùng từ mã thông báo jwt
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // lấy ngày hết hạn từ mã thông báo jwt
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = exstractAllClaims(token);
        try {
            return claimsResolver.apply(claims);
        } catch (Exception e) {
            logger.error(e.getMessage() + ": ExpiredJwtException");
            return null;
        }
    }

    // Khi muốn lấy bất kì thông tin gì ta cần 1 khóa bí mật
    private Claims exstractAllClaims(String token) {
        try {
            return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();

        } catch (ExpiredJwtException e) {
            logger.error(e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error(e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error(e.getMessage());
        } catch (SignatureException e) {
            logger.error(e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
        }
        return null;
    }
    //Kiểm tra xem mã thông báo đã hết hạn hay chưa
    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    //tạo token cho người dùng
    private String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject){

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 10000 * JWT_TOKEN_VALIDITY))
                .setIssuer("Creator")
                .setHeaderParam("tokenType", "Bearer")
                .setAudience("You")
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }


}
