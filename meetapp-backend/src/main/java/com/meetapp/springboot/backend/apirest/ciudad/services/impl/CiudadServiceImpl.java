package com.meetapp.springboot.backend.apirest.ciudad.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meetapp.springboot.backend.apirest.ciudad.mapper.ICiudadMapper;
import com.meetapp.springboot.backend.apirest.ciudad.models.CiudadDto;
import com.meetapp.springboot.backend.apirest.ciudad.services.ICiudadService;

@Service
public class CiudadServiceImpl implements ICiudadService{
	
	@Autowired
	private ICiudadMapper ciudadMapper;

	@Override
	public List<CiudadDto> getAll() {
		List<CiudadDto> ciudades = ciudadMapper.getAll();
		return ciudades;
	}

}
