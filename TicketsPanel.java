package park.ui;

import park.model.*; import park.service.ParkService; import park.util.*;
import javax.swing.*; import java.awt.*;

public class TicketsPanel extends JPanel {
    private final ParkService service; private final Runnable refresh; private final DefaultListModel<String> model=new DefaultListModel<>(); private final JList<String> list=new JList<>(model);
    public TicketsPanel(ParkService s,Runnable r){service=s;refresh=r;setLayout(new BorderLayout(16,16));setBorder(BorderFactory.createEmptyBorder(12,2,2,2));setBackground(UiUtil.BG);
        JPanel head=new JPanel(new BorderLayout(12,10)); head.setOpaque(false); head.add(UiUtil.pageHeader("Ticket Sales","Sell admission passes and issue instant receipts."),BorderLayout.CENTER); head.add(UiUtil.infoStrip("HOW TO USE","Choose a pass type, enter the guest name, then press Sell Ticket to issue a receipt and record the sale.",UiUtil.PRIMARY),BorderLayout.SOUTH); add(head,BorderLayout.NORTH);
        JPanel center=new JPanel(new BorderLayout(16,16)); center.setOpaque(false);
        JPanel form=UiUtil.card();form.setPreferredSize(new Dimension(390,0));form.setLayout(new GridBagLayout());GridBagConstraints g=new GridBagConstraints();g.insets=new Insets(9,9,9,9);g.fill=GridBagConstraints.HORIZONTAL;g.weightx=1;
        JTextField visitor=new JTextField("Walk-in Visitor"); visitor.setPreferredSize(new Dimension(220,42)); JComboBox<TicketType> type=new JComboBox<>(TicketType.values()); type.setPreferredSize(new Dimension(220,42)); JButton sell=UiUtil.actionButton("SELL TICKET  →  PRINT RECEIPT",UiUtil.PRIMARY,Color.WHITE);
        addRow(form,g,0,"Visitor Name",visitor);addRow(form,g,1,"Ticket Type",type);g.gridx=0;g.gridy=2;g.gridwidth=2;form.add(sell,g);
        center.add(form,BorderLayout.WEST);
        JPanel recent=UiUtil.card(); JPanel rh=new JPanel(new BorderLayout());rh.setOpaque(false);JLabel t=new JLabel("Recent Ticket Sales");t.setFont(new Font("SansSerif",Font.BOLD,18));rh.add(t,BorderLayout.WEST);JLabel count=new JLabel();rh.add(count,BorderLayout.EAST); recent.add(rh,BorderLayout.NORTH);
        list.setFont(new Font("SansSerif",Font.PLAIN,15)); list.setFixedCellHeight(42); list.setBackground(new Color(248,250,252)); recent.add(new JScrollPane(list),BorderLayout.CENTER); center.add(recent,BorderLayout.CENTER); add(center,BorderLayout.CENTER);
        sell.addActionListener(e->{try{Ticket tt=service.sellTicket((TicketType)type.getSelectedItem(),visitor.getText().trim());showReceipt(tt);refresh.run();}catch(Exception ex){UiUtil.error(this,ex.getMessage());}}); refreshList();
    }
    private void addRow(JPanel p,GridBagConstraints g,int y,String label,JComponent c){g.gridx=0;g.gridy=y;g.gridwidth=1;p.add(new JLabel(label),g);g.gridx=1;p.add(c,g);}
    private void showReceipt(Ticket t){String text="WONDERWORLD AMUSEMENT PARK\n================================\nTicket: "+t.getId()+"\nGuest: "+t.getVisitorName()+"\nType: "+t.getType().getLabel()+"\nPrice: $"+String.format("%.2f",t.getPrice())+"\nPurchased: "+t.getTimestamp();JTextArea a=new JTextArea(text);a.setEditable(false);a.setFont(new Font("Monospaced",Font.PLAIN,15));a.setBorder(BorderFactory.createEmptyBorder(14,14,14,14));JOptionPane.showMessageDialog(this,new JScrollPane(a),"Ticket Receipt",JOptionPane.INFORMATION_MESSAGE);}
    public void refreshList(){model.clear();service.getTickets().forEach(t->model.addElement(t.getId()+"   •   "+t.getVisitorName()+"   •   "+t.getType().getLabel()+"   •   $"+String.format("%.2f",t.getPrice())));}
}
