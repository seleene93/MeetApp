package com.meetapp.springboot.backend.apirest.tematica.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meetapp.springboot.backend.apirest.tematica.mapper.ITematicaMapper;
import com.meetapp.springboot.backend.apirest.tematica.models.TematicaDto;
import com.meetapp.springboot.backend.apirest.tematica.services.ITematicaService;

@Service
public class TematicaServiceImpl implements ITematicaService {

	@Autowired
	private ITematicaMapper tematicaMapper;

	@Override
	public List<TematicaDto> getAll() {
		List<TematicaDto> tematicas = tematicaMapper.getAll();
		return tematicas;
	}
}
