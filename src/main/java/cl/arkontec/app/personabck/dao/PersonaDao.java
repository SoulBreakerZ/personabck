package cl.arkontec.app.personabck.dao;

import org.springframework.data.repository.CrudRepository;
import cl.arkontec.app.personabck.domain.model.Persona;

public interface PersonaDao extends CrudRepository<Persona, Long>{

}
