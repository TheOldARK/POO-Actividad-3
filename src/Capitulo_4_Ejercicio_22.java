import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Capitulo_4_Ejercicio_22 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Capitulo_4_Ejercicio_22::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Cálculo de Salario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());

        // Panel para el formulario
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel lblNombre = new JLabel("Nombre del empleado:");
        JTextField txtNombre = new JTextField();

        JLabel lblSalarioBase = new JLabel("Salario básico por hora:");
        JTextField txtSalarioBase = new JTextField();

        JLabel lblHoras = new JLabel("Horas trabajadas:");
        JTextField txtHoras = new JTextField();

        JButton btnCalcular = new JButton("Calcular");
        JTextArea txtResultado = new JTextArea(5, 20);
        txtResultado.setEditable(false);

        formPanel.add(lblNombre);
        formPanel.add(txtNombre);
        formPanel.add(lblSalarioBase);
        formPanel.add(txtSalarioBase);
        formPanel.add(lblHoras);
        formPanel.add(txtHoras);
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
                    String nombre = txtNombre.getText();
                    int salarioBase = Integer.parseInt(txtSalarioBase.getText());
                    int horas = Integer.parseInt(txtHoras.getText());

                    int salarioMensual = salarioBase * horas;

                    if (salarioMensual > 450000) {
                        txtResultado.setText(String.format("Nombre del empleado: %s\nSalario mensual: $%d", nombre, salarioMensual));
                    } else {
                        txtResultado.setText(String.format("Nombre del empleado: %s\nSalario mensual: Salario no aplica para mostrar porque es menor o igual a $450,000.", nombre));
                    }
                } catch (NumberFormatException ex) {
                    txtResultado.setText("Por favor, ingrese valores válidos en los campos.");
                }
            }
        });

        frame.setVisible(true);
    }
}
