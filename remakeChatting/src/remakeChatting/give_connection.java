package remakeChatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class give_connection extends Thread {
	private InputStream is;
	private DataInputStream dis;
	private OutputStream os;
	private DataOutputStream dos;
	private Socket User_socket;
	private send sendMessage;
	private serverGui server_gui;
	
	
	public void setSendClass(send sendMessage){
		this.sendMessage=sendMessage;
	}
	public void setServerGui(serverGui server_gui){
		this.server_gui=server_gui;
	}
	
	public void run(){
		while(true){
			try {
				String message = dis.readUTF();//�۽ſË����� ������ ���
				sendMessage.send_Allpeople(message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				try {
					dos.close();
					dis.close();
					User_socket.close();
					//vc.removeElement( this ); // �������� ���� ��ü�� ���Ϳ��� �����
					//server_gui.getTextArea().append(vc.size() +" : ���� ���Ϳ� ����� ����� ��\n");
					//server_gui.getTextArea().append("����� ���� ������ �ڿ� �ݳ�\n");
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
