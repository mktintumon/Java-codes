import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CircleDragGUI extends JFrame {
    private JTextField circle1XField, circle1YField, circle1RField, circle2XField, circle2YField, circle2RField;
    private CirclePanel circlePanel;
    private Circle draggedCircle;

    public CircleDragGUI() {
        setTitle("Circle Dragging");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        circle1XField = new JTextField(5);
        circle1YField = new JTextField(5);
        circle1RField = new JTextField(5);
        circle2XField = new JTextField(5);
        circle2YField = new JTextField(5);
        circle2RField = new JTextField(5);

        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Circle 1 Center (X, Y):"));
        controlPanel.add(circle1XField);
        controlPanel.add(circle1YField);
        controlPanel.add(new JLabel("Circle 1 Radius:"));
        controlPanel.add(circle1RField);
        controlPanel.add(new JLabel("Circle 2 Center (X, Y):"));
        controlPanel.add(circle2XField);
        controlPanel.add(circle2YField);
        controlPanel.add(new JLabel("Circle 2 Radius:"));
        controlPanel.add(circle2RField);

        circlePanel = new CirclePanel();
        circlePanel.addMouseListener(new CircleMouseListener());
        circlePanel.addMouseMotionListener(new CircleMouseListener());

        add(controlPanel, BorderLayout.NORTH);
        add(circlePanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private class CirclePanel extends JPanel {
        private Circle circle1, circle2;

        public CirclePanel() {
            circle1 = new Circle(100, 100, 50);
            circle2 = new Circle(300, 200, 75);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            circle1.draw(g);
            circle2.draw(g);
        }
    }

    private class CircleMouseListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();

            Circle circle1 = circlePanel.circle1;
            Circle circle2 = circlePanel.circle2;

            if (circle1.containsPoint(x, y)) {
                draggedCircle = circle1;
            } else if (circle2.containsPoint(x, y)) {
                draggedCircle = circle2;
            }
        }

        public void mouseReleased(MouseEvent e) {
            draggedCircle = null;
        }

        public void mouseDragged(MouseEvent e) {
            if (draggedCircle != null) {
                int x = e.getX();
                int y = e.getY();
                draggedCircle.setCenter(x, y);
                updateTextFieldValues();
                circlePanel.repaint();
            }
        }
    }

    private void updateTextFieldValues() {
        Circle circle1 = circlePanel.circle1;
        Circle circle2 = circlePanel.circle2;

        circle1XField.setText(String.valueOf(circle1.getCenterX()));
        circle1YField.setText(String.valueOf(circle1.getCenterY()));
        circle1RField.setText(String.valueOf(circle1.getRadius()));
        circle2XField.setText(String.valueOf(circle2.getCenterX()));
        circle2YField.setText(String.valueOf(circle2.getCenterY()));
        circle2RField.setText(String.valueOf(circle2.getRadius()));
    }

    private class Circle {
        private int centerX;
        private int centerY;
        private int radius;

        public Circle(int centerX, int centerY, int radius) {
            this.centerX = centerX;
            this.centerY = centerY;
            this.radius = radius;
        }

        public void draw(Graphics g) {
            int x = centerX - radius;
            int y = centerY - radius;
            int diameter = radius * 2;
            g.drawOval(x, y, diameter, diameter);
        }

        public boolean containsPoint(int x, int y) {
            int dx = x - centerX;
            int dy = y - centerY;
            return (dx * dx + dy * dy) <= (radius * radius);
        }

        public int getCenterX() {
            return centerX;
        }

        public int getCenterY() {
            return centerY;
        }

        public int getRadius() {
            return radius;
        }

        public void setCenter(int x, int y) {
            centerX = x;
            centerY = y;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CircleDragGUI gui = new CircleDragGUI();
                gui.setVisible(true);
            }
        });
    }
}
