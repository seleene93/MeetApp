package com.meetapp.springboot.backend.apirest.jwt.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.meetapp.springboot.backend.apirest.usuario.models.UsuarioDto;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;


@Service
public class JwtService {
	
	Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	String secretKeyBase64 = Encoders.BASE64.encode(secretKey.getEncoded());

	public String getToken(UsuarioDto usuario) {
		return getToken(new HashMap<>(), usuario);
	}

	private String getToken(Map<String, Object> extraClaims, UsuarioDto usuario) {
		return Jwts
				.builder()
				.setClaims(extraClaims)
				.setSubject(usuario.getEmail())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
				.signWith(getKey(), SignatureAlgorithm.HS256)
				.compact();
	}

	private Key getKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secretKeyBase64);
		return Keys.hmacShaKeyFor(keyBytes);
	}

}
