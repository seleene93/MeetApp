package com.meetapp.springboot.backend.apirest.tematica.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tematicas")
public class TematicaDto implements Serializable {

	private static final long serialVersionUID = -1618476440261950707L;
	
	@Id
	private Long idTematica;
	
	private String tipo;

	public Long getIdTematica() {
		return idTematica;
	}

	public void setIdTematica(Long idTematica) {
		this.idTematica = idTematica;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
