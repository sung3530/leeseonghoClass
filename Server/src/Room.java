import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Vector;


public class Room {
	private Vector userList=new Vector();
	private String title;
	private String master;
	
	public Room(String title,String master,User user){
		this.title=title;
		this.master=master;
	}
	
	public String getTitle(){
		return title;
	}
	public String getMaster(){
		return master;
	}
	public int getUser_Number(){
		return this.userList.size();
	}
	public void plusUser(User user){
		userList.add(user);
	}
	
	public void send_ToAll(String body, Server_GUI Server_GUI){
		for (int i = 0; i < userList.size(); i++) {
			User user=(User)userList.elementAt(i);
			user.send_Message(body);
		}
	}
	
	
	
	
}
