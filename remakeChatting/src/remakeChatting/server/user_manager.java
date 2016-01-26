package remakeChatting.server;

import java.net.Socket;
import java.util.Vector;

public class user_manager {

	private Vector vc=new Vector();
	private Socket socket;
	private send send_message=new send();;
	public user_manager(){
		send_message.setVector(vc);
	}
	public void setScocket(Socket socket){
		this.socket=socket;
	}
	public void user_Generate(serverGui server_gui){
		user user=new user();
		user.setSocket(socket);
		user.user_Network(send_message,server_gui);
		vc.add(user);
		
	}
}
