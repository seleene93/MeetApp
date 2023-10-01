package com.meetapp.springboot.backend.apirest.usuario.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.meetapp.springboot.backend.apirest.usuario.models.UsuarioDto;

@Mapper
public interface IUsuarioMapper {

	@Insert("INSERT INTO usuarios " +
	        "(id_usuario, nombre, email, password, biografia, avatar) " +
	        "VALUES " + 
	        "(#{idUsuario}, #{nombre}, #{email}, #{password}, #{biografia}, #{avatar})")
	void register(UsuarioDto usuario);

	@Select("SELECT " +
			"id_usuario, avatar, biografia, email, nombre, password " +
			"FROM meetapp.usuarios u " +
			"WHERE u.email = #{email} AND password = #{password}")
	public UsuarioDto login(UsuarioDto usuario);
}
