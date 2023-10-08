package com.meetapp.springboot.backend.apirest.meetup.services;

import java.util.List;

import com.meetapp.springboot.backend.apirest.meetup.models.MeetupDto;

public interface IMeetupService {

	public List<MeetupDto> getAll();

	public List<MeetupDto> getAllFilter(Long idTematica, Long idCiudad);

	public List<MeetupDto> getAllFilterByIdTematica(Long idTematica);

	public List<MeetupDto> getAllFilterByIdCiudad(Long idCiudad);

	public MeetupDto getMeetupById(Long idMeetup);

	public MeetupDto insertMeetup(MeetupDto meetup);
}
