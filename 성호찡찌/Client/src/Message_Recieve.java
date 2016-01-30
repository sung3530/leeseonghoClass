import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JTextArea;

public class Message_Recieve extends Thread {
	private Socket socket;
	private InputStream is;
	private DataInputStream dis;
	private OutputStream os;
	private DataOutputStream dos;
	private JTextArea ja;
	private Json_Parsing json_parsing=new Json_Parsing(this);
	private Client client;
	//private parsing parsing=new parsing();
	
	public Message_Recieve(Socket socket,InputStream is, DataInputStream dis,OutputStream os,DataOutputStream dos,Client client){
		this.socket=socket;
		this.is=is;
		this.dis=dis;
		this.os=os;
		this.dos=dos;
		this.client=client;
	}
	public Room_GUI getRoom_GUI(){
		return client.getRoom_GUI();
	}
	public Client getClient(){
		return client;
	}
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				String msg = dis.readUTF();//�����κ��� �޼����ö����� ������ ���
				json_parsing.json_parse(msg);
				//parsing.parsingString(msg);
				//parsing.divideCode(cg);
				//cg.getTextArea().append(msg+"\n");
				//userTextArea();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				try {
					os.close();
					is.close();
					dos.close();
					dis.close();
					socket.close();
					break; // ���� �߻��ϸ� while�� ����
				} catch (IOException e1) {
				}
			}//error ó��
		}//while��
	}
}
