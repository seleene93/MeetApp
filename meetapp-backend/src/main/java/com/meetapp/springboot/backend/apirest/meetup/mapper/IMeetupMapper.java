package com.meetapp.springboot.backend.apirest.meetup.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.meetapp.springboot.backend.apirest.meetup.models.MeetupDto;
import com.meetapp.springboot.backend.apirest.usuario.models.UsuarioDto;

@Mapper
public interface IMeetupMapper {

	@Select("SELECT " +
            "m.id_meetup AS idMeetup, " +
            "m.id_usuario AS idUsuario, " +
            "t.id_tematica AS idTematica, " +
            "t.tipo AS tipoTematica, " +
            "c.id_ciudad AS idCiudad, " +
            "c.nombre AS nombreCiudad, " +
            "m.titulo AS titulo, " +
            "m.fecha AS fecha, " +
            "m.descripcion AS descripcion, " +
            "m.foto AS foto " +
            "FROM meetapp.meetups m " +
            "LEFT JOIN meetapp.tematicas t " +
            "ON t.id_tematica = m.id_tematica " +
            "LEFT JOIN meetapp.ciudades c " +
            "ON c.id_ciudad = m.id_ciudad " +
            "ORDER BY fecha ASC")
	public List<MeetupDto> getAll();
	
	@Select("SELECT " +
            "m.id_meetup AS idMeetup, " +
            "m.id_usuario AS idUsuario, " +
            "t.tipo AS tipoTematica, " +
            "c.nombre AS nombreCiudad, " +
            "m.titulo AS titulo, " +
            "m.fecha AS fecha, " +
            "m.descripcion AS descripcion, " +
            "m.foto AS foto " +
            "FROM meetapp.meetups m " +
            "LEFT JOIN meetapp.ciudades c " +
            "ON c.id_ciudad = m.id_ciudad " +
            "LEFT JOIN meetapp.tematicas t " +
            "ON t.id_tematica = m.id_tematica " +
            "WHERE m.id_tematica = #{idTematica} AND m.id_ciudad = #{idCiudad} " +
            "ORDER BY fecha ASC")
	public List<MeetupDto> getAllFilter(@Param("idTematica") Long idTematica, @Param("idCiudad") Long idCiudad);
	
	@Select("SELECT " +
            "m.id_meetup AS idMeetup, " +
            "m.id_usuario AS idUsuario, " +
            "t.tipo AS tipoTematica, " +
            "c.nombre AS nombreCiudad, " +
            "m.titulo AS titulo, " +
            "m.fecha AS fecha, " +
            "m.descripcion AS descripcion, " +
            "m.foto AS foto " +
            "FROM meetapp.meetups m " +
            "LEFT JOIN meetapp.ciudades c " +
            "ON c.id_ciudad = m.id_ciudad " +
            "LEFT JOIN meetapp.tematicas t " +
            "ON t.id_tematica = m.id_tematica " +
            "WHERE m.id_tematica = #{idTematica} " +
            "ORDER BY fecha ASC")
	public List<MeetupDto> getAllFilterByIdTematica(@Param("idTematica") Long idTematica);
	
	@Select("SELECT " +
            "m.id_meetup AS idMeetup, " +
            "m.id_usuario AS idUsuario, " +
            "t.tipo AS tipoTematica, " +
            "c.nombre AS nombreCiudad, " +
            "m.titulo AS titulo, " +
            "m.fecha AS fecha, " +
            "m.descripcion AS descripcion, " +
            "m.foto AS foto " +
            "FROM meetapp.meetups m " +
            "LEFT JOIN meetapp.ciudades c " +
            "ON c.id_ciudad = m.id_ciudad " +
            "LEFT JOIN meetapp.tematicas t " +
            "ON t.id_tematica = m.id_tematica " +
            "WHERE m.id_ciudad = #{idCiudad} " +
            "ORDER BY fecha ASC")
	public List<MeetupDto> getAllFilterByIdCiudad(@Param("idCiudad") Long idCiudad);

	@Select("SELECT " +
            "m.id_meetup AS idMeetup, " +
            "m.id_usuario AS idUsuario, " +
            "t.tipo AS tipoTematica, " +
            "c.nombre AS nombreCiudad, " +
            "m.titulo AS titulo, " +
            "m.fecha AS fecha, " +
            "m.descripcion AS descripcion, " +
            "m.foto AS foto " +
            "FROM meetapp.meetups m " +
            "LEFT JOIN meetapp.ciudades c " +
            "ON c.id_ciudad = m.id_ciudad " +
            "LEFT JOIN meetapp.tematicas t " +
            "ON t.id_tematica = m.id_tematica " +
            "WHERE m.id_meetup = #{idMeetup} ")
	public MeetupDto getMeetupById(Long idMeetup);

	@Select("SELECT " +
			"count(a.id_usuario) AS numeroAsistentes " + 
			"FROM " +
			"meetapp.asistentes a " +
			"WHERE " +
			"a.id_meetup = #{idMeetup} ")
	public Long getNumAsistentes(@Param("idMeetup") Long idMeetup);
	
	@Select("SELECT " +
			"id_usuario " +
			"FROM meetapp.asistentes a " +
			"WHERE " +
			"a.id_meetup = #{idMeetup}")
	public List<Long> getIdsUsuariosAsistentes(@Param("idMeetup") Long idMeetup);
	
	@Select ("SELECT " +
			"u.nombre " +
			"FROM meetapp.usuarios u " +
			"WHERE " +
			"id_usuario = #{idUsuario}")
	public UsuarioDto getUsuarioAsistentes(@Param("idUsuario") Long idUsuario);
}
