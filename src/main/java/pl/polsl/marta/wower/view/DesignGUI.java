/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pl.polsl.marta.wower.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import pl.polsl.marta.wower.model.Calculator;
import pl.polsl.marta.wower.model.Matrix;
import pl.polsl.marta.wower.model.Model;
import pl.polsl.marta.wower.model.UnavailableChoiceException;
import pl.polsl.marta.wower.model.WrongSizeException;

/**
 * Graphical User Interface
 * @author Marta Wower
 * @version 1.0.2
 */
public class DesignGUI extends JPanel implements ActionListener
{
    protected JLabel matrixALabel, matrixBLabel, symbolLabel, resultLabel;
    protected JButton addButton, subtractButton, multiplyButton;
    protected JTable matrixATable, matrixBTable, resultTable;
    protected JTabbedPane tabs = new JTabbedPane();
    protected JPanel panel = new JPanel();
    
    /**
     * Sets up elements of the main view.
     * Initializes tables according to passed parameters.
     * @param rowsA Number of rows of matrix A
     * @param columnsA Number of columns of matrix A
     * @param rowsB Number of rows of matrix B
     * @param columnsB Number of columns of matrix B
     */
    public DesignGUI(int rowsA, int columnsA, int rowsB, int columnsB)
    {
        setLayout(null);
        //panel.setLayout(null);
        //labels
        //------------------------------------------------
        matrixALabel = new JLabel("Matrix A");
        matrixALabel.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        matrixALabel.setForeground(Color.WHITE);
        Dimension sizeA = matrixALabel.getPreferredSize();
        matrixALabel.setBounds(80, 50, sizeA.width, sizeA.height);
       
        matrixBLabel = new JLabel("Matrix B");
        matrixBLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        matrixBLabel.setForeground(Color.WHITE);
        Dimension sizeB = matrixBLabel.getPreferredSize();
        matrixBLabel.setBounds(305, 50, sizeB.width, sizeB.height);
        
        symbolLabel = new JLabel("?");
        symbolLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        symbolLabel.setForeground(Color.WHITE);
        Dimension sizeS = symbolLabel.getPreferredSize();
        symbolLabel.setBounds(matrixBLabel.getBounds().x - ((matrixALabel.getBounds().x + sizeA.width) / 2), matrixALabel.getBounds().y + 50, sizeS.width, sizeS.height);
        //y ok, x between mA and mB
        
        resultLabel = new JLabel("Result");
        resultLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        resultLabel.setForeground(Color.WHITE);
        Dimension sizeR = resultLabel.getPreferredSize();
        resultLabel.setBounds(matrixBLabel.getBounds().x - ((matrixALabel.getBounds().x + sizeA.width) / 2) - (sizeR.width / 2), 200, sizeR.width, sizeR.height);
        //------------------------------------------------
        
        //buttons (set up)
        //------------------------------------------------        
        subtractButton = new JButton("SUBTRACT");
        subtractButton.setFont(new java.awt.Font("Arial", Font.ITALIC, 10));
        subtractButton.setForeground(Color.BLUE);
        subtractButton.setBackground(Color.WHITE);
        Dimension sizeBs = subtractButton.getPreferredSize();
        subtractButton.setBounds(475, 170, sizeBs.width, sizeBs.height);
        subtractButton.setToolTipText("Choose this to subtract matrices.");
        
        multiplyButton = new JButton("MULTIPLY");
        multiplyButton.setFont(new java.awt.Font("Arial", Font.ITALIC, 10));
        multiplyButton.setForeground(Color.BLUE);
        multiplyButton.setBackground(Color.WHITE);
        Dimension sizeBm = subtractButton.getPreferredSize();
        multiplyButton.setBounds(475, 220, sizeBm.width, sizeBm.height);
        multiplyButton.setToolTipText("Choose this to multiply matrices.");
        
        addButton = new JButton("ADD");
        addButton.setFont(new java.awt.Font("Arial", Font.ITALIC, 10));
        addButton.setForeground(Color.BLUE);
        addButton.setBackground(Color.WHITE);
        Dimension sizeBa = subtractButton.getPreferredSize();
        addButton.setBounds(475, 120, sizeBa.width, sizeBa.height);
        addButton.setToolTipText("Choose this to add matrices.");
        //------------------------------------------------
        
        //buttons (actionListener)
        //------------------------------------------------
        addButton.setActionCommand("add");
        addButton.addActionListener(this);
        
        subtractButton.setActionCommand("subtract");
        subtractButton.addActionListener(this);
        
        multiplyButton.setActionCommand("multiply");
        multiplyButton.addActionListener(this);
        //------------------------------------------------
        
        //tables (initialize)
        //------------------------------------------------
        matrixATable = new JTable(rowsA, columnsA);
        matrixBTable = new JTable(rowsB,columnsB);
        //------------------------------------------------
        
        //tables (change column width)
        //------------------------------------------------
        matrixATable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        matrixBTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        for(int i = 0; i < columnsA; i++)
        {
            matrixATable.getColumnModel().getColumn(i).setPreferredWidth(30);
        }
        
        for(int i = 0; i < columnsB; i++)
        {
            matrixBTable.getColumnModel().getColumn(i).setPreferredWidth(30);
        }
        //------------------------------------------------
        
        //tables (set up)
        //------------------------------------------------
        Dimension sizeTa = matrixATable.getPreferredSize();
        matrixATable.setBounds(matrixALabel.getBounds().x + (sizeA.width / 2) - (sizeTa.width / 2), matrixALabel.getBounds().y + 40, sizeTa.width, sizeTa.height);
        
        Dimension sizeTb = matrixBTable.getPreferredSize();
        matrixBTable.setBounds(matrixBLabel.getBounds().x + (sizeB.width / 2) - (sizeTb.width / 2), matrixBLabel.getBounds().y + 40, sizeTb.width, sizeTb.height);
        //------------------------------------------------
        
        //adding everything
        //------------------------------------------------
        add(matrixALabel);
        add(matrixBLabel);
        add(symbolLabel);
        add(resultLabel);
        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(matrixATable);
        add(matrixBTable);
        //------------------------------------------------
        //tabs.addTab("Calculator", panel);
        //createHistoryTab();
        //add(tabs);
    }
    
    /**
     * On action (some button was pressed) calls corresponding calculate method.
     * If an exception was caught the program goes back to the first window - getting sizes.
     * @param e Action event (key was pressed)
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        String choice = null;
        Calculator c;
        
        try {
        switch(command)
        {
            case "add":
            {
                symbolLabel.setText("+");
                choice = "addition";
                break;
            }
            case "subtract":
            {
                symbolLabel.setText("-");
                choice = "subtraction";
                break;
            }
            case "multiply":
            {
                symbolLabel.setText("x");
                choice = "multiplication";
                break;
            }
        }
        
        c = new Calculator(saveData(matrixATable), saveData(matrixBTable), choice);
        displayResult(c);
        
        }
        catch (NumberFormatException ex)
        {
            displayExceptionMessage("Elements of matrices must be numbers!");
        }
        catch (WrongSizeException | UnavailableChoiceException ex)
        {
            displayExceptionMessage(ex);
            getSizes();
        }
    }
    
    /**
     * Saves data from a table to an ArrayList of integers,
     * then creates a matrix and fills the matrix with saved data. 
     * @param table JTable the data is read from.
     * @return Returns a matrix same as table.
     * @throws WrongSizeException 
     */
    private Matrix saveData (JTable table) throws WrongSizeException
    {
        
        Matrix m;
        ArrayList<Integer> elements = new ArrayList<>();
        
        for(int i = 0; i < table.getRowCount(); i++)
        {
            for(int j = 0; j < table.getColumnCount(); j++)
            {
                if(table.getValueAt(i, j) == null)
                {
                    table.setValueAt(0, i, j);
                    elements.add(0);
                }
                else
                    elements.add(Integer.parseInt(table.getValueAt(i, j).toString()));
            }
        }
        
        m = new Matrix(table.getRowCount(), table.getColumnCount());
        m.fillMatrix(elements);
        
        return m;
    }
    
    /**
     * Creates another JTable to show the result.
     * @param c Calculator that performed the equation.
     */
    private void displayResult(Calculator c)
    {
        resultTable = new JTable(c.result.height, c.result.width);
        resultTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        for(int i = 0; i < resultTable.getColumnCount(); i++)
        {
            resultTable.getColumnModel().getColumn(i).setPreferredWidth(30);
        }
        
        Dimension sizeR = resultLabel.getPreferredSize();
        Dimension sizeTr = resultTable.getPreferredSize();
        resultTable.setBounds(resultLabel.getBounds().x + (sizeR.width / 2) - (sizeTr.width / 2), resultLabel.getBounds().y + 40, sizeTr.width, sizeTr.height);
        
        int k = 0;
        
        for(int i = 0; i < resultTable.getRowCount(); i++)
        {
            for(int j = 0; j < resultTable.getColumnCount(); j++)
            {
                resultTable.setValueAt(c.result.matrixArray.get(i).get(j), i, j);
                k++;
            }
        }
       
        resultTable.setEnabled(false);
        add(resultTable);
    }
    
    /**
     * Displays Exception Message for custom exceptions.
     * @param exc An exception with an instruction message. 
     */
    public static void displayExceptionMessage(Exception exc)
    {
        JFrame f = new JFrame();
        JOptionPane.showMessageDialog(f, exc.getMessage());
    }
    
    /**
     * Displays Exception Message for regular exceptions.
     * @param message A message with instructions.
     */
    public static void displayExceptionMessage(String message)
    {
        JFrame f = new JFrame();
        JOptionPane.showMessageDialog(f, message);
    }
            
    /**
     * Initializes the first window of the program.
     */
    private static void getSizes()
    {
        JFrame pop = new JFrame("The first step.");
        
        pop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        CollectSizes content = new CollectSizes();
        pop.setContentPane(content);
        
        pop.setSize(450, 350);
        pop.getContentPane().setBackground(Color.PINK);
        
        pop.setLocationRelativeTo(null);
        
        pop.setVisible(true);
    }
    
    /**
     * Initializes the main window of the program with already prepared elements.
     * @param rA Number of rows in matrix A
     * @param cA Number of columns in matrix A
     * @param rB Number of rows in matrix B
     * @param cB Number of columns in matrix B
     */
    static void createAndShowGUI(int rA, int cA, int rB, int cB)
    {
        //nice look
        JFrame.setDefaultLookAndFeelDecorated(true);

	//create window
        JFrame frame = new JFrame("Matrix Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
	//create panel
        DesignGUI content = new DesignGUI(rA, cA, rB, cB);
        
        //visible panel
        //content.setOpaque(true); 
        frame.setContentPane(content);
        
        //set background to pink and center the window
        frame.setSize(600, 400);
        frame.getContentPane().setBackground(Color.PINK);
        frame.setLocationRelativeTo(null);
        
        //display window
        //frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Main method.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                getSizes();
            }
        });
        }
}

