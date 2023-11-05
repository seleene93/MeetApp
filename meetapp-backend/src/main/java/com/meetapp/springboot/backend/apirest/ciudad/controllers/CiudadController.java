package com.meetapp.springboot.backend.apirest.ciudad.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meetapp.springboot.backend.apirest.ciudad.models.CiudadDto;
import com.meetapp.springboot.backend.apirest.ciudad.services.ICiudadService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CiudadController {

	@Autowired
	private ICiudadService ciudadService;
	
	@GetMapping("/public/ciudades")
	public List<CiudadDto> getAll() {
		return ciudadService.getAll();
	}
}