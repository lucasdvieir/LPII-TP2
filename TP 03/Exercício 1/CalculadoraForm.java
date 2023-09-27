import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraForm extends JFrame implements ActionListener {
    private JTextField textField;
    private double num1, num2, result;
    private char operator;
    private boolean isOperatorClicked = false;

    public CalculadoraForm() {
        setSize(240, 360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Calculadora");

        textField = new JTextField();
        textField.setEditable(false);
        add(textField, BorderLayout.NORTH);
	textField.setFont(new Font("Arial", Font.PLAIN, 24));

        JPanel buttonPanel = new JPanel(new GridLayout(5, 4));

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("C")) {
            textField.setText("");
            num1 = 0;
            num2 = 0;
            operator = ' ';
            isOperatorClicked = false;
        } else if (command.equals("=")) {
            if (!isOperatorClicked)
                return;

            num2 = Double.parseDouble(textField.getText());
            try {
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 == 0) {
                            textField.setText("Erro");
                            return;
                        }
                        result = num1 / num2;
                        break;
                }
                textField.setText(String.valueOf(result));
            } catch (ArithmeticException ex) {
                textField.setText("Erro");
            }
            isOperatorClicked = false;
        } else if (command.matches("[0-9]|\\.")) {
            textField.setText(textField.getText() + command);
        } else {
            if (!isOperatorClicked) {
                num1 = Double.parseDouble(textField.getText());
                operator = command.charAt(0);
                textField.setText("");
                isOperatorClicked = true;
            }
        }
    }

    }
