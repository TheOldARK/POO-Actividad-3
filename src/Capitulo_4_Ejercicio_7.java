import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Capitulo_4_Ejercicio_7 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Capitulo_4_Ejercicio_7::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Capitulo 4 Ejercicio 7");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        // Panel para el formulario
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel lblNumeroA = new JLabel("Número A:");
        JTextField txtNumeroA = new JTextField();

        JLabel lblNumeroB = new JLabel("Número B:");
        JTextField txtNumeroB = new JTextField();

        JButton btnComparar = new JButton("Comparar");
        JTextArea txtResultado = new JTextArea(3, 20);
        txtResultado.setEditable(false);

        formPanel.add(lblNumeroA);
        formPanel.add(txtNumeroA);
        formPanel.add(lblNumeroB);
        formPanel.add(txtNumeroB);
        formPanel.add(new JLabel()); // Espaciador
        formPanel.add(btnComparar);

        // Agregar componentes al marco
        frame.add(formPanel, BorderLayout.CENTER);
        frame.add(new JScrollPane(txtResultado), BorderLayout.SOUTH);

        // Acción del botón
        btnComparar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int a = Integer.parseInt(txtNumeroA.getText());
                    int b = Integer.parseInt(txtNumeroB.getText());

                    if (a > b) {
                        txtResultado.setText("A es mayor que B");
                    } else if (a == b) {
                        txtResultado.setText("A es igual que B");
                    } else {
                        txtResultado.setText("A es menor que B");
                    }
                } catch (NumberFormatException ex) {
                    txtResultado.setText("Por favor, ingrese números válidos en ambos campos.");
                }
            }
        });

        frame.setVisible(true);
    }
}