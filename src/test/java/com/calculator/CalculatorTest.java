package com.calculator;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CalculatorTest {
    
    @Test
    public void testAddition() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        Calculator.main(new String[]{"5", "3", "+"});
        assertTrue(outContent.toString().contains("5.00 + 3.00 = 8.00"));
    }

    @Test
    public void testSubtraction() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        Calculator.main(new String[]{"5", "3", "-"});
        assertTrue(outContent.toString().contains("5.00 - 3.00 = 2.00"));
    }

    @Test
    public void testMultiplication() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        Calculator.main(new String[]{"5", "3", "*"});
        assertTrue(outContent.toString().contains("5.00 * 3.00 = 15.00"));
    }

    @Test
    public void testDivision() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        Calculator.main(new String[]{"6", "2", "/"});
        assertTrue(outContent.toString().contains("6.00 / 2.00 = 3.00"));
    }

    @Test
    public void testDivisionByZero() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        Calculator.main(new String[]{"5", "0", "/"});
        assertTrue(outContent.toString().contains("Error: Cannot divide by zero!"));
    }

    @Test
    public void testInvalidOperator() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        Calculator.main(new String[]{"5", "3", "%"});
        assertTrue(outContent.toString().contains("Invalid operator!"));
    }

    @Test
    public void testInvalidNumberOfArguments() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        Calculator.main(new String[]{"5"});
        assertTrue(outContent.toString().contains("Error: Please provide exactly 3 arguments"));
    }
}
