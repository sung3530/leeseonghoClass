package remakeChatting.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JTextArea;

public class client_connection extends Thread {
	private Socket socket;
	private InputStream is;
	private DataInputStream dis;
	private OutputStream os;
	private DataOutputStream dos;
	private JTextArea ja;
	private clientGui cg;
	public void setSocket(Socket socket){
		this.socket=socket;
	}
	public void setInputStream(InputStream is){
		this.is=is;
	}
	public void setDataInputStream(DataInputStream dis){
		this.dis=dis;
	}
	public void setOutputStream(OutputStream os){
		this.os=os;
	}
	public void setDataOutputStream(DataOutputStream DataOutputStream){
		this.dos=dos;
	}
	public void setTextArea(JTextArea textarea){
		this.ja=textarea;
	}
	public client_connection(clientGui cg){
		this.cg=cg;
	}
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				String msg = dis.readUTF();//서버로부터 메세지올때까지 무한정 대기
				cg.getTextArea().append(msg+"\n");
				//userTextArea();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				try {
					os.close();
					is.close();
					dos.close();
					dis.close();
					socket.close();
					break; // 에러 발생하면 while문 종료
				} catch (IOException e1) {
				}
			}//error 처리
		}//while문
	}
}
