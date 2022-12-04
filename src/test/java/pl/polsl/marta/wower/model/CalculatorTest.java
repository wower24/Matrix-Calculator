/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pl.polsl.marta.wower.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Calculator
 * @author Marta Wower
 * @version 1.0.1
 */
public class CalculatorTest {
    
    /**
     *
     */
    public CalculatorTest() {
    }
    
    /**
     *
     */
    @BeforeAll
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterAll
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @BeforeEach
    public void setUp() {
    }
    
    /**
     *
     */
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of calculate method, of class Calculator in case of providing wrong choice.
     * @throws UnavailableChoiceException
     * @throws pl.polsl.marta.wower.model.WrongSizeException
     */
    @Test
    public void testCalculator_wrongInput() throws UnavailableChoiceException, WrongSizeException {
        System.out.println("calculator with wrong choice");
        
        Matrix matrixA = new Matrix(2, 2);
        Matrix matrixB = new Matrix(2, 2);
        
        matrixA.fillMatrix(1);
        matrixB.fillMatrix(1);
        
        UnavailableChoiceException thrown = Assertions.assertThrows(UnavailableChoiceException.class, () -> {
           Calculator instance = new Calculator(matrixA, matrixB, "abcd");
         });
        Assertions.assertEquals("Wrong input.", thrown.getMessage());
    }
    
    /**
     * Test of calculate method, of class Calculator in case of providing null choice.
     * @throws UnavailableChoiceException
     * @throws pl.polsl.marta.wower.model.WrongSizeException
     */
    @Test
    public void testCalculator_nullChoice() throws UnavailableChoiceException, WrongSizeException {
        System.out.println("calculator with null choice");
        
        Matrix matrixA = new Matrix(2, 2);
        Matrix matrixB = new Matrix(2, 2);
        
        matrixA.fillMatrix(1);
        matrixB.fillMatrix(1);
        
        NullPointerException thrown = Assertions.assertThrows(NullPointerException.class, () -> {
           Calculator instance = new Calculator(matrixA, matrixB, null);
         });
        Assertions.assertEquals("Cannot invoke \"String.length()\" because \"sChoice\" is null", thrown.getMessage());
    }

    /**
     * Test of printResult method, of class Calculator.
     */
    @Test
    public void testPrintResult() {
        System.out.println("printResult");
        Calculator instance = new Calculator();
        instance.printResult();
    }
    
}
