package remakeChatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JTextArea;

public class user_info {
	private InputStream is;
	private DataInputStream dis;
	private OutputStream os;
	private DataOutputStream dos;
	private Socket User_socket;
	private Vector vc;
	private String id;
	private int i=0;
	private send sendMessage;
	private serverGui server_gui;
	private give_connection give_connection;
	
	public user_info(){
		
	}
	public void setSocket(Socket User_socket){
		this.User_socket=User_socket;
	}
	public void setSendClass(send sendMessage){
		this.sendMessage=sendMessage;
	}
	public void setServerGui(serverGui server_gui){
		this.server_gui=server_gui;
	}
	
	public Socket getSocket(){
		return User_socket;
	}
	public String getId(){
		return id;
	}
	
	public void user_Network(){
		try{
			is=User_socket.getInputStream();
			dis=new DataInputStream(is);
			os=User_socket.getOutputStream();
			dos=new DataOutputStream(os);
			
			sendMessage.setInputStream(is);
			sendMessage.setDataInputStream(dis);
			sendMessage.setOutputStream(os);
			sendMessage.setDataOutputStream(dos);
			
			id=dis.readUTF();
		
			sendMessage.send_message(id+" 정상 접속 완료.\n");
			sendMessage.send_Allpeople(id+"님이 들어오셨습니다.\n");
			this.give_connection=new give_connection();
			this.give_connection.setSendClass(sendMessage);
			this.give_connection.setServerGui(server_gui);
			this.give_connection.start();
			}
			catch (IOException e){
				server_gui.getTextArea().append("스트림 에러\n");
			}
		}
	
	/*public void user_Save(){
		i=0;
		while(true){
			if(userArray[i]==null){
				userArray[i]=id;
				break;
			}
			i++;
	}
	*/
}
