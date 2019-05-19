package com.esteban.testingPOC.mockito.MVC_Testing;

import com.esteban.testingPOC.entity.Persona;
import com.esteban.testingPOC.mvc.A_controller.PersonaController;
import com.esteban.testingPOC.mvc.B_service.PersonaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonaController.class)  // only loads web-layer (@RestController), no va loader @Service ni @Repository no son loaded por ende no te queda otra opcion que Mockear el @Service sino te explota)
public class PersonaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PersonaService personaServiceMock;

    PersonaController personaController;

    @Test
    public void m1() throws Exception {

        when(personaServiceMock.getPersona()).thenReturn(new Persona("Soy","Mock"));

        MvcResult mvcResult = mockMvc.perform(get("/persona"))
                                     .andReturn();

        assertThat(mvcResult.getResponse().getContentAsString(), is("{\"nombre\":\"Soy\",\"apellido\":\"Mock\"}"));
    }

    // Using Response Matchers
    @Test
    public void m2() throws Exception {

        when(personaServiceMock.getPersona()).thenReturn(new Persona("Soy","Mock"));

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
