package com.meetapp.springboot.backend.apirest.meetup.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.meetapp.springboot.backend.apirest.usuario.models.UsuarioDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name="meetups")
public class MeetupDto implements Serializable {

	private static final long serialVersionUID = -8786188974782194720L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMeetup;
	
	private Long idUsuario;
	
	private Long idTematica;
	
	@Transient
	private String tipoTematica;
	
	private Long idCiudad;
	
	@Transient
	private String nombreCiudad;
	
	private String titulo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	private String descripcion;
	
	@Transient
	private List<UsuarioDto> usuarios;
	
	@Transient
	private Long numeroAsistentes;
	
	@Lob
	@Column(name = "img_base64", columnDefinition = "BLOB")
	private String imgBase64;
	
	private String imgFileName;
	
	@Transient
	private String avatarUsuario;

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

	public Long getIdTematica() {
		return idTematica;
	}

	public void setIdTematica(Long idTematica) {
		this.idTematica = idTematica;
	}

	public String getTipoTematica() {
		return tipoTematica;
	}

	public void setTipoTematica(String tipoTematica) {
		this.tipoTematica = tipoTematica;
	}

	public Long getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombreCiudad() {
		return nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<UsuarioDto> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioDto> usuarios) {
		this.usuarios = usuarios;
	}

	public Long getNumeroAsistentes() {
		return numeroAsistentes;
	}

	public void setNumeroAsistentes(Long numeroAsistentes) {
		this.numeroAsistentes = numeroAsistentes;
	}

	public String getImgBase64() {
		return imgBase64;
	}

	public void setImgBase64(String imgBase64) {
		this.imgBase64 = imgBase64;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public String getAvatarUsuario() {
		return avatarUsuario;
	}

	public void setAvatarUsuario(String avatarUsuario) {
		this.avatarUsuario = avatarUsuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
