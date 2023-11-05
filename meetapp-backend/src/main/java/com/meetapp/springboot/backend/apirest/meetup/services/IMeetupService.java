package com.meetapp.springboot.backend.apirest.meetup.services;

import java.io.IOException;
import java.util.List;

import com.meetapp.springboot.backend.apirest.meetup.models.GetFilterMeetupsDto;
import com.meetapp.springboot.backend.apirest.meetup.models.MeetupDto;
import com.meetapp.springboot.backend.apirest.usuario.models.UsuarioDto;

public interface IMeetupService {

	public List<MeetupDto> getAllFilter(GetFilterMeetupsDto getFilterMeetups);

	public MeetupDto getMeetupById(Long idMeetup);

	public MeetupDto insertMeetup(MeetupDto meetup) throws IOException;
	
	public List<UsuarioDto> getMeetupAssist(Long idMeetup);
}
