package remakeChatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

public class send {
	private InputStream is;
	private DataInputStream dis;
	private OutputStream os;
	private DataOutputStream dos;
	private Vector vc=new Vector();
	
	public void setInputStream(InputStream is){
		this.is=is;
	}
	public void setDataInputStream(DataInputStream dis){
		this.dis=dis;
	}
	public void setOutputStream(OutputStream os){
		this.os=os;
	}	
	public void setDataOutputStream(DataOutputStream dos){
		this.dos=dos;
	}
	public void setVector(Vector vc){
		this.vc=vc;
	}
	
	
	public void send_Allpeople(String str){
		for (int i = 0; i < vc.size(); i++) {
			user_info ui=(user_info)vc.elementAt(i);
			send_message(ui.getId()+" : "+str);
		}
	}
	public void send_message(String msg){
		try {
			dos.writeUTF(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		//ta.append("메시지송신에러 \n");
		}
	}
}
