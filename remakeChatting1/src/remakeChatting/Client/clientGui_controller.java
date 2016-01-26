package remakeChatting.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import remakeChatting.server.send;

public class clientGui_controller implements ActionListener,KeyListener{

	private clientGui clientgui;
	private client client;
	private send send_message;
	
	public clientGui_controller(clientGui cg){
		this.clientgui=cg;
		send_message=new send();
		generate_client(cg);
	}
	public clientGui getClientGui(){
		return clientgui;
	}
	public void generate_client(clientGui cg){
		client=new client();
		client.setId(cg.getId());
		client.setIp(cg.getIp());
		client.setPort(cg.getPort());
		client.network(cg);
		client.start_client_connection(cg);
		send_message.send_message(cg.getId(),client.getDataOutputStream(),clientgui);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(clientgui.getButton())){
			System.out.println(client.getId());
		send_message.send_message("msg@"+client.getId()+":"+clientgui.getTextField().getText(),client.getDataOutputStream(),clientgui);
		clientgui.getTextField().setText("");
		clientgui.getTextField().requestFocus();
	}
		else if(e.getSource().equals(clientgui.getRoom_make())){
			
		}
		else if(e.getSource().equals(clientgui.getRoom_participate())){
			
			
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==10){//엔터키 눌렀을시 텍스트 보내기.
			send_message.send_message(clientgui.getTextField().getText(),client.getDataOutputStream(),clientgui);
			clientgui.getTextField().setText("");
			clientgui.getTextField().requestFocus();
	}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/*public void userTextArea(){
		user_TextArea.setText("");
		user_TextArea.append("접속자 명단 \n");
		for (int i = 0; i < server.userArray.length; i++) {
			if(server.userArray[i]!=null)
			user_TextArea.append(server.userArray[i]+"\n");
		}
	
	}
	*/
}
