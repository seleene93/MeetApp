package com.meetapp.springboot.backend.apirest.ciudad.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.meetapp.springboot.backend.apirest.ciudad.models.CiudadDto;

@Mapper
public interface ICiudadMapper {

	@Select("SELECT " +
            "c.id_ciudad AS idCiudad, " +
            "c.nombre AS nombre " +
            "FROM meetapp.ciudades c " +
            "ORDER BY nombre")
	public List<CiudadDto> getAll();
	
}
