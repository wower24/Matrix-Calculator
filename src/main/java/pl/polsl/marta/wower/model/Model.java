/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.marta.wower.model;

import java.util.ArrayList;

/**
 * This class holds general logic of the program.
 * @author Marta Wower
 * @version 1.0.1
 */
public class Model 
{
    /**
     * ArrayList of matrices that program will work with.
     */
    public ArrayList<Matrix> matrices = new ArrayList<>();
    /**
     * ArrayList to which matrices filled with provided elements are saved.
     */
    public ArrayList<Matrix> filledMatrices;
    /**
     * Calculator to perform chosen calculation.
     */
    public Calculator calculator;
    
    /**
     * Creates a matrix of given height and width,
     * adds it to an ArrayList of matrices.
     * @param mHeight Number of rows
     * @param mWidth Number of columns
     * @return The method returns the created matrix
     * @throws pl.polsl.marta.wower.model.WrongSizeException
     */
   public Matrix createMatrix(int mHeight, int mWidth) throws WrongSizeException
   {
       Matrix m = new Matrix(mHeight, mWidth);
       matrices.add(m);
       return m;
   }
   
   /**
    * Fills all the matrices with elements from ArrayLists corresponding to them,
    * then adds the filled matrices to the filledMatrices field.
    * @param mAL ArrayList of matrices
    * @param iAL ArrayList of corresponding ArrayLists of Integers
    * @return The method returns an ArrayList of filled matrices
    */
   public ArrayList<Matrix> fillMatrices(ArrayList<Matrix> mAL, ArrayList<ArrayList<Integer>> iAL)
   {
       filledMatrices = new ArrayList<>();
       int i = 0;
       for(Matrix m: mAL)
       {
           m.fillMatrix(iAL.get(i));
           filledMatrices.add(m);
           i++;
       }
    
       return filledMatrices;
   }
   
   /**
    * Calls a calculator constructor with ready matrices and calculation choice.
    * @param s Calculation chosen by the user
     * @throws pl.polsl.marta.wower.model.WrongSizeException
     * @throws pl.polsl.marta.wower.model.UnavailableChoiceException
    */
   public void chooseCalculation(String s) throws WrongSizeException, UnavailableChoiceException
   {
        calculator = new Calculator(this.matrices.get(0), this.matrices.get(1), s);
   }
   
   /**
    * Prints matrices from an ArrayList of matrices to the screen.
    * @param mAL ArrayList of matrices (matrix A and matrix B)
    */
   public void printMatrices(ArrayList<Matrix> mAL)
   {
       for(Matrix m: mAL)
       {
           m.printMatrix();
           System.out.println();
       }
   }
}
