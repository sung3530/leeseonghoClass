import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import org.json.simple.JSONObject;

public class Client {
	private Socket socket;
	private String id;
	private int port;
	private String ip;
	private InputStream is;
	private DataInputStream dis;
	private OutputStream os;
	private DataOutputStream dos;
	private Message_Recieve Message_Recieve;
	private Room_GUI room_GUI;
	private JSONObject json_data=new JSONObject();
	public Client(String id,String ip,int port,Room_GUI room_GUI){
		this.id=id;
		this.ip=ip;
		this.port=port;
		this.room_GUI=room_GUI;
		network();
		start_client_connection();
	}
	public Socket getSocket(){
		return socket;
	}
	public Room_GUI getRoom_GUI(){
		return room_GUI;
	}
	public String getId(){
		return id;
	}
	private void network(){
		
		try {
			socket=new Socket(ip,port);
			if(socket!=null){
				connection();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "소켓 접속 에러", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	private void connection(){
		try{
		is=socket.getInputStream();
		dis=new DataInputStream(is);
		os=socket.getOutputStream();
		dos=new DataOutputStream(os);
		json_data.clear();
		json_data.put("code", "RoomList");
		dos.writeUTF(json_data.toJSONString());
		}
		catch (IOException e){
			JOptionPane.showMessageDialog(null, "스트림 에러", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	private void start_client_connection(){
		Message_Recieve=new Message_Recieve(socket,is,dis,os,dos,this);
		Message_Recieve.start();
		}
	public void send_JsonMessage(String code,String title,String id){
		json_data.clear();
		json_data.put("code", code);
		json_data.put("title", title);
		json_data.put("master", id);
		try {
			dos.writeUTF(json_data.toJSONString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Code:roomMake, send Error", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public void send_JsonMessage(String code,String body){
		json_data.clear();;
		json_data.put("code", code);
		json_data.put("body", body);
		try {
			dos.writeUTF(json_data.toJSONString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Code:snedMSG, send Error", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
