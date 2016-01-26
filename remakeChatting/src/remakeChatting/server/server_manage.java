package remakeChatting.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server_manage {
	
	private serverGui server_Gui;
	private ServerSocket serverSocket;
	private first_connection first_connection;
	private int port;
	

	public server_manage(serverGui server_Gui){
		this.server_Gui=server_Gui;
		first_connection=new first_connection(server_Gui);
		
	}
	
	public void setPort(int port){
		this.port=port;
	}
	
	public void serverStart(){
		try {
			serverSocket=new ServerSocket(port);
			if(serverSocket!=null){
				server_Gui.getButton()[0].setText("���� ������\n");
				server_Gui.getButton()[0].setEnabled(false);
				first_connection.setServerSocket(serverSocket);
				first_connection.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			server_Gui.getTextArea().append("������ �̹� ������Դϴ�...\n");
		}
	}
	
	public void serverStop(){
		try {
			serverSocket.close();
			server_Gui.getButton()[0].setText("Connection");
			server_Gui.getButton()[0].setEnabled(true);
			server_Gui.getTextArea().append("���� ����\n");
		
		
		} catch (IOException e) {
		// TODO Auto-generated catch block
			server_Gui.getTextArea().append("���� ���� ����\n");
			}
	}
}
