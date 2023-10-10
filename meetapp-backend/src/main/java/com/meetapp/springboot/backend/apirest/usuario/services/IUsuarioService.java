package com.meetapp.springboot.backend.apirest.usuario.services;

import java.io.IOException;


import com.meetapp.springboot.backend.apirest.usuario.models.UsuarioDto;

public interface IUsuarioService {

	public UsuarioDto register(UsuarioDto usuario) throws IOException;

	public UsuarioDto login(UsuarioDto usuario);
}
