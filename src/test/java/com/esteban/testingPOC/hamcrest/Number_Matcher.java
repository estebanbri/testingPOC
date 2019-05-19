package com.esteban.testingPOC.hamcrest;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class Number_Matcher {

    //  Proximity matchers

    @Test
    public void givenADouble_whenCloseTo_thenCorrect() {
        double actual = 1.3;
        double operand = 1;
        double error = 0.5;

        assertThat(actual, closeTo(operand, error));
    }

    @Test
    public void givenABigDecimal_whenCloseTo_thenCorrect() {
        BigDecimal actual = new BigDecimal("1.0003");
        BigDecimal operand = new BigDecimal("1");
        BigDecimal error = new BigDecimal("0.0005");

        assertThat(actual, is(closeTo(operand, error)));
    }

    //  Order matchers
    @Test
    public void given5_whenComparesEqualTo5_thenCorrect() {
        Integer five = 5;

        assertThat(five, comparesEqualTo(five));
    }

    @Test
    public void given5_whenNotComparesEqualTo7_thenCorrect() {
        Integer seven = 7;
        Integer five = 5;

        assertThat(five, not(comparesEqualTo(seven)));
    }

    @Test
    public void given7_whenGreaterThan5_thenCorrect() {
        Integer seven = 7;
        Integer five = 5;

        assertThat(seven, is(greaterThan(five)));
    }

    @Test
    public void given7_whenGreaterThanOrEqualTo5_thenCorrect() {
        Integer seven = 7;
        Integer five = 5;

        assertThat(seven, is(greaterThanOrEqualTo(five)));
    }

    @Test
    public void given5_whenGreaterThanOrEqualTo5_thenCorrect() {
        Integer five = 5;

        assertThat(five, is(greaterThanOrEqualTo(five)));
    }

    @Test
    public void given3_whenLessThan5_thenCorrect() {
        Integer three = 3;
        Integer five = 5;

        assertThat(three, is(lessThan(five)));
    }

    @Test
    public void given3_whenLessThanOrEqualTo5_thenCorrect() {
        Integer three = 3;
        Integer five = 5;

        assertThat(three, is(lessThanOrEqualTo(five)));
    }

    @Test
    public void given5_whenLessThanOrEqualTo5_thenCorrect() {
        Integer five = 5;

        assertThat(five, is(lessThanOrEqualTo(five)));
    }

    // Order con LocalDate

    @Test
    public void givenToday_whenGreaterThanYesterday_thenCorrect() {
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);

        assertThat(today, is(greaterThan(yesterday)));
    }

    @Test
    public void givenToday_whenLessThanTomorrow_thenCorrect() {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);

        assertThat(today, is(lessThan(tomorrow)));
    }

}
