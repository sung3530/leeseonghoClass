package remakeChatting.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

public class client {
	private Socket socket;
	private String id;
	private int port;
	private String ip;
	private InputStream is;
	private DataInputStream dis;
	private OutputStream os;
	private DataOutputStream dos;
	private client_connection client_connection;
	
	public void client(){
	}
	public void setPort(int port){
		this.port=port;
	}
	public void setIp(String ip){
		this.ip=ip;
	}
	public void setId(String id){
		this.id=id;
	}
	public int getPort(){
		return port;
	}
	public String getIp(){
		return ip;
	}
	public String getId(){
		return id;
	}
	public InputStream getInputStream(){
		return is;
	}
	public DataInputStream getDataInputStream(){
		return dis;
	}
	public OutputStream getOutputStream(){
		return os;
	}
	public DataOutputStream getDataOutputStream(){
		return dos;
	}
	public Socket getSocket(){
		return socket;
	}
	public void network(clientGui cg){
		
		try {
			socket=new Socket(ip,port);
			if(socket!=null){
				connection(cg);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
			cg.getTextArea().append("소켓 접속 에러.\n");
		}
	}
	private void connection(clientGui cg){
		try{
		is=socket.getInputStream();
		dis=new DataInputStream(is);
		os=socket.getOutputStream();
		dos=new DataOutputStream(os);
		}
		catch (IOException e){
			cg.getTextArea().append("스트림 에러\n");
		}
	}
	public void start_client_connection(clientGui clientgui){
		client_connection=new client_connection(clientgui);
		client_connection.setDataInputStream(dis);
		client_connection.setDataOutputStream(dos);
		client_connection.setInputStream(is);
		client_connection.setOutputStream(os);
		client_connection.setSocket(socket);
		client_connection.start();
		}
}
