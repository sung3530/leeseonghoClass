import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.ParseException;

import org.json.simple.JSONObject;

public class Message_Reciever extends Thread{
	private DataInputStream dis;
	private DataOutputStream dos;
	private Socket user_socket;
	private User user;
	private Server_GUI Server_GUI;
	private Json_Parse Json_Parse=new Json_Parse();
	
	public Message_Reciever(DataInputStream dis, DataOutputStream dos,User user,Socket user_socket,Server_GUI Server_GUI){
		this.dis=dis;
		this.dos=dos;
		this.user_socket=user_socket;
		this.user=user;
		this.Server_GUI=Server_GUI;
	}
	public Server_GUI getServer_GUI(){
		return Server_GUI;
	}
	public void run(){
		while(true){
			try {
				String message = dis.readUTF();//송신올떄까지 무한정 대기
				Json_Parse.json_parsing(message, Server_GUI,user);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				try {
					dos.close();
					dis.close();
					user_socket.close();
					User_Manager.getInstance().getUserList().removeElement(user);
					Server_GUI.getTextArea().append("사용자 접속 끊어짐 자원 반납\n");
					break;
				
				} catch (Exception ee) {
					if(ee.getCause()==null){
						Server_GUI.getTextArea().append("close Error");
						break;
					}
				}// catch문 끝
			}
		}
	}
}
