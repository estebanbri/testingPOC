package com.esteban.testingPOC.hamcrest;

import com.esteban.testingPOC.entity.Persona;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.typeCompatibleWith;

public class Object_Matcher {

    // 1- is(T)and is(Matcher<T>) : The is(T) takes an object as a parameter to check equality and is(Matcher<T>) takes another matcher allowing equality statement to be more expressive.
    @Test
    public void m1() {
        // GIVEN
        Persona p1 = new Persona("Esteban", "Briceño");
        Persona p2 = new Persona("Esteban", "Briceño");

        // WHEN (son iguales significativamente)
        // THEN CORRECT
        assertThat(p1, is(p2));
    }

    // 2. equalTo(T): The equalTo(T) takes an object as a parameter and checks its equality against another object. This is frequently used with is(Matcher<T>)
    @Test
    public void m2() {
        // GIVEN
        Persona p1 = new Persona("Esteban", "Briceño");
        Persona p2 = new Persona("Esteban", "Briceño");

        // WHEN (son iguales significativamente)
        // THEN CORRECT
        assertThat(p1, is(equalTo(p2)));
    }

    // 3. not(T)and not(Matcher<T>) : The not(T) and not(Matcher<T>) are used to check non-equality of given objects. First takes an object as an argument and second take another matcher
    @Test
    public void m3() {
        // GIVEN
        Persona p1 = new Persona("Andres", "Briceño");
        Persona p2 = new Persona("Esteban", "Briceño");

        // WHEN (no son iguales significativamente)
        // THEN CORRECT
        assertThat(p1, is(not(equalTo(p2))));
        assertThat(p1, is(not(instanceOf(Integer.class))));
    }

    // 4. nullValue()and nullValue(Class<T>) : The nullValue() check for null value against the examined object. The nullValue(Class<T>) checks for nullability of given class type object
    @Test
    public void m4() {
        // GIVEN
        Persona p1 = null;

        // WHEN (es null)
        // THEN CORRECT
        assertThat(p1, is(nullValue()));
        assertThat(p1, is(nullValue(Persona.class)));
    }

    // 5. notNullValue()and notNullValue(Class<T>) : These are a shortcut to frequently used is(not(nullValue)). These check for non-null-equality of an object or with the class type
    @Test
    public void m5() {
        // GIVEN
        Persona p1 = new Persona("Andres", "Briceño");

        // WHEN (no es null)
        // THEN CORRECT
        assertThat(p1, is(notNullValue()));
        assertThat(p1, is(notNullValue(Persona.class)));
    }

    // 6. instanceOf(Class<?>) : The instanceOf(Class<?>) matches if the examined object is an instance of the specified Class type. To verify, this method internally calls the isIntance(Object) of Class class
    @Test
    public void m6() {
        // GIVEN
        Persona p1 = new Persona("Andres", "Briceño");

        // WHEN (si la clase es del mismo tipo del objeto)
        // THEN CORRECT
        assertThat(p1, is(instanceOf(Persona.class)));
    }

    // 7. isA(Class<T> type) : The isA(Class<T> type) is a shortcut to the above instanceOf(Class<?>). It takes the exact same type of argument as an instanceOf(Class<?>):
    @Test
    public void m7() {
        // GIVEN
        Persona p1 = new Persona("Andres", "Briceño");

        // WHEN (si la clase es del mismo tipo del objeto)
        // THEN CORRECT
        assertThat(p1, isA(Persona.class));
    }

    // 8. sameInstance() : The sameInstance() matches if two reference variables point to the same object in a heap:
    @Test
    public void m8() {
        // GIVEN
        Persona p1 = new Persona("Andres", "Briceño");
        Persona p2 = p1;

        // WHEN (ambas referencias apuntan al mismo objeto en el heap)
        // THEN CORRECT
        assertThat(p1, is(sameInstance(p2)));
    }

    // 9. any(Class<T>) : The any(Class<T>)checks if the class is of the same type as actual object:
    @Test
    public void m9() {
        // GIVEN
        Persona p1 = new Persona("Andres", "Briceño");

        // WHEN (la clase es del mismo tipo que el objeto a testear)
        // THEN CORRECT
        assertThat(p1, is(any(Persona.class)));
    }

    // 10. allOf(Matcher<? extends T>…) and anyOf(Matcher<? extends T>…) : We can use allOf(Matcher<? extends T>…) to assert if actual object matches against all of the specified conditions
    @Test
    public void m10() {
        // GIVEN
        Persona p1 = new Persona("Andres", "Briceño");

        // WHEN (todas las condicion se cumplen)
        // THEN CORRECT
        assertThat(p1, allOf(isA(Persona.class), equalTo(new Persona("Andres", "Briceño"))));
    }

    // 11. anyOf(Matcher<? extends T>…) behaves like allOf(Matcher<? extends T>… ) but matches if the examined object matches any of the specified conditions
    @Test
    public void m11() {
        // GIVEN
        Persona p1 = new Persona("Andres", "Briceño");

        // WHEN (al menos una condicion se cumple)
        // THEN CORRECT
        assertThat(p1, anyOf(isA(Persona.class), equalTo(new Persona("XXX", "XXX"))));
    }

    // 12. hasToString(String s)  verifies that certain object has a toString method that returns a specific String
    @Test
    public void givenACity_whenHasToString_thenCorrect() {
        // GIVEN
        Persona p1 = new Persona("Esteban", "Briceño");

        // WHEN (tiene toString)
        // THEN CORRECT
        assertThat(p1, hasToString("Persona{nombre='Esteban', apellido='Briceño'}"));
    }


    // 13. both(Matcher<? extends T>) and either(Matcher<? extends T>) : the both(Matcher<? extends T>) matches when both of the specified conditions match the examined object
    @Test
    public void m13(){
        // GIVEN
        Persona p1 = new Persona("Andres", "Briceño");

        // WHEN (ambas codiciones se cumplen)
        // THEN CORRECT
        assertThat(p1, both(is(equalTo(new Persona("Andres", "Briceño"))))
                       .and(isA(Persona.class)));
    }

    // 14. either(Matcher<? extends T>)matches when either of the specified conditions matches the examined object:
    @Test
    public void m14(){
        // GIVEN
        Persona p1 = new Persona("Andres", "Briceño");

        // WHEN (alguna de las codiciones se cumplen)
        // THEN CORRECT
        assertThat(p1, either(is(equalTo(new Persona("XXX", "XXX"))))
                          .or(isA(Persona.class)));
    }

    @Test
    public void givenACity_whenTypeCompatibleWithObject_thenCorrect() {
        // GIVEN
        Persona p1 = new Persona("Andres", "Briceño");

        // WHEN (la clase del objeto es compatible con la clase Object, es hija de Object)
        // THEN CORRECT
        assertThat(p1.getClass(), is(typeCompatibleWith(Object.class)));
    }
}


