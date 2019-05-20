package com.esteban.testingPOC.mvc.C_repository;

import com.esteban.testingPOC.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
