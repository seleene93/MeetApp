package com.meetapp.springboot.backend.apirest.asistente.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meetapp.springboot.backend.apirest.asistente.mapper.IAsistenteMapper;
import com.meetapp.springboot.backend.apirest.asistente.models.AsistenteDto;
import com.meetapp.springboot.backend.apirest.asistente.service.IAsistenteService;

@Service
public class AsistenteServiceImpl implements IAsistenteService {
	
	@Autowired
	private IAsistenteMapper asistenteMapper;

	@Override
	public AsistenteDto addAsistente(AsistenteDto asistente) {
		asistenteMapper.addAsistente(asistente);
		return asistente;
	}

	@Override
	public AsistenteDto deleteAsistente(AsistenteDto asistente) {
		asistenteMapper.deleteAsistente(asistente);
		return asistente;
	}
}
