package com.esteban.testingPOC.mockito.MVC_Testing.A_controller;

import com.esteban.testingPOC.entity.Persona;
import com.esteban.testingPOC.mvc.A_controller.PersonaController;
import com.esteban.testingPOC.mvc.B_service.PersonaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Nota:  testear controllers es mas complicado porque las pruebas involucran HTTP request-response, por ende necesitas loadear el Spring Context y usar MockMvc para simular los Http Request.
 */

@RunWith(SpringRunner.class) // SpringRunner: load Spring ApplicationContext and having beans @Autowired into your test instance
@WebMvcTest(PersonaController.class)  // only loads web-layer (@RestController), no va loader @Service ni @Repository no son loaded por ende no te queda otra opcion que Mockear el @Service sino te explota)
@AutoConfigureMockMvc
public class PersonaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PersonaService service;

    @Test
    public void m123() throws Exception {

        when(service.getPersona()).thenReturn(new Persona("Soy","Mock"));

        MvcResult mvcResult = mockMvc.perform(get("/persona"))
                                     .andReturn();

        assertThat(mvcResult.getResponse().getContentAsString(), is("{\"id\":null,\"nombre\":\"Soy\",\"apellido\":\"Mock\"}"));
    }

    // Using Response Matchers
    @Test
    public void m2() throws Exception {

        when(service.getPersona()).thenReturn(new Persona("Soy","Mock"));

        mockMvc.perform(get("/persona"))
               .andExpect(status().isOk())
               .andExpect(content().json("{nombre:Soy, apellido:Mock}"));

    }
}
//                +-----------------+       +------------+
//  Testeando ->  |                 |   <-  | @MockBean  |
//                |-----------------|       |------------|
//                | @RestController |       | @Service   |
//                +-----------------+       +------------+
