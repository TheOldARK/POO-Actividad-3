import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Capitulo_3_Ejercicio_19 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Capitulo_3_Ejercicio_19::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Cálculo de Triángulo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Panel para el formulario
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(2, 2, 10, 10));

        JLabel lblLado = new JLabel("Medida del lado del triángulo:");
        JTextField txtLado = new JTextField();

        JButton btnCalcular = new JButton("Calcular");
        JTextArea txtResultado = new JTextArea(5, 20);
        txtResultado.setEditable(false);

        formPanel.add(lblLado);
        formPanel.add(txtLado);
        formPanel.add(new JLabel()); // Espaciador
        formPanel.add(btnCalcular);

        // Agregar componentes al marco
        frame.add(formPanel, BorderLayout.CENTER);
        frame.add(new JScrollPane(txtResultado), BorderLayout.SOUTH);

        // Acción del botón
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int lado = Integer.parseInt(txtLado.getText());

                    int perimetro = lado * 3;
                    double altura = (lado * Math.sqrt(3)) / 2;
                    double area = (lado * altura) / 2;

                    // Mostrar resultados
                    txtResultado.setText(String.format("Cálculo de Triángulo:\n" +
                                    "Perímetro: %d\n" +
                                    "Altura: %.2f\n" +
                                    "Área: %.2f\n",
                            perimetro, altura, area));
                } catch (NumberFormatException ex) {
                    txtResultado.setText("Por favor, ingrese un número válido para el lado del triángulo.");
                }
            }
        });

        frame.setVisible(true);
    }
}
