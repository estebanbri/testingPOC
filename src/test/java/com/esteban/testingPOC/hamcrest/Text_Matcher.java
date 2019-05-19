package com.esteban.testingPOC.hamcrest;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;
import static org.hamcrest.text.IsEmptyString.isEmptyString;


import org.junit.Test;


import static org.hamcrest.MatcherAssert.assertThat;

public class Text_Matcher {

    // 1. containsString(String) : We can use containsString(String) to assert if the actual string contains test string
    @Test
    public void m1() {
        // GIVEN
        String s = "abc";

        // WHEN (el texto contiene "bc")
        // THEN CORRECT
        assertThat(s, containsString("bc"));
    }

    // 2. startsWith(String) to assert if the actual string starts with test string
    @Test
    public void m2() {
        // GIVEN
        String s = "abc";

        // WHEN (el texto comienza con "ab")
        // THEN CORRECT
        assertThat(s, startsWith("ab"));
    }

    // 3. endsWith(String) to assert if the actual string ends with test string
    @Test
    public void m3() {
        // GIVEN
        String s = "abc";

        // WHEN (el texto termina con "bc")
        // THEN CORRECT
        assertThat(s, startsWith("bc"));
    }

    // 4. isEmptyString() : to assert if the actual string is empty
    @Test
    public void whenStringIsEmpty_thenCorrect() {
        // GIVEN
        String s = "";

        // WHEN (el texto es vacio)
        // THEN CORRECT
        assertThat(s, isEmptyString());
    }

    // 5. isEmptyString() : to assert if the actual string is empty o null
    @Test
    public void whenStringIsEmptyOrNull_thenCorrect() {
        // GIVEN
        String second = null;

        // WHEN (el texto es null o vacio)
        // THEN CORRECT
        assertThat(second, isEmptyOrNullString());
    }

    @Test
    public final void whenTwoStringsAreEqualWithWhiteSpace_thenCorrect() {
        String first = "hello";
        String second = "   Hello   ";

        assertThat(first, equalToIgnoringWhiteSpace(second));
    }

    @Test
    public void givenBenjamin_whenGreaterThanAmanda_thenCorrect() {
        String amanda = "Amanda";
        String benjamin = "Benjamin";

        assertThat(benjamin, is(greaterThan(amanda)));
    }

    @Test
    public void givenAmanda_whenLessThanBenajmin_thenCorrect() {
        String amanda = "Amanda";
        String benjamin = "Benjamin";

        assertThat(amanda, is(lessThan(benjamin)));
    }



}
