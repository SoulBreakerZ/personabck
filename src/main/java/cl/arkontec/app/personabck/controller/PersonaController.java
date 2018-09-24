package cl.arkontec.app.personabck.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import cl.arkontec.app.personabck.domain.model.Persona;
import cl.arkontec.app.personabck.service.PersonaService;

@RequestMapping("/api")
@RestController
public class PersonaController {

	@Autowired
	private PersonaService personaService;
	
	@GetMapping("/clientes")
	@ResponseStatus(HttpStatus.OK)
	public List<Persona> getPersonas(
			HttpServletRequest request, 
			HttpServletResponse response){
		return this.personaService.findAll();
	}
	
	@GetMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Persona getPersonaById(
			HttpServletRequest request, 
			HttpServletResponse response,
			@PathVariable Long id){
		return this.personaService.findById(id);
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Persona createPersona(
			HttpServletRequest request, 
			HttpServletResponse response,
			@RequestBody Persona persona){
		return this.personaService.create(persona);
	}
	
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Persona updatePersona(
			HttpServletRequest request, 
			HttpServletResponse response,
			@PathVariable Long id,
			@RequestBody Persona personaAct){
		return this.personaService.update(id,personaAct);
	}
	
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePersona(
			HttpServletRequest request, 
			HttpServletResponse response,
			@PathVariable Long id){
		this.personaService.delete(id);
	}
}
