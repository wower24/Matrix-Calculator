/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.marta.wower.model;

/**
 * Exception thrown when the choice input is incorrect.
 * For example user made a typo or provided something different than 
 * "addition", "subtraction" or "multiplication".
 * @author Marta Wower
 * @version 1.0.1
 */
public class UnavailableChoiceException extends Exception
{
    UnavailableChoiceException(String message)
    {
        super(message);
    }
}
