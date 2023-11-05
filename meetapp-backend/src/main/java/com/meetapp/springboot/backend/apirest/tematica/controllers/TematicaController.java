package com.meetapp.springboot.backend.apirest.tematica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meetapp.springboot.backend.apirest.tematica.models.TematicaDto;
import com.meetapp.springboot.backend.apirest.tematica.services.ITematicaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TematicaController {

	@Autowired
	private ITematicaService tematicaService;
	
	@GetMapping("/public/tematicas")
	public List<TematicaDto> getAll() {
		return tematicaService.getAll();
	}
}
