import javax.swing.*;
import java.awt.*;

public class Figuras_Geometricas {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}

class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Calculadora de Figuras Geométricas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JButton circleButton = new JButton("Círculo");
        JButton rectangleButton = new JButton("Rectángulo");
        JButton squareButton = new JButton("Cuadrado");
        JButton triangleButton = new JButton("Triángulo");

        panel.add(new JLabel("Selecciona una figura:"));
        panel.add(circleButton);
        panel.add(rectangleButton);
        panel.add(squareButton);
        panel.add(triangleButton);

        add(panel);

        circleButton.addActionListener(e -> new CircleFrame());
        rectangleButton.addActionListener(e -> new RectangleFrame());
        squareButton.addActionListener(e -> new SquareFrame());
        triangleButton.addActionListener(e -> new TriangleFrame());

        setVisible(true);
    }
}

// Clase Circle
class Circle {
    int ratio;

    Circle(int ratio) {
        this.ratio = ratio;
    }

    double area() {
        return Math.PI * Math.pow(ratio, 2);
    }

    double perimeter() {
        return 2 * Math.PI * ratio;
    }
}

// Clase Rectangle
class Rectangle {
    int base, height;

    Rectangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    double area() {
        return base * height;
    }

    double perimeter() {
        return 2 * (base + height);
    }
}

// Clase Square
class Square {
    int side;

    Square(int side) {
        this.side = side;
    }

    double area() {
        return side * side;
    }

    double perimeter() {
        return 4 * side;
    }
}

// Clase Triangle
class Triangle {
    int base, height;

    Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    double area() {
        return (base * height) / 2.0;
    }

    double hypotenuse() {
        return Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2));
    }

    double perimeter() {
        return base + height + hypotenuse();
    }

    String triangleType() {
        double hypotenuse = hypotenuse();
        if (base == height && base == hypotenuse) {
            return "Equilátero";
        } else if (base != height && base != hypotenuse && height != hypotenuse) {
            return "Escaleno";
        } else {
            return "Isósceles";
        }
    }
}


class CircleFrame extends JFrame {

    public CircleFrame() {
        setTitle("Círculo");
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel radiusLabel = new JLabel("Radio:");
        JTextField radiusField = new JTextField();
        JButton calculateButton = new JButton("Calcular");
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        panel.add(radiusLabel);
        panel.add(radiusField);
        panel.add(calculateButton);
        panel.add(new JLabel("Resultados:"));
        panel.add(resultArea);

        add(panel);

        calculateButton.addActionListener(e -> {
            try {
                int radius = Integer.parseInt(radiusField.getText());
                Circle circle = new Circle(radius);
                String result = "Área: " + String.format("%.2f", circle.area()) +
                        "\nPerímetro: " + String.format("%.2f", circle.perimeter());
                resultArea.setText(result);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa un número válido.");
            }
        });

        setVisible(true);
    }
}

class RectangleFrame extends JFrame {

    public RectangleFrame() {
        setTitle("Rectángulo");
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel baseLabel = new JLabel("Base:");
        JTextField baseField = new JTextField();
        JLabel heightLabel = new JLabel("Altura:");
        JTextField heightField = new JTextField();
        JButton calculateButton = new JButton("Calcular");
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        panel.add(baseLabel);
        panel.add(baseField);
        panel.add(heightLabel);
        panel.add(heightField);
        panel.add(calculateButton);
        panel.add(new JLabel("Resultados:"));
        panel.add(resultArea);

        add(panel);

        calculateButton.addActionListener(e -> {
            try {
                int base = Integer.parseInt(baseField.getText());
                int height = Integer.parseInt(heightField.getText());
                Rectangle rectangle = new Rectangle(base, height);
                String result = "Área: " + rectangle.area() +
                        "\nPerímetro: " + rectangle.perimeter();
                resultArea.setText(result);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa números válidos.");
            }
        });

        setVisible(true);
    }
}

class SquareFrame extends JFrame {

    public SquareFrame() {
        setTitle("Cuadrado");
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel sideLabel = new JLabel("Lado:");
        JTextField sideField = new JTextField();
        JButton calculateButton = new JButton("Calcular");
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        panel.add(sideLabel);
        panel.add(sideField);
        panel.add(calculateButton);
        panel.add(new JLabel("Resultados:"));
        panel.add(resultArea);

        add(panel);

        calculateButton.addActionListener(e -> {
            try {
                int side = Integer.parseInt(sideField.getText());
                Square square = new Square(side);
                String result = "Área: " + square.area() +
                        "\nPerímetro: " + square.perimeter();
                resultArea.setText(result);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa un número válido.");
            }
        });

        setVisible(true);
    }
}

class TriangleFrame extends JFrame {

    public TriangleFrame() {
        setTitle("Triángulo");
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel baseLabel = new JLabel("Base:");
        JTextField baseField = new JTextField();
        JLabel heightLabel = new JLabel("Altura:");
        JTextField heightField = new JTextField();
        JButton calculateButton = new JButton("Calcular");
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        panel.add(baseLabel);
        panel.add(baseField);
        panel.add(heightLabel);
        panel.add(heightField);
        panel.add(calculateButton);
        panel.add(new JLabel("Resultados:"));
        panel.add(resultArea);

        add(panel);

        calculateButton.addActionListener(e -> {
            try {
                int base = Integer.parseInt(baseField.getText());
                int height = Integer.parseInt(heightField.getText());
                Triangle triangle = new Triangle(base, height);
                String result = "Área: " + String.format("%.2f", triangle.area()) +
                        "\nPerímetro: " + String.format("%.2f", triangle.perimeter()) +
                        "\nTipo: " + triangle.triangleType();
                resultArea.setText(result);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa números válidos.");
            }
        });

        setVisible(true);
    }
}
