package cl.arkontec.app.personabck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.arkontec.app.personabck.dao.PersonaDao;
import cl.arkontec.app.personabck.domain.model.Persona;

@Service
public class PersonaServiceImpl implements PersonaService{

	@Autowired
	private PersonaDao personaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Persona> findAll() {
		return (List<Persona>)personaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Persona findById(Long id) {
		return personaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Persona create(Persona persona) {
		return personaDao.save(persona);
	}

	@Override
	@Transactional
	public Persona update(Long id, Persona datosPersona) {
		Persona persona = personaDao.findById(id).orElse(null);
		if (persona == null)
			return null;
		
		persona.setNombre(datosPersona.getNombre());
		persona.setApellidoMaterno(datosPersona.getApellidoMaterno());
		persona.setApellidoPaterno(datosPersona.getApellidoPaterno());
		persona.setDireccion(datosPersona.getDireccion());
		persona.setEstadoCivil(datosPersona.getEstadoCivil());
		persona.setOrdenApellido(datosPersona.getOrdenApellido());
		persona.setTipoPersona(datosPersona.getTipoPersona());
		return personaDao.save(persona);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		personaDao.deleteById(id);
	}

}
