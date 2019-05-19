package com.esteban.testingPOC.mvc.B_service;

import com.esteban.testingPOC.entity.Persona;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    public Persona getPersona(){
        return new Persona("Desde","Service");
    }

}
