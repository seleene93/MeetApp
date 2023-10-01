package com.meetapp.springboot.backend.apirest.meetup.models;

public class GetFilterMeetupsDto {
	
	private Long idMeetup;

	private Long idTematica;
	
	private Long idCiudad;

	public Long getIdMeetup() {
		return idMeetup;
	}

	public void setIdMeetup(Long idMeetup) {
		this.idMeetup = idMeetup;
	}

	public Long getIdTematica() {
		return idTematica;
	}

	public void setIdTematica(Long idTematica) {
		this.idTematica = idTematica;
	}

	public Long getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}
}
