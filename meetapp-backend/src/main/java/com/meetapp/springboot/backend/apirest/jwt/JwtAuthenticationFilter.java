package com.meetapp.springboot.backend.apirest.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.meetapp.springboot.backend.apirest.jwt.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
    private JwtService jwtService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String token = getTokenFromRequest(request);
		
		if (StringUtils.hasText(token) && jwtService.validateToken(token)) {
            // Token válido, autenticar al usuario
            Authentication authentication = jwtService.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
		
//		if (token == null) {
//			filterChain.doFilter(request, response);
//			return;
//		}
		
		filterChain.doFilter(request, response);
	}

	private String getTokenFromRequest(HttpServletRequest request) {

		final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		
		if (StringUtils.hasText(authHeader) && authHeader.startsWith(("Bearer "))) {
			return authHeader.substring(7);
		}
		return null;
	}
}
