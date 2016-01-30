import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Controller implements ActionListener{
	private Server_GUI Server_GUI;
	private Server_Manager Server_Manager=new Server_Manager(this);

	public GUI_Controller(Server_GUI gui){
		
		this.Server_GUI=gui;
		
	}
	
	public Server_GUI getServer_GUI(){
		return Server_GUI;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(Server_GUI.getButton()[0])){
			this.Server_Manager.setPort(Integer.parseInt(Server_GUI.getTextField().getText()));
			Server_Manager.serverStart();
		}
		
		else if(e.getSource().equals(Server_GUI.getButton()[1])){
			Server_Manager.serverStop();
		}
	}
}
