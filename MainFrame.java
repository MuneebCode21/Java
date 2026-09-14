package park.ui;

import park.config.ParkConfig;
import park.service.*;
import park.util.UiUtil;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final ParkService service = new ParkService();
    private final PersistenceService persistence = new PersistenceService(Paths.get("data"));
    private final CardLayout contentLayout = new CardLayout();
    private final JPanel content = new JPanel(contentLayout);
    private final DashboardPanel dashboard;
    private JLabel sectionLabel;
    private final Map<String, JButton> navButtons = new LinkedHashMap<>();

    public MainFrame() {
        UiUtil.installTheme();
        setTitle(ParkConfig.PARK_NAME + " • Management Console");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1180, 760));
        setSize(1440, 900);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(UiUtil.BG);
        setJMenuBar(createMenu());

        add(createSidebar(), BorderLayout.WEST);
        add(createMainArea(), BorderLayout.CENTER);

        dashboard = new DashboardPanel(service, this::refreshAll);
        addScreens();
        showScreen("dashboard", "Dashboard");
    }

    private JPanel createMainArea() {
        JPanel root = new JPanel(new BorderLayout(0, 12));
        root.setBackground(UiUtil.BG);
        root.setBorder(BorderFactory.createEmptyBorder(18, 18, 18, 18));

        JPanel top = new JPanel(new BorderLayout(16, 10));
        top.setOpaque(false);

        JPanel crumb = new JPanel();
        crumb.setOpaque(false);
        crumb.setLayout(new BoxLayout(crumb, BoxLayout.Y_AXIS));
        sectionLabel = new JLabel("Dashboard");
        sectionLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        sectionLabel.setForeground(UiUtil.TEXT);
        JLabel helper = new JLabel("WonderWorld Control Center  •  Everything you need to run the park");
        helper.setFont(new Font("SansSerif", Font.PLAIN, 12));
        helper.setForeground(UiUtil.MUTED);
        crumb.add(sectionLabel);
        crumb.add(Box.createVerticalStrut(2));
        crumb.add(helper);
        top.add(crumb, BorderLayout.WEST);

        JPanel statusWrap = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        statusWrap.setOpaque(false);
        JLabel pill = new JLabel("  ●  PARK OPEN  ");
        pill.setOpaque(true);
        pill.setBackground(new Color(220, 252, 231));
        pill.setForeground(new Color(22, 101, 52));
        pill.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(187, 247, 208)),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)));
        pill.setFont(new Font("SansSerif", Font.BOLD, 12));
        statusWrap.add(pill);
        JLabel build = new JLabel("LIVE");
        build.setOpaque(true);
        build.setBackground(UiUtil.NAV);
        build.setForeground(Color.WHITE);
        build.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
        build.setFont(new Font("SansSerif", Font.BOLD, 11));
        statusWrap.add(build);
        top.add(statusWrap, BorderLayout.EAST);

        root.add(top, BorderLayout.NORTH);
        content.setOpaque(false);
        root.add(content, BorderLayout.CENTER);
        return root;
    }

    private void addScreens() {
        content.add(dashboard, "dashboard");
        content.add(new TicketsPanel(service, this::refreshAll), "tickets");
        content.add(new RidesPanel(service, this::refreshAll), "rides");
        content.add(new VisitorsPanel(service, this::refreshAll), "visitors");
        content.add(new FoodPanel(service, this::refreshAll), "food");
        content.add(new EmployeesPanel(service, this::refreshAll), "employees");
        content.add(new EventsPanel(service), "events");
    }

    private JPanel createSidebar() {
        JPanel p = new JPanel(new BorderLayout());
        p.setPreferredSize(new Dimension(300, 0));
        p.setBackground(UiUtil.NAV);
        p.setBorder(BorderFactory.createEmptyBorder(18, 16, 16, 16));

        JPanel brand = new JPanel();
        brand.setOpaque(false);
        brand.setLayout(new BoxLayout(brand, BoxLayout.Y_AXIS));

        JLabel mark = new JLabel("WW");
        mark.setOpaque(true);
        mark.setBackground(UiUtil.PRIMARY);
        mark.setForeground(Color.WHITE);
        mark.setFont(new Font("SansSerif", Font.BOLD, 18));
        mark.setHorizontalAlignment(SwingConstants.CENTER);
        mark.setAlignmentX(Component.LEFT_ALIGNMENT);
        mark.setBorder(BorderFactory.createEmptyBorder(7, 10, 7, 10));
        brand.add(mark);
        brand.add(Box.createVerticalStrut(10));

        JLabel name = new JLabel("WONDERWORLD");
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SansSerif", Font.BOLD, 28));
        brand.add(name);
        JLabel sub = new JLabel("AMUSEMENT PARK CONSOLE");
        sub.setForeground(UiUtil.NAV_MUTED);
        sub.setFont(new Font("SansSerif", Font.BOLD, 10));
        brand.add(sub);
        brand.add(Box.createVerticalStrut(15));

        JPanel status = new JPanel(new BorderLayout());
        status.setOpaque(true);
        status.setBackground(new Color(20, 34, 58));
        status.setBorder(BorderFactory.createEmptyBorder(10, 12, 10, 12));
        JLabel st1 = new JLabel("●  Operations ready");
        st1.setForeground(new Color(134, 239, 172));
        st1.setFont(new Font("SansSerif", Font.BOLD, 12));
        JLabel st2 = new JLabel("Today");
        st2.setForeground(UiUtil.NAV_MUTED);
        st2.setFont(new Font("SansSerif", Font.PLAIN, 11));
        status.add(st1, BorderLayout.WEST);
        status.add(st2, BorderLayout.EAST);
        brand.add(status);
        brand.add(Box.createVerticalStrut(18));
        p.add(brand, BorderLayout.NORTH);

        JPanel nav = new JPanel();
        nav.setOpaque(false);
        nav.setLayout(new BoxLayout(nav, BoxLayout.Y_AXIS));
        String[][] items = {
                {"▦", "Dashboard", "dashboard"},
                {"▣", "Tickets & Sales", "tickets"},
                {"↻", "Ride Operations", "rides"},
                {"●", "Visitor Registry", "visitors"},
                {"◆", "Food & Beverage", "food"},
                {"◆", "Employees", "employees"},
                {"≡", "Activity Log", "events"}
        };
        for (String[] item : items) {
            String label = item[0] + "   " + item[1];
            JButton b = UiUtil.navButton(label, item[2], () -> showScreen(item[2], item[1]));
            navButtons.put(item[2], b);
            nav.add(b);
            nav.add(Box.createVerticalStrut(8));
        }

        JPanel navWrap = new JPanel(new BorderLayout());
        navWrap.setOpaque(false);
        JLabel navTitle = new JLabel("  NAVIGATION");
        navTitle.setForeground(UiUtil.NAV_MUTED);
        navTitle.setFont(new Font("SansSerif", Font.BOLD, 10));
        navWrap.add(navTitle, BorderLayout.NORTH);
        navWrap.add(nav, BorderLayout.CENTER);
        p.add(navWrap, BorderLayout.CENTER);

        JPanel foot = new JPanel();
        foot.setOpaque(false);
        foot.setLayout(new BoxLayout(foot, BoxLayout.Y_AXIS));

        JPanel hint = new JPanel();
        hint.setOpaque(true);
        hint.setBackground(new Color(20, 34, 58));
        hint.setLayout(new BoxLayout(hint, BoxLayout.Y_AXIS));
        hint.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        JLabel ht = new JLabel("QUICK START");
        ht.setForeground(new Color(147, 197, 253));
        ht.setFont(new Font("SansSerif", Font.BOLD, 10));
        JLabel hb = new JLabel("1  Register guests  →  2  Sell tickets  →");
        hb.setForeground(Color.WHITE);
        hb.setFont(new Font("SansSerif", Font.PLAIN, 11));
        JLabel hc = new JLabel("3  Operate rides  →  4  Track activity");
        hc.setForeground(UiUtil.NAV_MUTED);
        hc.setFont(new Font("SansSerif", Font.PLAIN, 11));
        hint.add(ht); hint.add(Box.createVerticalStrut(4)); hint.add(hb); hint.add(hc);
        foot.add(hint);
        foot.add(Box.createVerticalStrut(10));

        JLabel tech = new JLabel("Java Swing  •  OOP  •  CSV Export");
        tech.setForeground(UiUtil.NAV_MUTED);
        tech.setFont(new Font("SansSerif", Font.PLAIN, 11));
        foot.add(tech);
        foot.add(Box.createVerticalStrut(8));
        JButton export = UiUtil.primaryButton("Export Park Data");
        export.setAlignmentX(Component.LEFT_ALIGNMENT);
        export.setMaximumSize(new Dimension(Integer.MAX_VALUE, 46));
        export.addActionListener(e -> {
            try { persistence.export(service); UiUtil.info(this, "CSV data exported to the data/ folder."); }
            catch (Exception ex) { UiUtil.error(this, ex.getMessage()); }
        });
        foot.add(export);
        p.add(foot, BorderLayout.SOUTH);
        return p;
    }

    private void showScreen(String key, String label) {
        contentLayout.show(content, key);
        sectionLabel.setText(label);
        navButtons.forEach((k, b) -> {
            b.setBackground(k.equals(key) ? UiUtil.NAV_ACTIVE : UiUtil.NAV_ALT);
            b.setForeground(Color.WHITE);
        });
        refreshAll();
    }

    private void refreshAll() {
        dashboard.refreshData();
        for (Component c : content.getComponents()) {
            if (c instanceof RidesPanel p) p.refreshTable();
            else if (c instanceof TicketsPanel p) p.refreshList();
            else if (c instanceof VisitorsPanel p) p.refreshTable();
            else if (c instanceof FoodPanel p) p.refreshOrders();
            else if (c instanceof EmployeesPanel p) p.refreshTable();
        }
        content.revalidate();
        content.repaint();
    }

    private JMenuBar createMenu() {
        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem export = new JMenuItem("Export CSV data");
        export.addActionListener(e -> {
            try { persistence.export(service); UiUtil.info(this, "Data exported to the data/ folder."); }
            catch (Exception ex) { UiUtil.error(this, ex.getMessage()); }
        });
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> System.exit(0));
        file.add(export); file.addSeparator(); file.add(exit); bar.add(file);
        return bar;
    }
}
