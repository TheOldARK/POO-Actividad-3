import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Capitulo_3_Ejercicio_18 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Capitulo_3_Ejercicio_18::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Capitulo 3 Ejercicio 18");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        // Panel para el formulario
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(6, 2, 10, 10));

        JLabel lblCodigo = new JLabel("Código:");
        JTextField txtCodigo = new JTextField();

        JLabel lblNombre = new JLabel("Nombre Completo:");
        JTextField txtNombre = new JTextField();

        JLabel lblHoras = new JLabel("Horas Trabajadas al Mes:");
        JTextField txtHoras = new JTextField();

        JLabel lblValorHora = new JLabel("Valor por Hora:");
        JTextField txtValorHora = new JTextField();

        JLabel lblRetencion = new JLabel("% Retención de Fuente:");
        JTextField txtRetencion = new JTextField();

        JButton btnCalcular = new JButton("Calcular");
        JTextArea txtResultado = new JTextArea(5, 20);
        txtResultado.setEditable(false);

        formPanel.add(lblCodigo);
        formPanel.add(txtCodigo);
        formPanel.add(lblNombre);
        formPanel.add(txtNombre);
        formPanel.add(lblHoras);
        formPanel.add(txtHoras);
        formPanel.add(lblValorHora);
        formPanel.add(txtValorHora);
        formPanel.add(lblRetencion);
        formPanel.add(txtRetencion);
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
                    String codigo = txtCodigo.getText();
                    String nombre = txtNombre.getText();
                    double horasTrabajadas = Double.parseDouble(txtHoras.getText());
                    double valorHora = Double.parseDouble(txtValorHora.getText());
                    double porcentajeRetencion = Double.parseDouble(txtRetencion.getText());

                    double salarioBruto = horasTrabajadas * valorHora;
                    double retencion = salarioBruto * (porcentajeRetencion / 100);
                    double salarioNeto = salarioBruto - retencion;

                    // Mostrar resultados
                    txtResultado.setText(String.format("Cálculo de Salario:\n" +
                                    "Código: %s\n" +
                                    "Nombre Completo: %s\n" +
                                    "Salario Bruto: %.2f\n" +
                                    "Salario Neto: %.2f\n",
                            codigo, nombre, salarioBruto, salarioNeto));
                } catch (NumberFormatException ex) {
                    txtResultado.setText("Por favor, ingrese todos los datos correctamente.");
                }
            }
        });

        frame.setVisible(true);
    }
}
