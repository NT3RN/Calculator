import java.lang.*;
import javax.swing.*;
import java.awt.*;

public class Calculator{
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton, equalButton, decButton, deleteButton, clearButton;
    JPanel panel = new JPanel();

    Font myFont = new Font(null, Font.ITALIC, 35);


    Calculator(){
        frame = new JFrame("Calculator GUI");
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

    for (int i = 0; i < 8; i++) {
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
    }

    for (int i = 0; i < 10; i++) {
        numberButtons[i] = new JButton(String.valueOf(i));
        numberButtons[i].setFont(myFont);
        numberButtons[i].setFocusable(false);
    }

    deleteButton.setBounds(20, 100, 80, 50);
    clearButton.setBounds(230,100,80,50);

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

    public static void main(String[] args) {
        
        Calculator cal = new Calculator();
        
        System.out.println(cal);
    }
}