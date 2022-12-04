/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pl.polsl.marta.wower.model;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Matrix
 * @author Marta Wower
 * @version 1.0.1
 */
public class MatrixTest {
    
    /**
     *
     */
    public MatrixTest() {
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
     * Test of getSize method, of class Matrix, in case of an empty Matrix.
     */
    @Test
    public void testGetSize_empty() {
        System.out.println("getSizeEmpty");
        Matrix instance = new Matrix();
        String expResult = "0";
        String result = instance.getSize();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getSize method, of class Matrix.
     * @throws pl.polsl.marta.wower.model.WrongSizeException
     */
    @Test
    public void testGetSize() throws WrongSizeException {
        System.out.println("getSize");
        Matrix instance = new Matrix(3, 4);
        String expResult = "3x4";
        String result = instance.getSize();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of fillMatrix method, of class Matrix.
     * @throws pl.polsl.marta.wower.model.WrongSizeException
     */
    @Test
    public void testFillMatrix_ArrayList() throws WrongSizeException {
        System.out.println("fillMatrix");
        ArrayList<Integer> x = new ArrayList<>();
        for(int i = 0; i < 12; i++)
            x.add(i);
        Matrix instance = new Matrix(3, 4);
        instance.fillMatrix(x);
        ArrayList<Integer> expResult = new ArrayList<>();
        for(int i = 0; i < instance.height*instance.width; i++)
            expResult.add(x.get(i));
        
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < instance.height; i++)
        {
            for(int j = 0; j < instance.width; j++)
            {
                result.add(instance.matrixArray.get(i).get(j));
            }
        }
        assertEquals(x.size(), result.size());
        assertEquals(expResult, result);
    }

    /**
     * Test of fillMatrix method, of class Matrix.
     * Filling all with a single number.
     * @throws pl.polsl.marta.wower.model.WrongSizeException
     */
    @Test
    public void testFillMatrix_int() throws WrongSizeException {
        System.out.println("fillMatrix");
        int element = 0;
        Matrix instance = new Matrix(3,4);
        instance.fillMatrix(element);
        ArrayList<Integer> expResult = new ArrayList<>();
        for(int i = 0; i < instance.height*instance.width; i++)
            expResult.add(element);
        
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < instance.height; i++)
        {
            for(int j = 0; j < instance.width; j++)
            {
                result.add(instance.matrixArray.get(i).get(j));
            }
        }
        
        assertEquals(expResult, result);
    }
    
    //-----------------------------------
    //
    //TODO Parametrized testFillMatrix_int!!!
    //(height, width, element)
    //
    //-----------------------------------

    /**
     * Test of printMatrix method, of class Matrix.
     */
    @Test
    public void testPrintMatrix() {
        System.out.println("printMatrix");
        Matrix instance = new Matrix();
        instance.printMatrix();
    }
    
}
