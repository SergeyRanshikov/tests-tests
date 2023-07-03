package com.example.tr212;

import com.example.tr212.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {
    private CalculatorService calculatorService = new CalculatorService();

    @BeforeEach
    public void setup() {
        calculatorService = new CalculatorService();
    }
    @Test
    public void testPlus() {
        int result = calculatorService.plus(8, 2);
        assertEquals(10, result);
    }

    @Test
    public void testMinus() {
        int result = calculatorService.minus(8, 2);
        assertEquals(6,result);
    }

    @Test
    public void testMultiply() {
        int result = calculatorService.multiply(8, 2);
        assertEquals(16,result);
    }

    @Test
    public void testDivide() {
        int result = calculatorService.divide(8, 2);
        assertEquals(4,result);
    }

    @Test
    public void testDivideByZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.divide(8, 0);
        });

    }

    @ParameterizedTest
    @CsvSource({"8, 2, 10", "10, 5, 15", "2, 3, 5"})
    public void testPlus(int a, int b, int expected) {
        int result = calculatorService.plus(a, b);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"8, 2, 6", "10, 5, 5", "2, 3, -1"})
    public void testMinus(int a, int b, int expected) {
        int result = calculatorService.minus(a, b);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"8, 2, 16", "10, 5, 50", "2, 3, 6"})
    public void testMultiply(int a, int b, int expected) {
        int result = calculatorService.multiply(a, b);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"8, 2, 4", "10, 5, 2", "2, 3, 0"})
    public void testDivide(int a, int b, int expected) {
        int result = calculatorService.divide(a, b);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"8, 0", "10, 0", "2, 0"})
    public void testDivideByZero(int a, int b) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.divide(a, b);
        });
    }
}
