import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class Room_GUI extends JFrame implements ActionListener, MouseListener{
	private JButton[] jb=new JButton[2];
	private String[] buttonName={"방 생성","방 참여"};
	private JPanel jp=new JPanel();
	private Object[][] data=new Object[100][3];
	private String[] tableName={"Room Title","Master","Peaple"};
	private String pick_Title;
	private String pick_Master;
	   public DefaultTableModel model_user = new DefaultTableModel(tableName, 0);
	   public JTable table_user=new JTable(model_user)
	   {
	      public boolean isCellEditable(int rowIndex,int colIndex)
	      {
	         return false;
	      }
	   };   
	private String id;
	private String ip;
	private int port;
	private Client client;
	public Room_GUI(String id,String ip,int port){
		this.id=id;
		this.ip=ip;
		this.port=port;
		client=new Client(id,ip,port,this);
		guiReSize();
		buttonGenerate();
		mouseClick();
		guiGenerate();
	}
	public void addTable(Object[][] data){
		model_user.addRow(data[0]);
		
		
		revalidate();
		repaint();
		setVisible(true);
	}
	public void resetTable(Object[][] data){
			model_user = new DefaultTableModel(tableName, 0);
		 table_user=new JTable(model_user)
		   {
		      public boolean isCellEditable(int rowIndex,int colIndex)
		      {
		         return false;
		      }
		   };   
		   mouseClick();
		int i=0;
		while(data[i][0]!=null){
		model_user.addRow(data[i]);
		i++;
		}
		jp.add(new JScrollPane(table_user));
		add(jp);
		revalidate();
		repaint();
		setVisible(true);
	}
	public void adviseJtable(int room_Row,Object[][] data){
		model_user.removeRow(room_Row);
		model_user.insertRow(room_Row, data[0]);
	}
	private void guiReSize(){
		setBounds(0, 0, 500, 510);
		jp = new JPanel();
	}
	public void buttonGenerate(){
			jb[0]=new JButton(buttonName[0]);
			jb[1]=new JButton(buttonName[1]);
			jp.add(jb[0]);
			jp.add(jb[1]);
			jb[0].addActionListener(this);
			jb[1].addActionListener(this);
			
	}  	
	   
	public void guiGenerate(){
		add(jp);
		setVisible(true);
	}
	private void mouseClick(){
		table_user.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 단일선택
		table_user.addMouseListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jb[0])){
			String room_name=JOptionPane.showInputDialog("방이름");
			client.send_JsonMessage("RoomMake",room_name, this.id);
			
		}
		if(e.getSource().equals(jb[1])){
			client.send_JsonMessage("RoomParticipate", pick_Title, pick_Master);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		  int row = table_user.getSelectedRow();
	      int column = table_user.getSelectedColumn();
	      pick_Title=(table_user.getValueAt(row, 0)).toString();
	      pick_Master=(table_user.getValueAt(row, 1)).toString();
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
