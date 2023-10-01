package com.meetapp.springboot.backend.apirest.usuario.services.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meetapp.springboot.backend.apirest.usuario.mapper.IUsuarioMapper;
import com.meetapp.springboot.backend.apirest.usuario.models.UsuarioDto;
import com.meetapp.springboot.backend.apirest.usuario.services.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioMapper usuarioMapper;

	@Override
	public UsuarioDto register(UsuarioDto usuario) {
		usuarioMapper.register(usuario);
		return usuario;
	}

	@Override
	public UsuarioDto login(UsuarioDto usuario) {
		usuarioMapper.login(usuario);
		return usuario;
	}
}
