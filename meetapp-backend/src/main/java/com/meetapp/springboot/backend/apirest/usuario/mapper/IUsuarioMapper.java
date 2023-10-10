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
	        "(id_usuario, nombre, email, password, biografia, avatar_file_name, avatar_base64) " +
	        "VALUES " + 
	        "(#{idUsuario}, #{nombre}, #{email}, #{password}, #{biografia}, #{avatarFileName}, #{avatarBase64})")
	@Options(useGeneratedKeys = true, keyProperty = "idUsuario")
	void register(UsuarioDto usuario);

	@Select("SELECT " +
			"id_usuario, avatar_file_name, avatar_base64, biografia, email, nombre, password " +
			"FROM meetapp.usuarios u " +
			"WHERE u.email = #{email} AND password = #{password}")
	public UsuarioDto login(UsuarioDto usuario);
	
	@Select("SELECT " +
			"email " +
			"FROM meetapp.usuarios u " +
			"WHERE u.email = #{email}")
	public Optional<UsuarioDto> findByEmail(String email);
	
	@Select("SELECT " +
			"password " +
			"FROM meetapp.usuarios u " +
			"WHERE u.email = #{email}")
	public String findPassByEmail(String email);
	
	@Select("SELECT " +
			"avatar_base64 AS avatarUsuario " +
			"FROM meetapp.usuarios u " +
			"WHERE u.id_usuario = #{idUsuario}")
	public String findAvatarById(Long idUsuario);
}
