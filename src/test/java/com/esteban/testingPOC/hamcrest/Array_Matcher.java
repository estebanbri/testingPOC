package com.esteban.testingPOC.hamcrest;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class Array_Matcher {

    @Test
    public void givenArray_whenChecksSize_thenCorrect() {
        String[] hamcrestMatchers = { "collections", "beans", "text", "number" };
        assertThat(hamcrestMatchers, arrayWithSize(4));
    }

    @Test
    public void givenArrayAndValue_whenValueFoundInArray_thenCorrect() {
        String[] hamcrestMatchers = { "collections", "beans", "text", "number" };
        assertThat(hamcrestMatchers, hasItemInArray("text"));
    }

    @Test
    public void givenValueAndArray_whenValueIsOneOfArrayElements_thenCorrect() {
        String[] hamcrestMatchers = { "collections", "beans", "text", "number" };
        assertThat("text", isOneOf(hamcrestMatchers));
    }

    @Test
    public void givenValueAndArray_whenValueFoundInArray_thenCorrect() {
        String[] array = new String[] { "collections", "beans", "text",
                "number" };
        assertThat("beans", isIn(array));
    }

    @Test
    public void givenArrayAndValues_whenValuesFoundInArray_thenCorrect() {
        String[] hamcrestMatchers = { "collections", "beans", "text", "number" };
        assertThat(hamcrestMatchers,
                arrayContainingInAnyOrder("beans", "collections", "number", "text"));
    }

    @Test
    public void givenArrayAndValues_whenValuesFoundInArrayInOrder_thenCorrect() {
        String[] hamcrestMatchers = { "collections", "beans", "text", "number" };
        assertThat(hamcrestMatchers,
                arrayContaining("collections", "beans", "text", "number"));
    }


}
