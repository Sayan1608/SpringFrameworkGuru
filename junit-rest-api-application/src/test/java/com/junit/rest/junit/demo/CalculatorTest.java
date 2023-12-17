package com.junit.rest.junit.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setCalculator(){
        calculator = new Calculator();
    }
    @Test
    void add() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(6, calculator.add(3, 3));
    }

    @Test
    void divide() {
        assertEquals(2,calculator.divide(10,5));
    }
}