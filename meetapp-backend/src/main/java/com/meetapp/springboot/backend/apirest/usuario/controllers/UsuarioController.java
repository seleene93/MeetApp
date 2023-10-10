package com.meetapp.springboot.backend.apirest.usuario.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meetapp.springboot.backend.apirest.usuario.models.UsuarioDto;
import com.meetapp.springboot.backend.apirest.usuario.services.IUsuarioService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;

	@PostMapping("/public/registro")
	public ResponseEntity<UsuarioDto> register(@RequestBody UsuarioDto usuario) throws IOException {
		return ResponseEntity.ok(usuarioService.register(usuario));
	}
	
	@PostMapping("/public/login")
	public ResponseEntity<UsuarioDto> login(@RequestBody UsuarioDto usuario) {
		return ResponseEntity.ok(usuarioService.login(usuario));
	}
}
