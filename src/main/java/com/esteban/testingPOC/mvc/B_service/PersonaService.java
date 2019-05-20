package com.esteban.testingPOC.mvc.B_service;

import com.esteban.testingPOC.entity.Persona;
import com.esteban.testingPOC.mvc.C_repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository repository;

    public Persona getPersona(){
        Optional<Persona> optional = repository.findById(1L);
        return optional.get();
    }

}
