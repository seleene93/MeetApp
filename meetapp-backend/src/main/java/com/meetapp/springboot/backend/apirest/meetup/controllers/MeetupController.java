package com.meetapp.springboot.backend.apirest.meetup.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meetapp.springboot.backend.apirest.meetup.models.GetFilterMeetupsDto;
import com.meetapp.springboot.backend.apirest.meetup.models.MeetupDto;
import com.meetapp.springboot.backend.apirest.meetup.services.IMeetupService;
import com.meetapp.springboot.backend.apirest.usuario.models.UsuarioDto;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MeetupController {

	@Autowired
	private IMeetupService meetupService;

	@PostMapping("/public/meetups")
	public List<MeetupDto> getAllFilter(@RequestBody GetFilterMeetupsDto getFilterMeetups) {
		return meetupService.getAllFilter(getFilterMeetups);
	}

	@PostMapping("/public/meetups/meetup")
	public MeetupDto getMeetupById(@RequestBody GetFilterMeetupsDto getFilterMeetups) {
		return meetupService.getMeetupById(getFilterMeetups.getIdMeetup());
	}
	
	@PostMapping("/private/meetups/nuevo")
	public MeetupDto insertMeetup(@RequestBody MeetupDto meetup) throws IOException {
		return meetupService.insertMeetup(meetup);
	}
	
	@PostMapping("/public/meetups/asistentes")
	public List<UsuarioDto> getMeetupAssist(@RequestBody Long idMeetup) {
		return meetupService.getMeetupAssist(idMeetup);
	}
}
