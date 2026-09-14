package park.ui;

import park.service.ParkService; import park.util.UiUtil;
import javax.swing.*; import java.awt.*;

public class EventsPanel extends JPanel {
    private final ParkService service; private final JTextArea area=new JTextArea();
    public EventsPanel(ParkService s){service=s;setLayout(new BorderLayout(16,16));setBorder(BorderFactory.createEmptyBorder(12,2,2,2));setBackground(UiUtil.BG);JPanel head=new JPanel(new BorderLayout(12,10)); head.setOpaque(false); head.add(UiUtil.pageHeader("Activity Log","A chronological audit trail of actions performed in the system."),BorderLayout.CENTER); head.add(UiUtil.infoStrip("WHAT THIS SHOWS","Every important action is recorded here so an operator can quickly understand what happened during the park day.",UiUtil.RED),BorderLayout.SOUTH); add(head,BorderLayout.NORTH);JPanel card=UiUtil.card();area.setEditable(false);area.setFont(new Font("Monospaced",Font.PLAIN,14));area.setForeground(UiUtil.MUTED);area.setBackground(new Color(248,250,252));area.setBorder(BorderFactory.createEmptyBorder(14,14,14,14));card.add(new JScrollPane(area),BorderLayout.CENTER);JButton refresh=UiUtil.actionButton("REFRESH ACTIVITY",UiUtil.RED,Color.WHITE);refresh.addActionListener(e->refreshData());card.add(refresh,BorderLayout.SOUTH);add(card,BorderLayout.CENTER);refreshData();}
    private void refreshData(){StringBuilder b=new StringBuilder();service.getEvents().forEach(e->b.append("• ").append(e).append('\n'));area.setText(b.toString());area.setCaretPosition(0);}
}
