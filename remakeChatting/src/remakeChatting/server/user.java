package remakeChatting.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

public class user {
	private InputStream is;
	private DataInputStream dis;
	private OutputStream os;
	private DataOutputStream dos;
	private Socket User_socket;
	private String id;
	private server_connection server_connection;
	
	public void setSocket(Socket User_socket){
		this.User_socket=User_socket;
	}

	public String getId(){
		return id;
	}
	public DataOutputStream getDataOutputStream(){
		return dos;
	}
	public void user_Network(send sendMessage,serverGui server_gui){
		try{
			is=User_socket.getInputStream();
			dis=new DataInputStream(is);
			os=User_socket.getOutputStream();
			dos=new DataOutputStream(os);
			
			id=dis.readUTF();
			sendMessage.send_message(id+" 정상 접속 완료.\n",dos,server_gui);
			sendMessage.send_Allpeople(id+"님이 들어오셨습니다.\n",server_gui);
			System.out.println("useruser");
			this.server_connection=new server_connection();
			this.server_connection.setSendClass(sendMessage);
			this.server_connection.setServerGui(server_gui);
			this.server_connection.setDatainputStream(dis);
			this.server_connection.setDataoutputStream(dos);
			this.server_connection.setSocket(User_socket);
			this.server_connection.start();
			}
			catch (IOException e){
				server_gui.getTextArea().append("스트림 에러\n");
			}
		}
}
