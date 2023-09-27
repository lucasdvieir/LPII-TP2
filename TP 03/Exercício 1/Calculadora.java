import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora{
public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraForm calculadora = new CalculadoraForm();
            calculadora.setVisible(true);
        });
    }
}