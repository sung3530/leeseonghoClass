package remakeChatting.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class clientGui extends JFrame {
	private	JPanel ChattingJpanel=new JPanel();
	private	JTextField sendTextField=new JTextField();
	private	JScrollPane scrollPane = new JScrollPane();
	private	JTextArea textArea=new JTextArea();
	private JTextArea loginUser=new JTextArea();
	private JTextArea chattingRoom=new JTextArea();
	private	JButton jb=new JButton();
	private	JButton room_make=new JButton();
	private	JButton room_participate=new JButton();
	private String id;
	private String ip;
	private int port;
	private clientGui_controller client_control;
	public clientGui(String id, String ip, int port){
		System.out.println(id);
		this.id=id;
		this.ip=ip;
		this.port=port;
		client_control=new clientGui_controller(this);
		
		panelReSize();
		sendTextFieldGenerate();
		textAreaGenerate();
		buttonGenerate();
		panelGenerate();
	}
	public JTextArea getTextArea(){
		return textArea;
	}
	public JButton getButton(){
		return jb;
	}
	public JButton getRoom_make(){
		return room_make;
	}
	public JButton getRoom_participate(){
		return room_participate;
	}
	public JTextField getTextField(){
		return sendTextField;
	}
	public String getId(){
		return id;
	}
	public String getIp(){
		return ip;
	}
	public int getPort(){
		return port;
	}
	private void panelReSize(){
		setBounds(100, 100, 500, 390);
		ChattingJpanel = new JPanel();
		ChattingJpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ChattingJpanel);
		ChattingJpanel.setLayout(null);
		
	}
	private void sendTextFieldGenerate(){
		sendTextField=new JTextField();
		sendTextField.setBounds(185, 300, 170, 40);
		sendTextField.setColumns(5);
		ChattingJpanel.add(sendTextField);
		sendTextField.addKeyListener(client_control);
	}
	private void textAreaGenerate(){
		textArea=new JTextArea();
		loginUser=new JTextArea();
		chattingRoom=new JTextArea();
		scrollPane.setBounds(180, 0, 300, 300);
		loginUser.setBounds(5,0,170,150);
		chattingRoom.setBounds(5,155,170,150);
		ChattingJpanel.add(scrollPane);
		ChattingJpanel.add(loginUser);
		ChattingJpanel.add(chattingRoom);
		scrollPane.setViewportView(textArea);
	}
	private void buttonGenerate(){
		jb=new JButton("Send");
		room_make=new JButton("号 持失");
		room_participate=new JButton("号 凧食");
		jb.setBounds(360, 300, 115, 42);
		room_make.setBounds(5,310,80,20);
		room_participate.setBounds(90,310,80,20);
		ChattingJpanel.add(jb);
		ChattingJpanel.add(room_make);
		ChattingJpanel.add(room_participate);
		jb.addActionListener(client_control);
		room_make.addActionListener(client_control);
		room_participate.addActionListener(client_control);
	}
	private void panelGenerate(){
		textArea.setEnabled(false);
		loginUser.setEnabled(false);
		chattingRoom.setEnabled(false);
		setVisible(true);
	}

}
