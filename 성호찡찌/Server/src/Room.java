import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Room {
	private Vector userList=new Vector();
	private String title;
	private String master;
	private JSONObject json_list;
	private JSONArray json_Array;
	
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
	public JSONObject getUserList(){
		json_list=new JSONObject();
		json_Array=new JSONArray();
		json_list.put("code", "userList");
		for (int i = 0; i < userList.size(); i++) {
			User user=(User)userList.elementAt(i);
			json_Array.add(user.getId());
		}
		json_list.put("list", json_Array);
		return json_list;
	}
	
	public void send_ToAll(String body, Server_GUI Server_GUI){
		for (int i = 0; i < userList.size(); i++) {
			User user=(User)userList.elementAt(i);
			user.send_Message(body);
		}
	}
	public void send_ToAll_exceptionMe(String body, Server_GUI Server_GUI,User me){
		for (int i = 0; i < userList.size(); i++) {
			User user=(User)userList.elementAt(i);
			if(me.getDataOutputStream()!=user.getDataOutputStream()){
			user.send_Message(body);
			}
		}
	}
	
	
	
	
}
