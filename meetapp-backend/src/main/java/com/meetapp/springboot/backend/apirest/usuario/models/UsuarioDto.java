package com.meetapp.springboot.backend.apirest.usuario.models;

import java.io.Serializable;
import java.util.List;

import com.meetapp.springboot.backend.apirest.auth.models.ErrorDto;
import com.meetapp.springboot.backend.apirest.meetup.models.MeetupDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="usuarios", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class UsuarioDto extends ErrorDto implements Serializable {

	private static final long serialVersionUID = -3228420481940170315L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	private String nombre;
	
	@Column(nullable = false)
	private String email;
	
	private String password;
	
	private String biografia;

	@Lob
	@Column(name = "avatar_base64", columnDefinition = "BLOB")
	private String avatarBase64;
	
	@Column(name = "avatar_file_name")
	private String avatarFileName;
	
	@Transient
	private String token;

	@Transient
	private Long numeroMeetups;
	
	@Transient
	private List<MeetupDto> meetups;
	
	private String ciudad;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getAvatarBase64() {
		return avatarBase64;
	}

	public void setAvatarBase64(String avatarBase64) {
		this.avatarBase64 = avatarBase64;
	}

	public String getAvatarFileName() {
		return avatarFileName;
	}

	public void setAvatarFileName(String avatarFileName) {
		this.avatarFileName = avatarFileName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getNumeroMeetups() {
		return numeroMeetups;
	}

	public void setNumeroMeetups(Long numeroMeetups) {
		this.numeroMeetups = numeroMeetups;
	}

	public List<MeetupDto> getMeetups() {
		return meetups;
	}

	public void setMeetups(List<MeetupDto> meetups) {
		this.meetups = meetups;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
