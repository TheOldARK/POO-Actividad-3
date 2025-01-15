import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Capitulo_4_Ejercicio_10 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Capitulo_4_Ejercicio_10::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Capitulo 4 Ejercicio 10");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());

        // Panel para el formulario
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel lblInscripcion = new JLabel("Número de Inscripción:");
        JTextField txtInscripcion = new JTextField();

        JLabel lblNombre = new JLabel("Nombre Completo:");
        JTextField txtNombre = new JTextField();

        JLabel lblPatrimonio = new JLabel("Patrimonio:");
        JTextField txtPatrimonio = new JTextField();

        JLabel lblEstrato = new JLabel("Estrato Social:");
        JTextField txtEstrato = new JTextField();

        JButton btnCalcular = new JButton("Calcular");
        JTextArea txtResultado = new JTextArea(5, 20);
        txtResultado.setEditable(false);

        formPanel.add(lblInscripcion);
        formPanel.add(txtInscripcion);
        formPanel.add(lblNombre);
        formPanel.add(txtNombre);
        formPanel.add(lblPatrimonio);
        formPanel.add(txtPatrimonio);
        formPanel.add(lblEstrato);
        formPanel.add(txtEstrato);
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
                    String inscripcion = txtInscripcion.getText();
                    String nombre = txtNombre.getText();
                    double patrimonio = Double.parseDouble(txtPatrimonio.getText());
                    double estrato = Double.parseDouble(txtEstrato.getText());

                    double matricula = 50000;
                    if (patrimonio > 2000000 && estrato > 3) {
                        matricula += patrimonio * 0.03;
                    }

                    // Mostrar resultados
                    txtResultado.setText(String.format("El estudiante con número de inscripción %s y nombre %s debe pagar $%.2f",
                            inscripcion, nombre, matricula));
                } catch (NumberFormatException ex) {
                    txtResultado.setText("Por favor, ingrese datos válidos en todos los campos.");
                }
            }
        });

        frame.setVisible(true);
    }
}
