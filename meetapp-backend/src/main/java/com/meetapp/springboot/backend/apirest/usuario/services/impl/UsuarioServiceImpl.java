package com.meetapp.springboot.backend.apirest.usuario.services.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.meetapp.springboot.backend.apirest.auth.models.AuthResponse;
import com.meetapp.springboot.backend.apirest.jwt.service.JwtService;
import com.meetapp.springboot.backend.apirest.usuario.mapper.IUsuarioMapper;
import com.meetapp.springboot.backend.apirest.usuario.models.UsuarioDto;
import com.meetapp.springboot.backend.apirest.usuario.services.IUsuarioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioMapper usuarioMapper;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public AuthResponse register(UsuarioDto usuario) {
		AuthResponse response = new AuthResponse();
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		usuarioMapper.register(usuario);
	    response.setToken(jwtService.getToken(usuario));
		
		return response;
	}

	@Override
	public AuthResponse login(UsuarioDto usuario) {
		AuthResponse response = new AuthResponse();
		usuarioMapper.login(usuario);
		response.setToken(jwtService.getToken(usuario));
		
		return response;
	}
}
