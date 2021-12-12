package com.arpdevs.businesscook.helpers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtHelper {
	
	private static final String JWT_KEY = "bckaapp";
	
	private static final Long MILI = 1000L;
	private static final Long SECONDS = 60L;
	private static final Long MINUTES = 60L;
	private static final Long HOURS = 24L;
	private static final Long DAYS = 30L;
	private static final Long EXPIRATION = MILI * SECONDS * MINUTES * HOURS * DAYS;
	
	public String extractEmail(String token) {
		return extractClaim(token, Claims::getSubject);
	}
	
	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}
	
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	
	public Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(JWT_KEY).parseClaimsJws(token).getBody();
	}
	
	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	public String generateToken(String email) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, email);
	}
	
	private String createToken(Map<String, Object> claims, String email) {
		System.out.println(System.currentTimeMillis() + EXPIRATION);
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(email)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
				.signWith(SignatureAlgorithm.HS256, JWT_KEY)
				.compact();
	}
	
	public Boolean validateToken(String token, UserDetails user) {
		final String email = extractEmail(token);
		return (email.equals(user.getUsername()) && !isTokenExpired(token));
	}

}
