package com.meetapp.springboot.backend.apirest.meetup.services.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.meetapp.springboot.backend.apirest.meetup.mapper.IMeetupMapper;
import com.meetapp.springboot.backend.apirest.meetup.models.GetFilterMeetupsDto;
import com.meetapp.springboot.backend.apirest.meetup.models.MeetupDto;
import com.meetapp.springboot.backend.apirest.meetup.services.IMeetupService;
import com.meetapp.springboot.backend.apirest.usuario.mapper.IUsuarioMapper;
import com.meetapp.springboot.backend.apirest.usuario.models.UsuarioDto;

@Service
public class MeetupServiceImpl implements IMeetupService {

	@Autowired
	private IMeetupMapper meetupMapper;

	@Autowired
	private IUsuarioMapper usuarioMapper;

	@Value("${img.upload.directory}")
	private String imgUploadDirectory;

	@Override
	public List<MeetupDto> getAllFilter(GetFilterMeetupsDto getFilterMeetups) {
		Long idTematica = getFilterMeetups.getIdTematica();
		Long idCiudad = getFilterMeetups.getIdCiudad();
		List<MeetupDto> meetups = new ArrayList<>();

		if (idTematica != null && idCiudad == null) {
			meetups = getAllFilterByIdTematica(idTematica); // Solo se proporcionó idTematica, realizar búsqueda por idTematica
		} else if (idCiudad != null && idTematica == null) {
			meetups = getAllFilterByIdCiudad(idCiudad); // Solo se proporcionó idCiudad, realizar búsqueda por idCiudad
		} else {
			meetups = meetupMapper.getAll();
		}

		setAvatarsAndAssists(meetups);

		return meetups;
	}

	private void setAvatarsAndAssists(List<MeetupDto> meetups) {
		if (meetups != null && !meetups.isEmpty()) {
			for (int i = 0; i < meetups.size(); i++) {
				Long idMeetup = meetups.get(i).getIdMeetup();
				Long numeroAsistentes = meetupMapper.getNumAsistentes(idMeetup);
				meetups.get(i).setNumeroAsistentes(numeroAsistentes);
				
				Long idUsuario = meetups.get(i).getIdUsuario();
				String avatarUsuario = usuarioMapper.findAvatarById(idUsuario);
				meetups.get(i).setAvatarUsuario(avatarUsuario);
			}
		}
	}

	private List<MeetupDto> getAllFilterByIdTematica(Long idTematica) {
		List<MeetupDto> meetups = meetupMapper.getAllFilterByIdTematica(idTematica);

		for (int i = 0; i < meetups.size(); i++) {
			Long idMeetup = meetups.get(i).getIdMeetup();
			Long numeroAsistentes = meetupMapper.getNumAsistentes(idMeetup);
			meetups.get(i).setNumeroAsistentes(numeroAsistentes);
		}

		return meetups;
	}

	private List<MeetupDto> getAllFilterByIdCiudad(Long idCiudad) {
		List<MeetupDto> meetups = meetupMapper.getAllFilterByIdCiudad(idCiudad);

		for (int i = 0; i < meetups.size(); i++) {
			Long idMeetup = meetups.get(i).getIdMeetup();
			Long numeroAsistentes = meetupMapper.getNumAsistentes(idMeetup);
			meetups.get(i).setNumeroAsistentes(numeroAsistentes);
		}

		return meetups;
	}

	@Override
	public MeetupDto getMeetupById(Long idMeetup) {
		MeetupDto response = meetupMapper.getMeetupById(idMeetup);
		List<UsuarioDto> usuariosAsistentes = getUsuariosAsistentes(idMeetup);

		if (response != null) {
			int asistentes = usuariosAsistentes.size();
			Long asistentesLong = Long.valueOf(asistentes);
			response.setNumeroAsistentes(asistentesLong);
			response.setUsuarios(usuariosAsistentes);
		}

		return response;
	}

	private List<UsuarioDto> getUsuariosAsistentes(Long idMeetup) {
		List<UsuarioDto> usuariosAsistentes = new ArrayList<>();
		List<Long> idsUsuariosAsistentes = meetupMapper.getIdsUsuariosAsistentes(idMeetup);

		for (Long id : idsUsuariosAsistentes) {
			UsuarioDto usuarioAsistente = meetupMapper.getUsuarioAsistentes(id);
			usuarioAsistente.setIdUsuario(id);
			usuariosAsistentes.add(usuarioAsistente);
		}

		return usuariosAsistentes;
	}

	@Override
	public MeetupDto insertMeetup(MeetupDto meetup) throws IOException {
		String imgBase64 = meetup.getImgBase64();
		String imgFileName = meetup.getImgFileName();

		saveImg(imgBase64, imgFileName);

		meetup.setImgBase64(imgBase64);
		meetup.setImgFileName(imgFileName);
		meetupMapper.insertMeetup(meetup);

		return meetup;
	}

	private String saveImg(String imgBase64, String imgFileName) throws IOException {
		try {
			byte[] decodedBytes = Base64.getDecoder().decode(imgBase64);

			// Si no se proporciona un nombre de archivo, genera uno único
			if (imgFileName == null || imgFileName.isEmpty()) {
				imgFileName = UUID.randomUUID().toString() + ".png";
			}

			// Construye la ruta completa para guardar el archivo (ajusta el directorio
			// según tu configuración)
			Path avatarFilePath = Path.of(imgUploadDirectory, imgFileName);

			// Guarda los bytes decodificados en el archivo en el directorio especificado
			Files.write(avatarFilePath, decodedBytes);

			return imgFileName;
		} catch (IOException e) {
			// Manejo de excepciones en caso de error al guardar la imagen
			throw new IOException("Error al guardar la imagen del avatar.", e);
		}
	}

	@Override
	public List<UsuarioDto> getMeetupAssist(Long idMeetup) {
		return getUsuariosAsistentes(idMeetup);
	}
}
