package park.util;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public final class UiUtil {
    public static final Color BG = new Color(241, 245, 249);
    public static final Color SURFACE = Color.WHITE;
    public static final Color NAV = new Color(15, 23, 42);
    public static final Color NAV_ALT = new Color(30, 41, 59);
    public static final Color PRIMARY = new Color(37, 99, 235);
    public static final Color PRIMARY_DARK = new Color(29, 78, 216);
    public static final Color TEAL = new Color(13, 148, 136);
    public static final Color GREEN = new Color(22, 163, 74);
    public static final Color ORANGE = new Color(234, 88, 12);
    public static final Color PURPLE = new Color(124, 58, 237);
    public static final Color RED = new Color(220, 38, 38);
    public static final Color TEXT = new Color(15, 23, 42);
    public static final Color MUTED = new Color(71, 85, 105);
    public static final Color BORDER = new Color(226, 232, 240);
    public static final Color NAV_TEXT = new Color(226, 232, 240);
    public static final Color NAV_MUTED = new Color(148, 163, 184);
    public static final Color NAV_HOVER = new Color(51, 65, 85);
    public static final Color NAV_ACTIVE = new Color(37, 99, 235);
    public static final Color NAV_ACTIVE_2 = new Color(29, 78, 216);

    private UiUtil() {}

    public static void installTheme() {
        UIManager.put("Button.font", new Font("SansSerif", Font.BOLD, 15));
        UIManager.put("Label.font", new Font("SansSerif", Font.PLAIN, 14));
        UIManager.put("TextField.font", new Font("SansSerif", Font.PLAIN, 15));
        UIManager.put("ComboBox.font", new Font("SansSerif", Font.PLAIN, 15));
        UIManager.put("Table.font", new Font("SansSerif", Font.PLAIN, 14));
        UIManager.put("TableHeader.font", new Font("SansSerif", Font.BOLD, 14));
        UIManager.put("OptionPane.messageFont", new Font("SansSerif", Font.PLAIN, 14));
        UIManager.put("ScrollBar.width", 12);
    }

    public static JButton button(String text) {
        JButton b = new JButton(text);
        b.setFocusPainted(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.setFont(new Font("SansSerif", Font.BOLD, 15));
        b.setMargin(new Insets(12, 18, 12, 18));
        b.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER),
                new EmptyBorder(9, 15, 9, 15)));
        b.setBackground(SURFACE);
        b.setForeground(TEXT);
        return b;
    }

    public static JButton navButton(String label, String key, Runnable action) {
        JButton b = new JButton(label);
        b.setUI(new BasicButtonUI());
        b.setFocusPainted(false);
        b.setOpaque(true);
        b.setContentAreaFilled(true);
        b.setBorderPainted(false);
        b.setForeground(NAV_TEXT);
        b.setBackground(NAV_ALT);
        b.setFont(new Font("SansSerif", Font.BOLD, 15));
        b.setHorizontalAlignment(SwingConstants.LEFT);
        b.setBorder(new EmptyBorder(0, 18, 0, 14));
        b.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        b.setPreferredSize(new Dimension(240, 60));
        b.setAlignmentX(Component.LEFT_ALIGNMENT);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.setToolTipText("Open " + label);
        b.addActionListener(e -> action.run());
        return b;
    }

    public static JButton primaryButton(String text) {
        JButton b = button(text);
        b.setBackground(PRIMARY);
        b.setForeground(Color.WHITE);
        b.setBorder(BorderFactory.createEmptyBorder(12, 18, 12, 18));
        return b;
    }


    public static JButton actionButton(String text, Color bg, Color fg) {
        JButton b = new JButton(text);
        b.setFocusPainted(false);
        b.setOpaque(true);
        b.setContentAreaFilled(true);
        b.setBorderPainted(false);
        b.setBackground(bg);
        b.setForeground(fg);
        b.setFont(new Font("SansSerif", Font.BOLD, 14));
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.setBorder(new EmptyBorder(12, 18, 12, 18));
        b.setMinimumSize(new Dimension(170, 46));
        b.setPreferredSize(new Dimension(190, 50));
        return b;
    }

    public static JPanel infoStrip(String title, String text, Color accent) {
        JPanel p = new JPanel(new BorderLayout(12, 4));
        p.setBackground(new Color(248, 250, 252));
        p.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 4, 0, 0, accent),
                new EmptyBorder(10, 12, 10, 12)));
        JPanel copy = new JPanel();
        copy.setOpaque(false);
        copy.setLayout(new BoxLayout(copy, BoxLayout.Y_AXIS));
        JLabel h = new JLabel(title);
        h.setFont(new Font("SansSerif", Font.BOLD, 13));
        h.setForeground(TEXT);
        JLabel d = new JLabel("<html><div style='width:500px'>" + text + "</div></html>");
        d.setFont(new Font("SansSerif", Font.PLAIN, 12));
        d.setForeground(MUTED);
        copy.add(h);
        copy.add(Box.createVerticalStrut(2));
        copy.add(d);
        p.add(copy, BorderLayout.CENTER);
        return p;
    }

    public static JLabel title(String text) {
        JLabel l = new JLabel(text);
        l.setFont(new Font("SansSerif", Font.BOLD, 30));
        l.setForeground(TEXT);
        return l;
    }

    public static JLabel subtitle(String text) {
        JLabel l = new JLabel(text);
        l.setFont(new Font("SansSerif", Font.PLAIN, 14));
        l.setForeground(MUTED);
        return l;
    }

    public static JPanel card() {
        JPanel p = new JPanel(new BorderLayout(12, 12));
        p.setBackground(SURFACE);
        p.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER),
                new EmptyBorder(18, 18, 18, 18)));
        return p;
    }

    public static JPanel pageHeader(String title, String subtitle) {
        JPanel p = new JPanel(new BorderLayout(4, 4));
        p.setOpaque(false);
        JPanel text = new JPanel();
        text.setOpaque(false);
        text.setLayout(new BoxLayout(text, BoxLayout.Y_AXIS));
        text.add(UiUtil.title(title));
        text.add(Box.createVerticalStrut(4));
        text.add(UiUtil.subtitle(subtitle));
        p.add(text, BorderLayout.WEST);
        return p;
    }

    public static void styleTable(JTable table) {
        table.setRowHeight(36);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 1));
        table.setFillsViewportHeight(true);
        table.setSelectionBackground(new Color(219, 234, 254));
        table.setSelectionForeground(TEXT);
        table.setBackground(Color.WHITE);
        JTableHeader h = table.getTableHeader();
        h.setPreferredSize(new Dimension(h.getPreferredSize().width, 42));
        h.setBackground(NAV);
        h.setForeground(Color.WHITE);
        h.setReorderingAllowed(false);
    }

    public static void stripeTable(JTable table) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override public Component getTableCellRendererComponent(JTable t, Object value, boolean selected, boolean focused, int row, int col) {
                Component c = super.getTableCellRendererComponent(t, value, selected, focused, row, col);
                c.setFont(new Font("SansSerif", Font.PLAIN, 14));
                if (c instanceof JComponent jc) jc.setBorder(new EmptyBorder(0, 10, 0, 10));
                if (!selected) c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(248, 250, 252));
                return c;
            }
        };
        for (int i = 0; i < table.getColumnCount(); i++) table.getColumnModel().getColumn(i).setCellRenderer(renderer);
    }

    public static void error(Component parent, String message) { JOptionPane.showMessageDialog(parent, message, "Action Required", JOptionPane.ERROR_MESSAGE); }
    public static void info(Component parent, String message) { JOptionPane.showMessageDialog(parent, message, "WonderWorld", JOptionPane.INFORMATION_MESSAGE); }
}
