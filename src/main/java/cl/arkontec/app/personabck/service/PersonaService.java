package cl.arkontec.app.personabck.service;

import java.util.List;

import cl.arkontec.app.personabck.domain.model.Persona;

public interface PersonaService {
	public List<Persona> findAll();
	public Persona findById(Long id);
	public Persona create(Persona persona);
	public Persona update(Long id, Persona datosPersona);
	public void delete(Long id);
}
