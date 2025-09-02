package SimpleGUI;

import javax.swing.*;

public class SimpleGUI {
    public static void main(String[] args) {
        // Create the main frame (window)
        JFrame frame = new JFrame("Simple GUI");
        frame.setSize(300, 200);         // Width x Height
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);           // Using absolute positioning

        // Create a label
        JLabel label = new JLabel("Hello, GUI World!");
        label.setBounds(90, 30, 150, 30);  // x, y, width, height
        frame.add(label);

        // Create a button
        JButton button = new JButton("Click Me");
        button.setBounds(100, 80, 100, 30);
        frame.add(button);

        // Show the window
        frame.setVisible(true);
    }
}
