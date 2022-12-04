/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.marta.wower.model;

/**
 * This class holds the calculation logic of the program.
 * @author Marta Wower
 * @version 1.0.2
 */
public class Calculator 
{
    /**
     * The first Matrix of an equation.
     * The order matters for multiplication.
     */
    Matrix a;
    /**
     * The second Matrix of an equation.
     * The order matters for multiplication.
     */
    Matrix b;
    /**
     * Matrix holding a result of equation.
     */
    public Matrix result;
    /**
     * The chosen calculation.
     */
    public enum Choice
    {
        ADD,
        SUBTRACT,
        MULTIPLY,
        OTHER
    }
    
    Choice choice;
    
    /**
     * Default Calculator constructor.
     * It creates an empty result matrix.
     */
    public Calculator()
    {
        result = new Matrix();
    }
    
    /**
     * Calculator constructor with 3 parameters.
     * @param a The first matrix of equation.
     * @param b The second matrix of equation.
     * @param sChoice Information about which calculation is going to be done.
     * @throws pl.polsl.marta.wower.model.WrongSizeException
     * @throws pl.polsl.marta.wower.model.UnavailableChoiceException
     */
    public Calculator (Matrix a, Matrix b, String sChoice) throws WrongSizeException, UnavailableChoiceException
    {
        boolean isLegit = true;
        
        if(sChoice.length() == 0)
            throw new UnavailableChoiceException("Wrong input.");
        else switch (sChoice) {
            case "addition":
                this.choice = Choice.ADD;
                break;
            case "subtraction":
                this.choice = Choice.SUBTRACT;
                break;
            case "multiplication":
                this.choice = Choice.MULTIPLY;
                break;
            default:
            {
                isLegit = false;
                throw new UnavailableChoiceException("Wrong input.");
            }
        }
        
        this.a = a;
        this.b = b;
        
        if(isLegit)
            calculate(this.choice);
    }
    
    /**
     * Calls a proper calculation method.
     * @param x Calculation chosen by a user.
     * @throws pl.polsl.marta.wower.model.UnavailableChoiceException
     * @throws pl.polsl.marta.wower.model.WrongSizeException
     */
    private void calculate(Choice x) throws UnavailableChoiceException, WrongSizeException
    {                
            switch (x) {
            case ADD -> this.addition();
            case SUBTRACT -> this.subtraction();
            case MULTIPLY -> this.multiplication();
            default -> {
                throw new UnavailableChoiceException("Wrong input.");
            }
        }
        //else
            //go back to choiceMessage part

    }
    //addition - only same sized matrices
    /**
     * Adds matrix A to matrix B.
     * @return The result is a new matrix.
     */
    private Matrix addition() throws WrongSizeException
    {
        if (this.a.getSize().equals(this.b.getSize()))
        {
            //operation possible, perform addition
            result = new Matrix(this.a.height, this.a.width);
            
            for(int i = 0; i < this.a.height; i++)
            {
                for(int j = 0; j < this.a.width; j++)
                {
                    int element = this.a.matrixArray.get(i).get(j) + this.b.matrixArray.get(i).get(j);
                    this.result.matrixArray.get(i).add(j, element);
                }
                    
            }
        }
        else
        {
            throw new WrongSizeException("Addition is not possible. Sizes of matrices are not the same.");
        }
        return result;
    }
    //subtraction - only same sized matrices
    /**
     * Subtracts matrix B from matrix A.
     * @return The result is a new matrix.
     */
    private Matrix subtraction() throws WrongSizeException
    {
        if (this.a.getSize().equals(this.b.getSize()))
        {
            //operation possible, perform subtraction
            result = new Matrix(this.a.height, this.a.width);
            
            for(int i = 0; i < this.a.height; i++)
            {
                for(int j = 0; j < this.a.width; j++)
                {
                    int element = this.a.matrixArray.get(i).get(j) - this.b.matrixArray.get(i).get(j);
                    this.result.matrixArray.get(i).add(j, element);
                }
                    
            }
        }
        else
        {
            throw new WrongSizeException("Subtraction not possible. Sizes of matrices are not the same.");
        }
        return result;
    }
    //multiplication - only mxn nxp matrices
    /**
     * Calculates method A times method B. 
     * @return The result is a new matrix.
     */
    private Matrix multiplication() throws WrongSizeException
    {
        if(this.a.width == this.b.height)
        {
            //operation possible, perform multiplication
            //result of multiplication is a matrix mxp
            result = new Matrix(this.a.height, this.b.width);
            result.fillMatrix(0);
            
            for(int i = 0; i < this.result.height; i++)
            {
                for(int j = 0; j < this.result.width; j++)
                {
                    for(int k = 0; k < this.b.height; k++)
                    {
                        int element = this.result.matrixArray.get(i).get(j)
                                + (this.a.matrixArray.get(i).get(k) * this.b.matrixArray.get(k).get(j));
                        this.result.matrixArray.get(i).set(j, element);
                    }
                }
            }
        }
        else
        {
            throw new WrongSizeException("Multiplication not possible. Sizes of matrices are not correct.");
        }      
        return result;
    }
    
    /**
     * Prints the result matrix.
     */
    public void printResult()
    {
        result.printMatrix();
    }
}
