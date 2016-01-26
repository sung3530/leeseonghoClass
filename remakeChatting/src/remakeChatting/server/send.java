package remakeChatting.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

import remakeChatting.Client.clientGui;

public class send {
	private Vector vc;
	
	public void setVector(Vector vc){
		this.vc=vc;
	}
	public Vector getVector(){
		return vc;
	}
	public void send_Allpeople(String str, serverGui serverGui){
		for (int i = 0; i < vc.size(); i++) {
			user ui=(user)vc.elementAt(i);
			send_message(str,ui.getDataOutputStream(),serverGui);
		}
	}
	public void send_message(String msg,DataOutputStream dos,serverGui serverGui){
		try {
			dos.writeUTF(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			serverGui.getTextArea().append("메시지송신에러 \n");
		}
	}
	public void send_message(String msg,DataOutputStream dos,clientGui clientGui){
		try {
			dos.writeUTF(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			clientGui.getTextArea().append("메시지송신에러 \n");
		}
	}
}
