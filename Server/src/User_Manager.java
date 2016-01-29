import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Vector;

import org.json.simple.JSONObject;

public class User_Manager {
	
	public static User_Manager User_Manager=new User_Manager();
	private Vector User_List=new Vector();

	
	public static User_Manager getInstance(){
		return User_Manager;
	}
	
	public void user_Generate(Socket socket,Server_GUI Server_GUI){
		User user=new User();
		user.user_Network(socket,Server_GUI);
		User_List.add(user);
	}
	
	public Vector getUserList(){
		return User_List;
	}
	public void send_ToAll(String body, Server_GUI Server_GUI){
		for (int i = 0; i < User_List.size(); i++) {
			User user=(User)User_List.elementAt(i);
			user.send_Message(body);
		}
	}
	
}
