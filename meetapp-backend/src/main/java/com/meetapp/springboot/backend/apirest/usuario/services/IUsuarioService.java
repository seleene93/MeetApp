package com.meetapp.springboot.backend.apirest.usuario.services;

import com.meetapp.springboot.backend.apirest.auth.models.AuthResponse;
import com.meetapp.springboot.backend.apirest.usuario.models.UsuarioDto;

public interface IUsuarioService {

	public AuthResponse register(UsuarioDto usuario);

	public AuthResponse login(UsuarioDto usuario);
}
