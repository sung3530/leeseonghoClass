import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.json.simple.JSONObject;

public class User {
	private InputStream is;
	private DataInputStream dis;
	private OutputStream os;
	private DataOutputStream dos;
	private Socket User_socket;
	private String id;
	private JSONObject json_Data=new JSONObject();
	private String Json_String;
	private Message_Reciever Message_Reciever;
	
	public String getId(){
		return id;
	}
	public DataOutputStream getDataOutputStream(){
		return dos;
	}
	public void user_Network(Socket User_socket,Server_GUI Server_GUI){
		this.User_socket=User_socket;
		try{
			is=User_socket.getInputStream();
			dis=new DataInputStream(is);
			os=User_socket.getOutputStream();
			dos=new DataOutputStream(os);
			
			this.Message_Reciever=new Message_Reciever(dis,dos,this,User_socket,Server_GUI);
			this.Message_Reciever.start();
			}
			catch (IOException e){
				Server_GUI.getTextArea().append("스트림 에러\n");
			}
		}
	public void send_Message(String body){
		try {
			dos.writeUTF(body);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Message_Reciever.getServer_GUI().getTextArea().append("메시지송신에러\n");
		}
	}
	
}
