package com.example;

/**
 * A simple calculator class for demonstration purposes.
 */
public class Calculator {
    
    /**
     * Adds two numbers and returns the result.
     * 
     * @param a the first number
     * @param b the second number
     * @return the sum of a and b
     */
    public int add(int a, int b) {
        return a + b;
    }
    
    /**
     * Subtracts the second number from the first and returns the result.
     * 
     * @param a the first number
     * @param b the second number
     * @return the difference of a and b
     */
    public int subtract(int a, int b) {
        return a - b;
    }
    
    /**
     * Multiplies two numbers and returns the result.
     * 
     * @param a the first number
     * @param b the second number
     * @return the product of a and b
     */
    public int multiply(int a, int b) {
        return a * b;
    }
    
    /**
     * Divides the first number by the second and returns the result.
     * 
     * @param a the dividend
     * @param b the divisor
     * @return the quotient of a divided by b
     * @throws IllegalArgumentException if b is zero
     */
    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return (double) a / b;
    }
}
