package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Calculator Tests")
public class CalculatorTest {
    
    private Calculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    
    @Test
    @DisplayName("Test addition of two positive numbers")
    void testAddition() {

        int a = 5;
        int b = 3;
        

        int result = calculator.add(a, b);
        

        assertEquals(8, result, "5 + 3 should equal 8");
    }
    
    @Test
    @DisplayName("Test subtraction of two numbers")
    void testSubtraction() {

        int a = 10;
        int b = 4;
        

        int result = calculator.subtract(a, b);
        

        assertEquals(6, result, "10 - 4 should equal 6");
    }
    

}
