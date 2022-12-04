/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.marta.wower.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Setting up the first window content.
 * Collects sizes of matrices from the user.
 * @author Marta
 * @version 1.0.0
 */
public class CollectSizes extends JPanel implements ActionListener {

    protected JTextField rowsATF, columnsATF, rowsBTF, columnsBTF;
    protected JLabel rowsALabel, columnsALabel, rowsBLabel, columnsBLabel;
    protected JButton doneButton;
    protected int rowsA, columnsA, rowsB, columnsB;
    
    /**
     * Sets up all the elements of the view.
     */
    public CollectSizes()
    {
        setLayout(null);
        
        int firstX = 50;
        int secondX = 350;
        int firstY = 50;
        int secondY = 53;
        
        //Labels set up
        rowsALabel = new JLabel("Number of rows (Matrix A): ");
        rowsALabel.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        rowsALabel.setForeground(Color.WHITE);
        Dimension sizeRA = rowsALabel.getPreferredSize();
        rowsALabel.setBounds(firstX, firstY, sizeRA.width, sizeRA.height);
        
        columnsALabel = new JLabel("Number of columns (Matrix A): ");
        columnsALabel.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        columnsALabel.setForeground(Color.WHITE);
        Dimension sizeCA = columnsALabel.getPreferredSize();
        columnsALabel.setBounds(firstX, firstY + 50, sizeCA.width, sizeCA.height);
        
        rowsBLabel = new JLabel("Number of rows (Matrix B): ");
        rowsBLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        rowsBLabel.setForeground(Color.WHITE);
        Dimension sizeRB = rowsBLabel.getPreferredSize();
        rowsBLabel.setBounds(firstX, firstY + 100, sizeRB.width, sizeRB.height);
        
        columnsBLabel = new JLabel("Number of columns (Matrix B): ");
        columnsBLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        columnsBLabel.setForeground(Color.WHITE);
        Dimension sizeCB = columnsBLabel.getPreferredSize();
        columnsBLabel.setBounds(firstX, firstY + 150, sizeCB.width, sizeCB.height);
        
        //Text Fields to provide sizes of matrices
        int widthTF = 35;
        
        rowsATF = new JTextField("0");
        rowsATF.setSize(widthTF, widthTF);
        Dimension sizeTF = rowsATF.getPreferredSize();
        rowsATF.setBounds(secondX, secondY, sizeTF.height,sizeTF.height);
        
        columnsATF = new JTextField("0");
        columnsATF.setSize(widthTF, widthTF);
        columnsATF.setBounds(secondX, secondY + 50, sizeTF.height,sizeTF.height);
        
        rowsBTF = new JTextField("0");
        rowsBTF.setSize(widthTF, widthTF);
        rowsBTF.setBounds(secondX, secondY + 100, sizeTF.height,sizeTF.height);
        
        columnsBTF = new JTextField("0");
        columnsBTF.setSize(widthTF, widthTF);
        columnsBTF.setBounds(secondX, secondY + 150, sizeTF.height,sizeTF.height);
        
        //Button to accept the input
        doneButton = new JButton("DONE");
        doneButton.setFont(new java.awt.Font("Arial", Font.ITALIC, 10));
        doneButton.setForeground(Color.BLUE);
        Dimension sizeDB = doneButton.getPreferredSize();
        doneButton.setBounds((450 - sizeDB.width)/2, firstY + 200, sizeDB.width, sizeDB.height);
        
        doneButton.addActionListener(this); 
        doneButton.setActionCommand("DONE");
        
        add(rowsALabel);
        add(rowsATF);
        add(columnsALabel);
        add(columnsATF);
        add(rowsBLabel);
        add(rowsBTF);
        add(columnsBLabel);
        add(columnsBTF);
        add(doneButton);
    }

    /**
     * On action (button Done was pressed), pass data to another method and show the next window.
     * @param e Action event (key was pressed) 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if("DONE".equals(e.getActionCommand()))
        {
            try
            {
            rowsA = Integer.parseInt(rowsATF.getText());
            columnsA = Integer.parseInt(columnsATF.getText());
            rowsB = Integer.parseInt(rowsBTF.getText());
            columnsB = Integer.parseInt(columnsBTF.getText());
          
            //pass those values to createAndShowGUI
            if(rowsA >= 1 && rowsA <= 5 && columnsA >= 1 && columnsA <= 5 && rowsB >= 1 && rowsB <= 5 && columnsB >= 1 && columnsB <= 5)
                DesignGUI.createAndShowGUI(rowsA, columnsA, rowsB, columnsB);
            else 
                throw new NumberFormatException();
            }
            catch(NumberFormatException exc)
            {
                DesignGUI.displayExceptionMessage("Sizes of matrices must be numbers from 1 to 5!");
            }
        }
    }
    
}
