package com.meetapp.springboot.backend.apirest.jwt.service;

import java.security.Key;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.meetapp.springboot.backend.apirest.usuario.models.UsuarioDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	private String secretKeyBase64 = "G0xU6HfMpsGaWo30wzjQm3OFj/OX/MXgPW7Zree8IDY";

	public String getToken(UsuarioDto usuario) {
		return getToken(new HashMap<>(), usuario);
	}

	private String getToken(Map<String, Object> extraClaims, UsuarioDto usuario) {
		return Jwts.builder().setClaims(extraClaims).setSubject(usuario.getEmail())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
				.signWith(getKey(), SignatureAlgorithm.HS256).compact();
	}

	private Key getKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secretKeyBase64);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token);
			// Si no se lanza una excepción, el token es válido
			return true;
		} catch (Exception ex) {
			// Si se lanza una excepción, el token no es válido
			return false;
		}
	}

	public Authentication getAuthentication(String token) {
		Claims claims = Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
		String email = claims.getSubject();

		return new Authentication() {

			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				return null; // Esto es null porque no necesitamos roles
			}

			@Override
			public Object getCredentials() {
				return null; // Puedes dejarlo como null
			}

			@Override
			public Object getDetails() {
				return email; // Puedes utilizar el email como detalle
			}

			@Override
			public Object getPrincipal() {
				return email; // Puedes utilizar el email como principal
			}

			@Override
			public boolean isAuthenticated() {
				return true; // Siempre consideramos que el usuario está autenticado
			}

			@Override
			public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
				// No es necesario implementar esto
			}

			@Override
			public String getName() {
				return email; // Puedes utilizar el email como nombre de usuario
			}
		};
	}
}
