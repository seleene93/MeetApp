package com.meetapp.springboot.backend.apirest.tematica.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.meetapp.springboot.backend.apirest.tematica.models.TematicaDto;

@Mapper
public interface ITematicaMapper {

	@Select("SELECT " +
            "t.id_tematica AS idTematica, " +
            "t.tipo AS tipo " +
            "FROM meetapp.tematicas t " +
            "ORDER BY tipo")
	public List<TematicaDto> getAll();
}
