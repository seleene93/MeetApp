package com.meetapp.springboot.backend.apirest.ciudad.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ciudades")
public class CiudadDto implements Serializable {
	
	private static final long serialVersionUID = 1489714373429938896L;
	
	@Id
	private Long idCiudad;
	
	private String nombre;

	public Long getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
