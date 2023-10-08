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
		List<MeetupDto> meetups = meetupMapper.getAll();
		
		for (int i = 0; i < meetups.size(); i++) {
			Long idMeetup = meetups.get(i).getIdMeetup();
			Long numeroAsistentes = meetupMapper.getNumAsistentes(idMeetup);
			meetups.get(i).setNumeroAsistentes(numeroAsistentes);
		}
		
		return meetups;
	}

	@Override
	public List<MeetupDto> getAllFilter(Long idTematica, Long idCiudad) {
		List<MeetupDto> meetups = meetupMapper.getAllFilter(idTematica, idCiudad);
		
		for (int i = 0; i < meetups.size(); i++) {
			Long idMeetup = meetups.get(i).getIdMeetup();
			Long numeroAsistentes = meetupMapper.getNumAsistentes(idMeetup);
			meetups.get(i).setNumeroAsistentes(numeroAsistentes);
		}
		
		return meetups;
	}

	@Override
	public List<MeetupDto> getAllFilterByIdTematica(Long idTematica) {
		List<MeetupDto> meetups = meetupMapper.getAllFilterByIdTematica(idTematica);
		
		for (int i = 0; i < meetups.size(); i++) {
			Long idMeetup = meetups.get(i).getIdMeetup();
			Long numeroAsistentes = meetupMapper.getNumAsistentes(idMeetup);
			meetups.get(i).setNumeroAsistentes(numeroAsistentes);
		}
		
		return meetups;
	}

	@Override
	public List<MeetupDto> getAllFilterByIdCiudad(Long idCiudad) {
		List<MeetupDto> meetups = meetupMapper.getAllFilterByIdCiudad(idCiudad);
		
		for (int i = 0; i < meetups.size(); i++) {
			Long idMeetup = meetups.get(i).getIdMeetup();
			Long numeroAsistentes = meetupMapper.getNumAsistentes(idMeetup);
			meetups.get(i).setNumeroAsistentes(numeroAsistentes);
		}
		
		return meetups;
	}

	@Override
	public MeetupDto getMeetupById(Long idMeetup) {
		MeetupDto response = meetupMapper.getMeetupById(idMeetup);
		Long numeroAsistentes = meetupMapper.getNumAsistentes(idMeetup);
		List<UsuarioDto> usuariosAsistentes = getUsuariosAsistentes(idMeetup);
		
		if (response != null) {
		response.setNumeroAsistentes(numeroAsistentes);
		response.setUsuarios(usuariosAsistentes);
		}
		
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

	@Override
	public MeetupDto insertMeetup(MeetupDto meetup) {
		meetupMapper.insertMeetup(meetup);
		return meetup;
	}
}
