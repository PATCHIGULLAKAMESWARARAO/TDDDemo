package com.example.stringcalculator;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    public void testEmptyStringReturnsZero() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void testSingleNumberReturnsValue() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(5, calculator.add("5"));
    }

    @Test
    public void testTwoNumbersCommaSeparated() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(8, calculator.add("3,5"));
    }

    @Test
    public void testTwoNumbersNewlineSeparated() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(7, calculator.add("2\n5"));
    }

    @Test
    public void testMultipleNumbersSeparatedByCommaOrNewline() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(15, calculator.add("1,2\n3,4\n5"));
    }

    @Test
    public void testNegativeNumbersThrowException() {
        StringCalculator calculator = new StringCalculator();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-3,4");
        });
        assertEquals("Negative numbers are not allowed: -3", exception.getMessage());
    }
}
