package com.meetapp.springboot.backend.apirest.asistente.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.meetapp.springboot.backend.apirest.asistente.models.AsistenteDto;

@Mapper
public interface IAsistenteMapper {

	@Insert("INSERT INTO asistentes " +
	        "(id_asistencia, id_usuario, id_meetup) " +
	        "VALUES " + 
	        "(#{idAsistencia}, #{idUsuario}, #{idMeetup})")
	@Options(useGeneratedKeys = true, keyProperty = "idAsistencia")
	boolean addAsistente(AsistenteDto asistente);

	@Delete("DELETE FROM asistentes " + 
			"WHERE " + 
			"id_meetup = #{idMeetup}")
	boolean deleteAsistente(AsistenteDto asistente);
}
