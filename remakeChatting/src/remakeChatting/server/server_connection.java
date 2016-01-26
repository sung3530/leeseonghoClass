package remakeChatting.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class server_connection extends Thread {
	private DataInputStream dis;
	private DataOutputStream dos;
	private Socket User_socket;
	private send sendMessage;
	private serverGui server_gui;
	
	public void setDatainputStream(DataInputStream dis){
		this.dis=dis;
	}
	public void setDataoutputStream(DataOutputStream dos){
		this.dos=dos;
	}
	public void setSendClass(send sendMessage){
		this.sendMessage=sendMessage;
	}
	public void setServerGui(serverGui server_gui){
		this.server_gui=server_gui;
	}
	public void setSocket(Socket User_socket){
		this.User_socket=User_socket;
	}
	
	public void run(){
		while(true){
			try {
				String message = dis.readUTF();//�۽ſË����� ������ ���
				sendMessage.send_Allpeople(message,server_gui);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				try {
					dos.close();
					dis.close();
					User_socket.close();
					//sendMessage.getVector().removeElement( this ); // �������� ���� ��ü�� ���Ϳ��� �����
					server_gui.getTextArea().append("����� ���� ������ �ڿ� �ݳ�\n");
					break;
				
				} catch (Exception ee) {
					if(ee.getCause()==null){
						System.out.println("sss");
						break;
					}
				}// catch�� ��
			}
		}
		
		
	}
}
