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
				String message = dis.readUTF();//송신올떄까지 무한정 대기
				sendMessage.send_Allpeople(message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				try {
					dos.close();
					dis.close();
					User_socket.close();
					//vc.removeElement( this ); // 에러가난 현재 객체를 벡터에서 지운다
					//server_gui.getTextArea().append(vc.size() +" : 현재 벡터에 담겨진 사용자 수\n");
					//server_gui.getTextArea().append("사용자 접속 끊어짐 자원 반납\n");
					break;
				
				} catch (Exception ee) {
					if(ee.getCause()==null){
						System.out.println("sss");
						break;
					}
				}// catch문 끝
			}
		}
		
		
	}
}
