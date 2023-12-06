import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Calculator {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton, equalButton, decButton, deleteButton, clearButton;
    JPanel panel = new JPanel();

    Font myFont = new Font(null, Font.BOLD, 35);

    Calculator() {
        frame = new JFrame("Demo NT3RN Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(340, 520);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(20, 30, 290, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equalButton = new JButton("=");
        deleteButton = new JButton("D");
        deleteButton.setBackground(Color.RED);
        clearButton = new JButton("C");
        clearButton.setBackground(Color.YELLOW);

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = deleteButton;
        functionButtons[7] = clearButton;

        //setting ActionListener for functionButtons
        for (int i = 0; i < 8; i++) {
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    buttonClick(e.getActionCommand());
                }
            });
        }

        //setting ActionListener for numberButtons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    buttonClick(e.getActionCommand());
                }
            });
        }

        deleteButton.setBounds(20, 100, 80, 50);
        clearButton.setBounds(230, 100, 80, 50);

        panel.setBounds(20, 155, 290, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(divButton);
        panel.add(equalButton);

        frame.add(panel);
        frame.add(textField);
        frame.add(clearButton);
        frame.add(deleteButton);
        frame.setVisible(true);
    }


    //setting the command buttons for functionButtons and numberButtons
    private void buttonClick(String command) {
        String currentText = textField.getText();

        if (command.matches("[0-9.]")) {
            textField.setText(currentText + command);
        }
			//here \\ seperates the - from +
		else if (command.matches("[+\\-*/]")) {
            textField.setText(currentText + " " + command + " ");
        } 
        else if (command.equals("=")) {
            try {
                String result = evaluateExpression(currentText);
                textField.setText(result);
            } catch (ArithmeticException | NumberFormatException ex) {
                textField.setText("Error");
            }
        } 
        else if (command.equals("C")) {
            textField.setText("");
        } 
        else if (command.equals("D")) {
            if (!currentText.isEmpty()) {
                textField.setText(currentText.substring(0, currentText.length() - 1));
            }
        }
    }

    //evaluate the expression or calculation
    private String evaluateExpression(String expression) {
        String[] flags = expression.split(" ");
        double operand1 = Double.parseDouble(flags[0]); //force to be double or else throws NumberFormatException
        double operand2 = Double.parseDouble(flags[2]); 
        String operator = flags[1];
        

        double result = 0;
        if (operator.equals("+")) {
            result = operand1 + operand2;
        } 
        else if (operator.equals("-")) {
            result = operand1 - operand2;
        } 
        else if (operator.equals("*")) {
            result = operand1 * operand2;
        } 
        else if (operator.equals("/")) {
            if (operand2 != 0) {
                result = operand1 / operand2;
            } else {
                throw new ArithmeticException("Can't devide by zero");
            }
        }

        // Format the result to four decimal places
        return String.format("%.2f", result);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
