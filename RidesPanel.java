package park.ui;

import park.model.*; import park.service.ParkService; import park.util.*;
import javax.swing.*; import javax.swing.table.DefaultTableModel; import java.awt.*;

public class RidesPanel extends JPanel {
    private final ParkService service; private final Runnable refresh;
    private final DefaultTableModel model = new DefaultTableModel(new Object[]{"ID","Ride","Type","Capacity","Min Age","Status","Cycles","Riders"},0){public boolean isCellEditable(int r,int c){return false;}};
    private final JTable table = new JTable(model);

    public RidesPanel(ParkService s,Runnable r){
        service=s; refresh=r; setLayout(new BorderLayout(16,16)); setBorder(BorderFactory.createEmptyBorder(12,2,2,2)); setBackground(UiUtil.BG);
        JPanel head=new JPanel(new BorderLayout(12,10)); head.setOpaque(false); head.add(UiUtil.pageHeader("Ride Operations","Operate rides, manage availability and monitor throughput."),BorderLayout.CENTER); head.add(UiUtil.infoStrip("RIDE WORKFLOW","Select a ride in the table → Open it → Operate a cycle to record riders. Use Maintenance when a ride needs to be taken offline.",UiUtil.ORANGE),BorderLayout.SOUTH); add(head,BorderLayout.NORTH);
        UiUtil.styleTable(table); UiUtil.stripeTable(table);
        JScrollPane scroll = new JScrollPane(table); scroll.setBorder(BorderFactory.createLineBorder(UiUtil.BORDER)); add(scroll,BorderLayout.CENTER);
        JPanel controls = new JPanel(new FlowLayout(FlowLayout.LEFT,10,0)); controls.setOpaque(false);
        JButton operate=UiUtil.actionButton("OPERATE CYCLE",UiUtil.PRIMARY,Color.WHITE); JButton open=UiUtil.actionButton("OPEN RIDE",UiUtil.GREEN,Color.WHITE); JButton maintain=UiUtil.actionButton("SEND TO MAINTENANCE",UiUtil.ORANGE,Color.WHITE);
        controls.add(operate); controls.add(open); controls.add(maintain); add(controls,BorderLayout.SOUTH);
        operate.addActionListener(e->{int row=table.getSelectedRow();if(row<0){UiUtil.error(this,"Select a ride first.");return;}String riders=JOptionPane.showInputDialog(this,"How many riders are on this cycle?","10");if(riders==null)return;try{service.operateRide((String)model.getValueAt(row,0),NumberUtil.parseInt(riders,"Riders"));refresh.run();}catch(Exception ex){UiUtil.error(this,ex.getMessage());}});
        open.addActionListener(e->status(RideStatus.OPEN)); maintain.addActionListener(e->status(RideStatus.MAINTENANCE)); refreshTable();
    }
    private void status(RideStatus st){int row=table.getSelectedRow();if(row<0){UiUtil.error(this,"Select a ride first.");return;}service.updateRideStatus((String)model.getValueAt(row,0),st);refresh.run();}
    public void refreshTable(){model.setRowCount(0);service.getRides().forEach(r->model.addRow(new Object[]{r.getId(),r.getName(),r.getType(),r.getCapacity(),r.getMinAge(),r.getStatus(),r.getCycles(),r.getRidersToday()})); UiUtil.styleTable(table); UiUtil.stripeTable(table);}
}
