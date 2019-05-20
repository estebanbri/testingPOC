package com.esteban.testingPOC.mockito.MVC_Testing.B_service;

import com.esteban.testingPOC.entity.Persona;
import com.esteban.testingPOC.mvc.B_service.PersonaService;
import com.esteban.testingPOC.mvc.C_repository.PersonaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Nota: es mucho mas simple testear service porque no usas ningun feature de spring at all. Simplemente testear como si fuera clases comun y corriente usando Mockito anottations
 */

@RunWith(MockitoJUnitRunner.class) // MockitoJUnitRunner: provides support for creating mocks and spies with Mockito
public class PersonaServiceTest {

    @Mock
    PersonaRepository repository;

    @InjectMocks
    PersonaService service;

    @Test
    public void m1(){

        when(repository.findById(1L)).thenReturn(Optional.of(new Persona("Soy", "Mock")));
        Persona persona = service.getPersona();
        assertThat(persona, is(new Persona("Soy","Mock")));
    }
}

//                +-----------------+       +------------+
//  Testeando ->  |                 |   <-  | @MockBean  |
//                |-----------------|       |------------|
//                | @RestController |       | @Service   |
//                +-----------------+       +------------+
