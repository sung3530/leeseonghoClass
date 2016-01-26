package remakeChatting.server;

import java.util.Vector;

public class Room {
	private String title;
	private String maker;
	private Vector userList=new Vector();
	
	public Room(String title,String maker,user user){
		this.title=title;
		this.maker=maker;
	}
	public String getTitle(){
		return this.title;
	}
	public String getMaker(){
		return this.maker;
	}
	
	public int check_people(){
		return userList.size();
	}
	
	public void participate(user user){
		userList.add(user);
	}
}
