package com.meetapp.springboot.backend.apirest.asistente.service;

import com.meetapp.springboot.backend.apirest.asistente.models.AsistenteDto;

public interface IAsistenteService {

	AsistenteDto addAsistente(AsistenteDto asistente);

	AsistenteDto deleteAsistente(AsistenteDto asistente);
}
