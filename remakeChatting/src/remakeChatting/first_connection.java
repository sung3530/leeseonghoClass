package remakeChatting;

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
	private give_connection give_connection;
	private send sendMessage=new send();
	
	
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
				
				user_info user=new user_info();
				user.setSocket(socket);
				user.setSendClass(sendMessage);
				user.setServerGui(server_Gui);
				user.user_Network();
				vc.add(user);

				
				//user_Info user=new user_Info(socket,ta,vc,userArray);
				//vc.add(user);
				//user.start();
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
