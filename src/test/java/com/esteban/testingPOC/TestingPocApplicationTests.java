package com.esteban.testingPOC;

import com.esteban.testingPOC.entity.Persona;
import com.esteban.testingPOC.mvc.C_repository.PersonaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 *  Integration Test
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // levanta todas las capas @RestController's, @Service's, @Repository's de tu aplicacion, configura una inmemory db.
public class TestingPocApplicationTests {

	@Autowired
	TestRestTemplate testRestTemplate;

	@MockBean
	PersonaRepository repository; // keep independent of database data

	@Test
	public void contextLoads() {

		when(repository.findById(1L)).thenReturn(Optional.of(new Persona("JuanTest", "PerezTest")));

		Persona persona = testRestTemplate.getForObject("/persona", Persona.class);

		assertThat(persona, is(new Persona("JuanTest", "PerezTest")));
	}

}
