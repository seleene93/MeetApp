package com.meetapp.springboot.backend.apirest.tematica.services;

import java.util.List;

import com.meetapp.springboot.backend.apirest.tematica.models.TematicaDto;

public interface ITematicaService {

	List<TematicaDto> getAll();
}
