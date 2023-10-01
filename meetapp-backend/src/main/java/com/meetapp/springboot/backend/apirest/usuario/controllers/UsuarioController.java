package com.meetapp.springboot.backend.apirest.usuario.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meetapp.springboot.backend.apirest.usuario.models.UsuarioDto;
import com.meetapp.springboot.backend.apirest.usuario.services.IUsuarioService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;

	@PostMapping("/registro")
	public UsuarioDto register(@RequestBody UsuarioDto usuario) {
		return usuarioService.register(usuario);
	}
	
	@PostMapping("/login")
	public UsuarioDto login(@RequestBody UsuarioDto usuario) {
		return usuarioService.login(usuario);
	}
}
