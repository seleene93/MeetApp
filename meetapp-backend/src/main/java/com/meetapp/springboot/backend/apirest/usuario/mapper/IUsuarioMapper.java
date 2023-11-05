package com.meetapp.springboot.backend.apirest.usuario.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.meetapp.springboot.backend.apirest.meetup.models.MeetupDto;
import com.meetapp.springboot.backend.apirest.usuario.models.UsuarioDto;

@Mapper
public interface IUsuarioMapper {

	@Insert("INSERT INTO usuarios " +
	        "(id_usuario, nombre, email, password, biografia, avatar_file_name, avatar_base64, ciudad) " +
	        "VALUES " + 
	        "(#{idUsuario}, #{nombre}, #{email}, #{password}, #{biografia}, #{avatarFileName}, #{avatarBase64}, #{ciudad})")
	@Options(useGeneratedKeys = true, keyProperty = "idUsuario")
	void register(UsuarioDto usuario);

	@Select("SELECT " +
			"id_usuario AS idUsuario, avatar_file_name AS avatarFileName, avatar_base64 AS avatarBase64, biografia, email, nombre, password, ciudad " +
			"FROM meetapp.usuarios u " +
			"WHERE u.email = #{email} AND password = #{password}")
	public UsuarioDto login(UsuarioDto usuario);
	
	@Select("SELECT " +
			"email " +
			"FROM meetapp.usuarios u " +
			"WHERE u.email = #{email}")
	public UsuarioDto findByEmail(String email);	
	
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

	@Select("SELECT " +
			"u.id_usuario AS idUsuario, " +
			"u.avatar_file_name AS avatarFileName, " +
			"u.avatar_base64 AS avatarBase64, " +
			"u.biografia, " +
			"u.email, " + 
			"u.nombre, " +
			"u.ciudad " +
			"FROM meetapp.usuarios u " +
			"WHERE u.id_usuario = #{idUsuario}")
	UsuarioDto getUsuarioById(Long idUsuario);

	@Select("SELECT " +
			"m.id_meetup AS idMeetup, " +
			"t.tipo AS tipoTematica, " +
			"c.nombre AS nombreCiudad, " +
			"m.titulo AS titulo, " +
			"m.fecha AS fecha, " +
			"m.img_file_name AS imgFileName, " +
			"m.img_base64 AS imgBase64 " +
			"FROM " +
			"meetapp.usuarios u " +
			"LEFT JOIN " +
			"meetapp.meetups m ON m.id_usuario = u.id_usuario " +
			"LEFT JOIN " +
			"meetapp.tematicas t ON t.id_tematica = m.id_tematica " +
			"LEFT JOIN " +
			"meetapp.ciudades c ON c.id_ciudad = m.id_ciudad " +
			"WHERE " +
			"u.id_usuario = #{idUsuario}")
	List<MeetupDto> getMeetupsByIdUsuario(Long idUsuario);
}
