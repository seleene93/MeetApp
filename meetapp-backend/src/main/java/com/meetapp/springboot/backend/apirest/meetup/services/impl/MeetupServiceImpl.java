package com.meetapp.springboot.backend.apirest.meetup.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meetapp.springboot.backend.apirest.meetup.mapper.IMeetupMapper;
import com.meetapp.springboot.backend.apirest.meetup.models.MeetupDto;
import com.meetapp.springboot.backend.apirest.meetup.services.IMeetupService;
import com.meetapp.springboot.backend.apirest.usuario.models.UsuarioDto;

@Service
public class MeetupServiceImpl implements IMeetupService {

	@Autowired
	private IMeetupMapper meetupMapper;

	@Override
	public List<MeetupDto> getAll() {
		return (List<MeetupDto>) meetupMapper.getAll();
	}

	@Override
	public List<MeetupDto> getAllFilter(Long idTematica, Long idCiudad) {
		return (List<MeetupDto>) meetupMapper.getAllFilter(idTematica, idCiudad);
	}

	@Override
	public List<MeetupDto> getAllFilterByIdTematica(Long idTematica) {
		return (List<MeetupDto>) meetupMapper.getAllFilterByIdTematica(idTematica);
	}

	@Override
	public List<MeetupDto> getAllFilterByIdCiudad(Long idCiudad) {
		return (List<MeetupDto>) meetupMapper.getAllFilterByIdCiudad(idCiudad);
	}

	@Override
	public MeetupDto getMeetupById(Long idMeetup) {
		MeetupDto response = meetupMapper.getMeetupById(idMeetup);
		Long numeroAsistentes = meetupMapper.getNumAsistentes(idMeetup);
		response.setNumeroAsistentes(numeroAsistentes);
		
		List<UsuarioDto> usuariosAsistentes = getUsuariosAsistentes(idMeetup);
		response.setUsuarios(usuariosAsistentes);
		
		return response;
	}

	public List<UsuarioDto> getUsuariosAsistentes(Long idMeetup) {
		List<UsuarioDto> usuariosAsistentes = new ArrayList<>();
		List<Long> idsUsuariosAsistentes = meetupMapper.getIdsUsuariosAsistentes(idMeetup);
		
		for (Long id : idsUsuariosAsistentes) {
			UsuarioDto usuarioAsistente = meetupMapper.getUsuarioAsistentes(id);
			usuarioAsistente.setIdUsuario(id);
			usuariosAsistentes.add(usuarioAsistente);
		}
		
		return usuariosAsistentes;
	}
}