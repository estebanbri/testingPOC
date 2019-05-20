package com.esteban.testingPOC.mockito.MVC_Testing.C_repository;

import com.esteban.testingPOC.entity.Persona;
import com.esteban.testingPOC.mvc.C_repository.PersonaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class) // SpringRunner: load Spring ApplicationContext and having beans @Autowired into your test instance
@DataJpaTest // @DataJpaTest permite testear repository's. (Crea las tablas de la BD) Will configure an in-memory embedded database, scan for @Entity classes and configure Spring Data JPA repositories. Ademas esta anotacion tambien tiene a capacidad de scanear por scripts.sql dentro de resource pero dentro de la carpeta 'test' por ende los scripts que pongas dentro de /test/resources van a ser levantados y ejecutados unicamente cuando corras la fase de mvn test de tu app.
public class PersonaRepositoryTest {

    @Autowired
    PersonaRepository repository;

    @Test
    public void m1(){
        Optional<Persona> personaOptional = repository.findById(2L);
        Persona persona = personaOptional.get();

        assertThat(persona, is(new Persona("JuanTest","PerezTest")));
    }

}
