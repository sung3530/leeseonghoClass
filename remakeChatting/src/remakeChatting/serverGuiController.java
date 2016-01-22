package remakeChatting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class serverGuiController implements ActionListener {
	
	private serverGui server_Gui;
	private first_connection server_socket;
	private server_manage server_manage;
	
	
	public serverGuiController(serverGui gui){
		
		this.server_Gui=gui;
		this.server_manage=new server_manage(gui);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(server_Gui.getButton()[0])){
			this.server_manage.setPort(Integer.parseInt(server_Gui.getTextField().getText()));
			server_manage.serverStart();
		}
		
		else if(e.getSource().equals(server_Gui.getButton()[1])){
			server_manage.serverStop();
		}
	}
}
