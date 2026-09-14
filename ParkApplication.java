package park.app;

import park.ui.MainFrame;
import javax.swing.*;
import java.awt.*;

public class ParkApplication {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception ignored) {}
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
