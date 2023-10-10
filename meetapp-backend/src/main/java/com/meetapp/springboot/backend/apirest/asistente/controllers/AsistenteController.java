package com.meetapp.springboot.backend.apirest.asistente.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meetapp.springboot.backend.apirest.asistente.models.AsistenteDto;
import com.meetapp.springboot.backend.apirest.asistente.service.IAsistenteService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class AsistenteController {

	@Autowired
	private IAsistenteService asistenteService;
	
	@PostMapping("/private/crear-asistencia")
	public AsistenteDto addAsistente(@RequestBody AsistenteDto asistente) {
		return asistenteService.addAsistente(asistente);
	}
	
	@PostMapping("/private/eliminar-asistencia")
	public AsistenteDto deleteAsistente(@RequestBody AsistenteDto asistente) {
		return asistenteService.deleteAsistente(asistente);
	}
}
