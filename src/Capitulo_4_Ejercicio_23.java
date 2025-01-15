import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Capitulo_4_Ejercicio_23 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Capitulo_4_Ejercicio_23::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Capitulo 4 Ejercicio 23");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());

        // Panel para el formulario
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel lblA = new JLabel("Valor A:");
        JTextField txtA = new JTextField();

        JLabel lblB = new JLabel("Valor B:");
        JTextField txtB = new JTextField();

        JLabel lblC = new JLabel("Valor C:");
        JTextField txtC = new JTextField();

        JButton btnCalcular = new JButton("Calcular");
        JTextArea txtResultado = new JTextArea(5, 20);
        txtResultado.setEditable(false);

        formPanel.add(lblA);
        formPanel.add(txtA);
        formPanel.add(lblB);
        formPanel.add(txtB);
        formPanel.add(lblC);
        formPanel.add(txtC);
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
                    double a = Double.parseDouble(txtA.getText());
                    double b = Double.parseDouble(txtB.getText());
                    double c = Double.parseDouble(txtC.getText());

                    double discriminante = Math.pow(b, 2) - 4 * a * c;

                    if (discriminante < 0) {
                        txtResultado.setText("La ecuación no tiene soluciones reales.");
                    } else {
                        double sqrtDiscriminante = Math.sqrt(discriminante);
                        double solucion1 = (-b + sqrtDiscriminante) / (2 * a);
                        double solucion2 = (-b - sqrtDiscriminante) / (2 * a);

                        txtResultado.setText(String.format("Solución 1: %.2f\nSolución 2: %.2f", solucion1, solucion2));
                    }
                } catch (NumberFormatException ex) {
                    txtResultado.setText("Por favor, ingrese valores válidos en todos los campos.");
                } catch (ArithmeticException ex) {
                    txtResultado.setText("El valor de 'A' no puede ser 0.");
                }
            }
        });

        frame.setVisible(true);
    }
}