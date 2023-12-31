package com.meetapp.springboot.backend.apirest.usuario.services.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.meetapp.springboot.backend.apirest.jwt.service.JwtService;
import com.meetapp.springboot.backend.apirest.meetup.mapper.IMeetupMapper;
import com.meetapp.springboot.backend.apirest.meetup.models.MeetupDto;
import com.meetapp.springboot.backend.apirest.usuario.mapper.IUsuarioMapper;
import com.meetapp.springboot.backend.apirest.usuario.models.UsuarioDto;
import com.meetapp.springboot.backend.apirest.usuario.services.IUsuarioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioMapper usuarioMapper;
	
	@Autowired
	private IMeetupMapper meetupMapper;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private JwtService jwtService;

	@Value("${avatar.upload.directory}")
	private String avatarUploadDirectory;

	@Override
	public UsuarioDto register(UsuarioDto usuario) throws IOException{
		
		try {
			// Obtén el avatar en Base64 y el nombre del archivo del DTO
			String avatarBase64 = usuario.getAvatarBase64();
			String avatarFileName = usuario.getAvatarFileName();
			
			// Guarda el avatar en el directorio
			saveAvatar(avatarBase64, avatarFileName);

			usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
			usuarioMapper.register(usuario);
			UsuarioDto usuarioLogueado = usuarioMapper.login(usuario);
			usuarioLogueado.setToken(jwtService.getToken(usuario));
			usuarioLogueado.setAvatarBase64(avatarBase64);
			usuarioLogueado.setAvatarFileName(avatarFileName);

			return usuarioLogueado;
		} catch (IOException e) {
			 throw new IOException("Error al registrar el usuario.", e);
		}

		
	}

	@Override
	public UsuarioDto login(UsuarioDto usuario) {
		String pass = usuarioMapper.findPassByEmail(usuario.getEmail());
		boolean correcto = bCryptPasswordEncoder.matches(usuario.getPassword(), pass);

		if (correcto == true) {
			usuario.setPassword(pass);
			UsuarioDto usuarioLogueado = usuarioMapper.login(usuario);

			if (usuarioLogueado != null) {
				usuarioLogueado.setToken(jwtService.getToken(usuario));
			}

			return usuarioLogueado;
		} else {
			UsuarioDto response = new UsuarioDto();
			response.setHasErrors(true);
			response.setError("error");
			response.setErrorCode(1L);

			return response;
		}
	}

	private String saveAvatar(String avatarBase64, String avatarFileName) throws IOException {
		try {
            byte[] decodedBytes = Base64.getDecoder().decode(avatarBase64);

            // Si no se proporciona un nombre de archivo, genera uno único
            if (avatarFileName == null || avatarFileName.isEmpty()) {
                avatarFileName = UUID.randomUUID().toString() + ".png";
            }

            // Construye la ruta completa para guardar el archivo (ajusta el directorio según tu configuración)
            Path avatarFilePath = Path.of(avatarUploadDirectory, avatarFileName);

            // Guarda los bytes decodificados en el archivo en el directorio especificado
            Files.write(avatarFilePath, decodedBytes);

            return avatarFileName;
        } catch (IOException e) {
            // Manejo de excepciones en caso de error al guardar la imagen
            throw new IOException("Error al guardar la imagen del avatar.", e);
        }
    }

	@Override
	public UsuarioDto getUsuarioById(Long idUsuario) {
		UsuarioDto response = usuarioMapper.getUsuarioById(idUsuario);
		List<MeetupDto> meetupsUsuario = usuarioMapper.getMeetupsByIdUsuario(idUsuario);
		
		if (meetupsUsuario != null && !meetupsUsuario.isEmpty() && meetupsUsuario.get(0) != null) {
			for (int i = 0; i < meetupsUsuario.size(); i++) {
				Long idMeetup = meetupsUsuario.get(i).getIdMeetup();
				Long numeroAsistentes = meetupMapper.getNumAsistentes(idMeetup);
				meetupsUsuario.get(i).setNumeroAsistentes(numeroAsistentes);
			}
		}
		
		if (response != null) {
			int meetups = meetupsUsuario.size();
			Long meetupsLong = Long.valueOf(meetups);
			response.setMeetups(meetupsUsuario);
			response.setNumeroMeetups(meetupsLong);
		}
		
		return response;
	}
}
