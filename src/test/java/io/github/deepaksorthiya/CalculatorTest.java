package io.github.deepaksorthiya;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calc = new Calculator();

    @Test
    void testAdd() {
        assertEquals(8, calc.add(5, 3));
    }

    @Test
    void testSubtract() {
        assertEquals(2, calc.subtract(5, 3));
    }
}