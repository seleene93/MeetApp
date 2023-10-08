package com.meetapp.springboot.backend.apirest.usuario.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.meetapp.springboot.backend.apirest.usuario.models.UsuarioDto;

@Mapper
public interface IUsuarioMapper {

	@Insert("INSERT INTO usuarios " +
	        "(id_usuario, nombre, email, password, biografia, avatar) " +
	        "VALUES " + 
	        "(#{idUsuario}, #{nombre}, #{email}, #{password}, #{biografia}, #{avatar})")
	@Options(useGeneratedKeys = true, keyProperty = "idUsuario")
	void register(UsuarioDto usuario);

	@Select("SELECT " +
			"id_usuario, avatar, biografia, email, nombre, password " +
			"FROM meetapp.usuarios u " +
			"WHERE u.email = #{email} AND password = #{password}")
	public UsuarioDto login(UsuarioDto usuario);
	
	@Select("SELECT " +
			"email " +
			"FROM meetapp.usuarios u " +
			"WHERE u.email = #{email}")
	public Optional<UsuarioDto> findByEmail(String email);
}
