package com.esteban.testingPOC.mvc.C_repository;

import com.esteban.testingPOC.entity.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends CrudRepository<Long, Persona> {
}
