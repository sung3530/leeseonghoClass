package remakeChatting;

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

public class clientGui extends JFrame implements ActionListener, KeyListener{
	private	JPanel ChattingJpanel=new JPanel();
	private	JTextField sendTextField=new JTextField();
	private	JScrollPane scrollPane = new JScrollPane();
	private	JTextArea textArea=new JTextArea();
	private JTextArea loginUser=new JTextArea();
	private	JButton jb=new JButton();
	private String id;
	private String ip;
	private int port;
	public clientGui(String id, String ip, int port){
		this.id=id;
		this.ip=ip;
		this.port=port;
		
		panelReSize();
		sendTextFieldGenerate();
		textAreaGenerate();
		buttonGenerate();
		panelGenerate();
	}
	private void panelReSize(){
		setBounds(100, 100, 425, 385);
		ChattingJpanel = new JPanel();
		ChattingJpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ChattingJpanel);
		ChattingJpanel.setLayout(null);
		
	}
	private void sendTextFieldGenerate(){
		sendTextField=new JTextField();
		sendTextField.setBounds(105, 300, 170, 40);
		sendTextField.setColumns(5);
		ChattingJpanel.add(sendTextField);
		sendTextField.addKeyListener(this);
	}
	private void textAreaGenerate(){
		textArea=new JTextArea();
		loginUser=new JTextArea();
		scrollPane.setBounds(105, 0, 300, 300);
		loginUser.setBounds(5,0,95,200);
		ChattingJpanel.add(scrollPane);
		ChattingJpanel.add(loginUser);
		scrollPane.setViewportView(textArea);
	}
	private void buttonGenerate(){
		jb=new JButton("Send");
		jb.setBounds(285, 300, 115, 42);
		ChattingJpanel.add(jb);
		jb.addActionListener(this);
	}
	private void panelGenerate(){
		textArea.setEnabled(false);
		loginUser.setEnabled(false);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/*if(e.getSource().equals(jb)){
			c.send_message(sendTextField.getText());
			sendTextField.setText("");
			sendTextField.requestFocus();
		}*/
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		/*if(e.getKeyCode()==10){//엔터키 눌렀을시 텍스트 보내기.
			c.send_message(sendTextField.getText());
			sendTextField.setText("");
			sendTextField.requestFocus();
		}*/
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
