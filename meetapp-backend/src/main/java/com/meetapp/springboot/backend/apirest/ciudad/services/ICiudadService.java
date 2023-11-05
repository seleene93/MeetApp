package com.meetapp.springboot.backend.apirest.ciudad.services;

import java.util.List;

import com.meetapp.springboot.backend.apirest.ciudad.models.CiudadDto;

public interface ICiudadService {
	
	public List<CiudadDto> getAll();
}
