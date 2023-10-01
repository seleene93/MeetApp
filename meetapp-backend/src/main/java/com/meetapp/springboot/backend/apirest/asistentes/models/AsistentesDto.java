package com.meetapp.springboot.backend.apirest.asistentes.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="asistentes")
public class AsistentesDto implements Serializable {

	private static final long serialVersionUID = -3948062399562544637L;
	
	@Id
	private Long idAsistencia;
	
	private Long idMeetup;
	
	private Long idUsuario;

	public Long getIdAsistencia() {
		return idAsistencia;
	}

	public void setIdAsistencia(Long idAsistencia) {
		this.idAsistencia = idAsistencia;
	}

	public Long getIdMeetup() {
		return idMeetup;
	}

	public void setIdMeetup(Long idMeetup) {
		this.idMeetup = idMeetup;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
