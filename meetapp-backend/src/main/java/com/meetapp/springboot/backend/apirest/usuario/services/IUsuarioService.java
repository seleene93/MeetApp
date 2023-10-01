package com.meetapp.springboot.backend.apirest.usuario.services;

import com.meetapp.springboot.backend.apirest.usuario.models.UsuarioDto;

public interface IUsuarioService {

	UsuarioDto register(UsuarioDto usuario);

	UsuarioDto login(UsuarioDto usuario);
}
