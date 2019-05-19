package com.esteban.testingPOC.hamcrest;

import com.esteban.testingPOC.entity.Persona;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class Bean_Matcher {

    // hasProperty(String) : check if certain bean contains a specific property identified by the property’s name
    @Test
    public void givenACity_whenHasProperty_thenCorrect() {
        // GIVEN
        Persona p1 = new Persona();

        // WHEN (tiene una property llamada apellido)
        // THEN CORRECT
        assertThat(p1, hasProperty("apellido"));
    }

    // hasProperty(String, Matcher) : check if certain bean contains a specific property identified by the property’s name
    @Test
    public void givenACity_whenHasPropertyWithValueEqualTo_thenCorrect() {
        // GIVEN
        Persona p1 = new Persona("Esteban", "Briceño");

        // WHEN (tiene una property llamada apellido y el valor de la property del objeto es Briceño)
        // THEN CORRECT
        assertThat(p1, hasProperty("apellido", equalTo("Briceño")));
    }

    // samePropertyValuesAs(T) : when we have to do checks over a lot of properties of a bean, it may be simpler to create a new bean with the desired values. Then, we can check for equality between the tested bean and the new one
    @Test
    public void givenACity_whenSamePropertyValuesAs_thenCorrect() {
        Persona p1 = new Persona("Esteban", "Briceño");
        Persona p2 = new Persona("Esteban", "Briceño");

        assertThat(p1, samePropertyValuesAs(p2));
    }


}
