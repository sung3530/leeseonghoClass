import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login_GUI extends JFrame implements ActionListener {
	private	JPanel south=new JPanel();
	private	JPanel center=new JPanel();
	private JPanel[] textJPanel=new JPanel[3];
	private	String[] textTitle={"ID : ","IP : ","PORT : "};
	private	String button="Log In";
	private	JTextField[] tf=new JTextField[3];
	private	JLabel[] jl=new JLabel[3];
	private	JButton jb=new JButton();
	
		public Login_GUI(){
			super("Chatting LogIn System");
			textFieldGenerate();
			buttonGenerate();
			guiGenerate();
		}
		private void textFieldGenerate(){
			for (int i = 0; i < textTitle.length; i++) {
				jl[i]=new JLabel(textTitle[i]);
				tf[i]=new JTextField(15);
				textJPanel[i]=new JPanel();
				textJPanel[i].add(jl[i]);
				textJPanel[i].add(tf[i]);
				center.add(textJPanel[i]);
			}
		}
		private void buttonGenerate(){
				jb=new JButton(button);
				south.add(jb);
				jb.addActionListener(this);
	
		}
		private void guiGenerate(){
			add(center,BorderLayout.CENTER);
			add(south,BorderLayout.SOUTH);
			setBounds(300,300,300,220);
			setVisible(true);
			tf[1].setText("127.0.0.1");
			tf[2].setText("8000");
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Room_GUI room_GUI=new Room_GUI(tf[0].getText(), tf[1].getText(), Integer.parseInt(tf[2].getText()));
			
		}
}
