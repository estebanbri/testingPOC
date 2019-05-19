package com.esteban.testingPOC.mvc.A_controller;

import com.esteban.testingPOC.entity.Persona;
import com.esteban.testingPOC.mvc.B_service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {

    @Autowired
    private PersonaService service;

    @GetMapping("/persona")
    public Persona getPersona(){
        Persona persona = service.getPersona();
        return persona;
    }
}
