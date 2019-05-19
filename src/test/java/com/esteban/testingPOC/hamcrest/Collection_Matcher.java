package com.esteban.testingPOC.hamcrest;

import com.esteban.testingPOC.entity.Persona;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Collection_Matcher {

    // 1. hasItem(T)and hasItem(Matcher<? extends T>) : These match if the examined Iterable collection matches with given object or matcher inside hasItem() or hasItem(Matcher<? extends T>).
    @Test
    public void m1(){
        // GIVEN
        Persona p1 = new Persona("Andres", "Briceño");
        List<Persona> list = Arrays.asList(p1);

        // WHEN (la Collection contiene el objeto Persona dado)
        // THEN CORRECT
        assertThat(list, hasItem(new Persona("Andres", "Briceño")));
        // WHEN (la Collection contiene el objetos de tipo Persona)
        // THEN CORRECT
        assertThat(list, hasItem(isA(Persona.class)));
    }

    // 2. hasItems(T…) and hasItems(Matcher<? extends T>…): we can also assert against more than one items
    @Test
    public void m2(){
        // GIVEN
        Persona p1 = new Persona("Andres", "Briceño");
        Persona p2 = new Persona("Esteban", "Briceño");
        List<Persona> list = Arrays.asList(p1, p2);

        // WHEN (la Collection contiene los objetos Persona dados)
        // THEN CORRECT
        assertThat(list, hasItems(new Persona("Andres", "Briceño"),
                new Persona("Esteban", "Briceño")));
        assertThat(list, hasItem(isA(Persona.class)));
    }

    // 3. contains(T…) :  check all elements in a collection with Strict Order
    @Test
    public void m3(){
        // GIVEN
        Persona p1 = new Persona("Andres", "Briceño");
        Persona p2 = new Persona("Esteban", "Briceño");
        List<Persona> list = Arrays.asList(p1, p2);

        // WHEN (la Collection contiene los objetos en orden estricto)
        // THEN CORRECT
        assertThat(list, contains(new Persona("Andres", "Briceño"), new Persona("Esteban", "Briceño")));
    }

    // 4. contains(T…) :  check all elements in a collection with Strict Order
    @Test
    public void m4(){
        // GIVEN
        Persona p1 = new Persona("Andres", "Briceño");
        Persona p2 = new Persona("Esteban", "Briceño");
        List<Persona> list = Arrays.asList(p1, p2);

        // WHEN (la Collection contiene los objetos sin importar el orden)
        // THEN CORRECT
        assertThat(list, containsInAnyOrder(new Persona("Esteban", "Briceño"),new Persona("Andres", "Briceño")));
    }

    // 5. empty() :  check if the Collection is empty
    @Test
    public void m5(){
        // GIVEN
        List<Persona> list = new ArrayList();

        // WHEN (la Collection no contiene elementos)
        // THEN CORRECT
        assertThat(list, empty());
    }

    // 6. hasSize(int) check size of Collection
    @Test
    public void m6(){
        // GIVEN
        Persona p1 = new Persona("Andres", "Briceño");
        Persona p2 = new Persona("Esteban", "Briceño");
        List<Persona> list = Arrays.asList(p1, p2);

        // WHEN (la Collection contiene 2 elementos
        // THEN CORRECT
        assertThat(list, hasSize(2));
    }

    /**
     *   Map
     */

    @Test
    public void givenMapAndKey_whenKeyFoundInMap_thenCorrect() {
        Map<String, String> map = new HashMap<>();
        map.put("blogname", "baeldung");
        assertThat(map, hasKey("blogname"));
    }

    @Test
    public void givenMapAndValue_whenValueFoundInMap_thenCorrect() {
        Map<String, String> map = new HashMap<>();
        map.put("blogname", "baeldung");
        assertThat(map, hasValue("baeldung"));
    }

    @Test
    public void givenMapAndEntry_whenEntryFoundInMap_thenCorrect() {
        Map<String, String> map = new HashMap<>();
        map.put("blogname", "baeldung");
        assertThat(map, hasEntry("blogname", "baeldung"));
    }
}
