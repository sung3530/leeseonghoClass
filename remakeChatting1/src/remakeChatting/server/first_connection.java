package remakeChatting.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class first_connection extends Thread{
	
	private serverGui server_Gui;
	private ServerSocket serverSocket;
	private Socket socket;
	private Vector vc=new Vector();
	private server_recieve give_connection;
	private send sendMessage=new send();
	private user_manager user_manager=new user_manager();
	
	
	public first_connection(serverGui serverGui){
		
		this.server_Gui=serverGui;
		
	}
	
	public void setServerSocket(ServerSocket serverSocket){
		
		this.serverSocket=serverSocket;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			try {
				server_Gui.getTextArea().append("접속자 대기중...\n");
				socket=serverSocket.accept();
				server_Gui.getTextArea().append("사용잡 접속!\n");
				
				user_manager.setScocket(socket);
				user_manager.user_Generate(server_Gui);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				if(e.getCause()!=null){
					server_Gui.getTextArea().append("에러 발생.\n");
				}
				else if(e.getCause()==null){
					server_Gui.getTextArea().append("서버 종료로 인한 접속자 접속 대기 종료\n");
					break;
				}
			}
		}
	}
}
