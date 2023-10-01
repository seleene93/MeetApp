package com.meetapp.springboot.backend.apirest.meetup.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meetapp.springboot.backend.apirest.meetup.models.GetFilterMeetupsDto;
import com.meetapp.springboot.backend.apirest.meetup.models.MeetupDto;
import com.meetapp.springboot.backend.apirest.meetup.services.IMeetupService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class MeetupController {

	@Autowired
	private IMeetupService meetupService;
	
	@GetMapping("/meetups")
	public List<MeetupDto> getAll() {
		return meetupService.getAll();
	}
	
	@PostMapping("/meetups")
	public List<MeetupDto> getAllFilter(@RequestBody GetFilterMeetupsDto getFilterMeetups) {
	    Long idTematica = getFilterMeetups.getIdTematica();
	    Long idCiudad = getFilterMeetups.getIdCiudad();
	    
	    if (idTematica != null && idCiudad != null) {
	        // Ambos parámetros están presentes, realizar búsqueda con ambos
	        return meetupService.getAllFilter(idTematica, idCiudad);
	    } else if (idTematica != null && idCiudad == null) {
	        // Solo se proporcionó idTematica, realizar búsqueda por idTematica
	        return meetupService.getAllFilterByIdTematica(idTematica);
	    } else if (idCiudad != null && idTematica == null) {
	        // Solo se proporcionó idCiudad, realizar búsqueda por idCiudad
	        return meetupService.getAllFilterByIdCiudad(idCiudad);
	    }
	    
	    return meetupService.getAll();
	}
	
	@PostMapping("/meetups/meetup")
	public MeetupDto getMeetupById(@RequestBody GetFilterMeetupsDto getFilterMeetups) {
		return meetupService.getMeetupById(getFilterMeetups.getIdMeetup());
	}
}
