package remakeChatting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import remakeChatting.Client.clientGui;
import remakeChatting.server.serverGui;

public class login_controller implements ActionListener{
	private loginGui loginGui;
	
	public login_controller(loginGui loginGui){
		this.loginGui=loginGui;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(loginGui.getButton()[0])){
			clientGui cg=new clientGui(loginGui.getJTextField()[0].getText(), loginGui.getJTextField()[1].getText(), Integer.parseInt(loginGui.getJTextField()[2].getText()));
		}
		else if(e.getSource().equals(loginGui.getButton()[1])){
			serverGui sg=new serverGui();
		}
	}

}
