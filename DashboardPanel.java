package park.ui;

import park.service.ParkService;
import park.util.UiUtil;
import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel {
    private final ParkService service;
    private final JLabel revenue = new JLabel();
    private final JLabel riders = new JLabel();
    private final JLabel rides = new JLabel();
    private final JLabel people = new JLabel();
    private final JTextArea activity = new JTextArea();

    public DashboardPanel(ParkService service, Runnable refresh) {
        this.service = service;
        setLayout(new BorderLayout(18, 18));
        setBorder(BorderFactory.createEmptyBorder(8, 2, 2, 2));
        setBackground(UiUtil.BG);

        add(UiUtil.pageHeader("Park Dashboard", "Monitor admissions, rides, visitors, food sales and day-to-day operations."), BorderLayout.NORTH);

        JPanel center = new JPanel(new BorderLayout(16, 16));
        center.setOpaque(false);

        JPanel stats = new JPanel(new GridLayout(1, 4, 14, 14));
        stats.setOpaque(false);
        stats.add(stat("TODAY'S REVENUE", revenue, UiUtil.PRIMARY, "Ticket + food sales"));
        stats.add(stat("TOTAL RIDERS", riders, UiUtil.TEAL, "Ride throughput"));
        stats.add(stat("RIDES OPEN", rides, UiUtil.ORANGE, "Ready / total"));
        stats.add(stat("REGISTERED VISITORS", people, UiUtil.PURPLE, "Guest registry"));
        center.add(stats, BorderLayout.NORTH);

        JPanel lower = new JPanel(new GridLayout(1, 2, 16, 16));
        lower.setOpaque(false);

        JPanel live = UiUtil.card();
        JPanel liveHead = new JPanel(new BorderLayout()); liveHead.setOpaque(false);
        JLabel a = new JLabel("Live Activity"); a.setFont(new Font("SansSerif", Font.BOLD, 19)); a.setForeground(UiUtil.TEXT);
        JLabel hint = new JLabel("Latest system actions"); hint.setForeground(UiUtil.MUTED); hint.setFont(new Font("SansSerif", Font.PLAIN, 12));
        liveHead.add(a, BorderLayout.WEST); liveHead.add(hint, BorderLayout.EAST);
        live.add(liveHead, BorderLayout.NORTH);
        activity.setEditable(false);
        activity.setLineWrap(true); activity.setWrapStyleWord(true);
        activity.setFont(new Font("Monospaced", Font.PLAIN, 13));
        activity.setForeground(UiUtil.TEXT); activity.setBackground(new Color(248, 250, 252));
        activity.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        JScrollPane scroll = new JScrollPane(activity);
        scroll.setBorder(BorderFactory.createLineBorder(UiUtil.BORDER));
        live.add(scroll, BorderLayout.CENTER);
        lower.add(live);

        JPanel guide = UiUtil.card();
        guide.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(191, 219, 254), 1), BorderFactory.createEmptyBorder(18, 18, 18, 18)));
        JPanel g = new JPanel(); g.setOpaque(false); g.setLayout(new BoxLayout(g, BoxLayout.Y_AXIS));
        JLabel gh = new JLabel("First-day workflow"); gh.setFont(new Font("SansSerif", Font.BOLD, 20)); gh.setForeground(UiUtil.TEXT);
        JLabel gs = new JLabel("A simple route for operating the park."); gs.setFont(new Font("SansSerif", Font.PLAIN, 12)); gs.setForeground(UiUtil.MUTED);
        g.add(gh); g.add(Box.createVerticalStrut(3)); g.add(gs); g.add(Box.createVerticalStrut(16));
        g.add(step("01", "Register visitors", "Create guest records before you track their activity."));
        g.add(step("02", "Sell admission", "Choose a pass type and issue a receipt instantly."));
        g.add(step("03", "Open and operate rides", "Use Ride Operations to run cycles and track riders."));
        g.add(step("04", "Serve food & export", "Create orders, review activity and export CSV data."));
        lower.add(guide);

        center.add(lower, BorderLayout.CENTER);
        add(center, BorderLayout.CENTER);
        refreshData();
    }

    private JPanel step(String number, String title, String text) {
        JPanel row = new JPanel(new BorderLayout(10, 4)); row.setOpaque(false);
        JLabel n = new JLabel(number); n.setOpaque(true); n.setBackground(UiUtil.PRIMARY); n.setForeground(Color.WHITE);
        n.setFont(new Font("SansSerif", Font.BOLD, 12)); n.setHorizontalAlignment(SwingConstants.CENTER);
        n.setPreferredSize(new Dimension(38, 32));
        row.add(n, BorderLayout.WEST);
        JPanel copy = new JPanel(); copy.setOpaque(false); copy.setLayout(new BoxLayout(copy, BoxLayout.Y_AXIS));
        JLabel h = new JLabel(title); h.setFont(new Font("SansSerif", Font.BOLD, 14)); h.setForeground(UiUtil.TEXT);
        JLabel d = new JLabel("<html><div style='width:260px'>" + text + "</div></html>"); d.setFont(new Font("SansSerif", Font.PLAIN, 11)); d.setForeground(UiUtil.MUTED);
        copy.add(h); copy.add(Box.createVerticalStrut(2)); copy.add(d);
        row.add(copy, BorderLayout.CENTER);
        row.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        return row;
    }

    private JPanel stat(String label, JLabel value, Color accent, String note) {
        JPanel p = UiUtil.card();
        JPanel top = new JPanel(new BorderLayout()); top.setOpaque(false);
        JLabel dot = new JLabel("●"); dot.setForeground(accent); dot.setFont(new Font("SansSerif", Font.BOLD, 15));
        JLabel l = new JLabel(label); l.setForeground(UiUtil.MUTED); l.setFont(new Font("SansSerif", Font.BOLD, 11));
        top.add(dot, BorderLayout.WEST); top.add(l, BorderLayout.CENTER);
        p.add(top, BorderLayout.NORTH);
        value.setFont(new Font("SansSerif", Font.BOLD, 28)); value.setForeground(UiUtil.TEXT);
        p.add(value, BorderLayout.CENTER);
        JLabel n = new JLabel(note); n.setForeground(UiUtil.MUTED); n.setFont(new Font("SansSerif", Font.PLAIN, 11));
        p.add(n, BorderLayout.SOUTH);
        return p;
    }

    public void refreshData() {
        revenue.setText(String.format("$%,.2f", service.getRevenue()));
        riders.setText(String.valueOf(service.getTotalRiders()));
        rides.setText(service.getOpenRides() + " / " + service.getRides().size());
        people.setText(String.valueOf(service.getVisitors().size()));
        StringBuilder s = new StringBuilder();
        service.getEvents().forEach(e -> s.append("• ").append(e).append('\n'));
        activity.setText(s.toString());
        activity.setCaretPosition(0);
    }
}
