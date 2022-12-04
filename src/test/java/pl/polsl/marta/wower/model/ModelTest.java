/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pl.polsl.marta.wower.model;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Model
 * @author Marta Wower
 * @version 1.0.2
 */
public class ModelTest {
    
    /**
     *
     */
    public ModelTest() {
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
     * Test of createMatrix method, of class Model, in case of providing wrong size.
     * WrongSizeException should be thrown.
     * @throws pl.polsl.marta.wower.model.WrongSizeException
     */
    @Test
    public void testCreateMatrix_wrongSize() throws WrongSizeException {
        System.out.println("createMatrix_wrongSize");
        int mHeight = 0;
        int mWidth = 0;
        Model instance = new Model();
         WrongSizeException thrown = Assertions.assertThrows(WrongSizeException.class, () -> {
           instance.createMatrix(mHeight, mWidth);
         });
        Assertions.assertEquals("Height and Width of matrix must be integers between 1 and 5", thrown.getMessage());
    }
    
    /**
     * Test of createMatrix method, of class Model, matrix size 5x5.
     * No exception should be thrown.
     * @throws pl.polsl.marta.wower.model.WrongSizeException
     */
    @Test
    public void testCreateMatrix_five() throws WrongSizeException {
        System.out.println("createMatrix_five");
        int mHeight = 5;
        int mWidth = 5;
        Model instance = new Model();
        instance.createMatrix(mHeight, mWidth);
        String expResult = "5x5";
        String result = instance.matrices.get(0).getSize();
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of createMatrix method, of class Model, matrix size 1x1.
     * No exception should be thrown.
     * @throws pl.polsl.marta.wower.model.WrongSizeException
     */
    @Test
    public void testCreateMatrix_one() throws WrongSizeException {
        System.out.println("createMatrix_one");
        int mHeight = 1;
        int mWidth = 1;
        Model instance = new Model();
        instance.createMatrix(mHeight, mWidth);
        String expResult = "1x1";
        String result = instance.matrices.get(0).getSize();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of fillMatrices method, of class Model.
     * @throws pl.polsl.marta.wower.model.WrongSizeException
     */
    @Test
    public void testFillMatrices() throws WrongSizeException {
        System.out.println("fillMatrices");
        ArrayList<Matrix> mAL = new ArrayList<>();
        Matrix matrixA = new Matrix(2, 3);
        mAL.add(matrixA);
        
        ArrayList<Integer> elementsA = new ArrayList<>();
        for(int i = 0; i < matrixA.height*matrixA.width; i++)
            elementsA.add(1);
        
        Matrix matrixB = new Matrix(3, 2);
        mAL.add(matrixB);
        
        ArrayList<Integer> elementsB = new ArrayList<>();
        for(int i = 0; i < matrixB.height*matrixB.width; i++)
            elementsB.add(i);
        
        ArrayList<ArrayList<Integer>> iAL = new ArrayList<>();
        iAL.add(elementsA);
        iAL.add(elementsB);
        
        matrixA.fillMatrix(elementsA);
        matrixB.fillMatrix(elementsA);
        
        Model instance = new Model();
        instance.fillMatrices(mAL, iAL);
        
        ArrayList<Matrix> expResult = new ArrayList<>();
        expResult.add(matrixA);
        expResult.add(matrixB);
        
        ArrayList<Matrix> result = instance.filledMatrices;
        assertEquals(expResult, result);
    }

    /**
     * Test of chooseCalculation method, of class Model, wrong input provided.
     * @throws pl.polsl.marta.wower.model.UnavailableChoiceException
     * @throws pl.polsl.marta.wower.model.WrongSizeException
     */
    @Test
    public void testChooseCalculation_wrongInput() throws UnavailableChoiceException, WrongSizeException {
        System.out.println("chooseCalculation_wrongInput");
        String s = "";
        Model instance = new Model();
        
        instance.matrices.add(new Matrix(2, 3));
        instance.matrices.add(new Matrix(2, 3));
        
        UnavailableChoiceException thrown = Assertions.assertThrows(UnavailableChoiceException.class, () -> {
           instance.chooseCalculation(s);
         });
        Assertions.assertEquals("Wrong input.", thrown.getMessage());
    }
    
    /**
     * Test of chooseCalculation method, of class Model, right input on addition
     * @throws pl.polsl.marta.wower.model.UnavailableChoiceException
     * @throws pl.polsl.marta.wower.model.WrongSizeException
     */
    @Test
    public void testChooseCalculation_rightInput_add() throws UnavailableChoiceException, WrongSizeException {
        System.out.println("chooseCalculation_add");
        String s = "addition";
        Model instance = new Model();
        
        Matrix matrixA = new Matrix(2, 3);
        Matrix matrixB = new Matrix(2, 3);
        matrixA.fillMatrix(1);
        matrixB.fillMatrix(2);
        instance.matrices.add(matrixA);
        instance.matrices.add(matrixB);
        
        instance.calculator = new Calculator(matrixA, matrixB, s);
        
        Matrix expResult = new Matrix(2, 3);
        expResult.fillMatrix(3);
        
        Matrix result = instance.calculator.result;
        
        assertEquals(expResult.matrixArray, result.matrixArray);
    }
    
    /**
     * Test of chooseCalculation method, of class Model, right input on subtraction
     * @throws pl.polsl.marta.wower.model.UnavailableChoiceException
     * @throws pl.polsl.marta.wower.model.WrongSizeException
     */
    @Test
    public void testChooseCalculation_rightInput_subtract() throws UnavailableChoiceException, WrongSizeException {
        System.out.println("chooseCalculation_subtract");
        String s = "subtraction";
        Model instance = new Model();
        
        Matrix matrixA = new Matrix(2, 3);
        Matrix matrixB = new Matrix(2, 3);
        matrixA.fillMatrix(1);
        matrixB.fillMatrix(2);
        instance.matrices.add(matrixA);
        instance.matrices.add(matrixB);
        
        instance.calculator = new Calculator(matrixA, matrixB, s);
        
        Matrix expResult = new Matrix(2, 3);
        expResult.fillMatrix(-1);
        
        Matrix result = instance.calculator.result;
        
        assertEquals(expResult.matrixArray, result.matrixArray);
    }

    /**
     * Test of printMatrices method, of class Model in case null is passed.
     * NullPointerException should be thrown.
     * @throws NullPointerException
     */
    @Test
    public void testPrintMatrices_null() throws NullPointerException{
        System.out.println("printMatrices_null");
        ArrayList<Matrix> mAL = null;
        Model instance = new Model();
              
        NullPointerException thrown = Assertions.assertThrows(NullPointerException.class, () -> {
           instance.printMatrices(mAL);
         });
        Assertions.assertEquals("Cannot invoke \"java.util.ArrayList.iterator()\" because \"mAL\" is null", thrown.getMessage());
    }
    
    /**
     * Test of printMatrices method, of class Model in case right parameter is passed.
     * @throws pl.polsl.marta.wower.model.WrongSizeException
     */
    @Test
    public void testPrintMatrices_right() throws WrongSizeException{
        System.out.println("printMatrices_right");
        ArrayList<Matrix> mAL = new ArrayList<>();
        Model instance = new Model();
        
        Matrix matrixA = new Matrix(2, 2);
        matrixA.fillMatrix(1);
        mAL.add(matrixA);
        
        Matrix matrixB = new Matrix(4, 3);
        matrixB.fillMatrix(2);
        mAL.add(matrixB);
        
        Matrix matrixC = new Matrix(5, 5);
        matrixC.fillMatrix(5);
        mAL.add(matrixC);
        
        instance.printMatrices(mAL);
    }
    
}
