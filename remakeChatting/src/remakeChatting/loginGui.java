package remakeChatting;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class loginGui extends JFrame implements ActionListener {
	
	private	JPanel south=new JPanel();
	private	JPanel center=new JPanel();
	private JPanel[] textJPanel=new JPanel[3];
	private	String[] textTitle={"ID : ","IP : ","PORT : "};
	private	String[] button={"Log In","Server Conection"};
	private	JTextField[] tf=new JTextField[3];
	private	JLabel[] jl=new JLabel[3];
	private	JButton[] jb=new JButton[2];
		
		public loginGui(){
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
			for (int j = 0; j < button.length; j++) {
				jb[j]=new JButton(button[j]);
				south.add(jb[j]);
				jb[j].addActionListener(this);
			}
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
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			serverGui sg=new serverGui();
		}
		
}