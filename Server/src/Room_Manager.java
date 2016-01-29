import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Room_Manager {
	public static Room_Manager Room_Manager=new Room_Manager();
	private JSONObject list = new JSONObject();
	private JSONArray AllList = new JSONArray();
	private JSONObject sendList=new JSONObject();
	private Vector roomList=new Vector();
	
	public static Room_Manager getInstance(){
		return Room_Manager;
	}
	
	public Room room_Make(String title,String master,User user){
		Room room=new Room(title,master,user);
		roomList.add(room);
		return room;
	}
	
	public Room room_Participate(String title, String master,User user){
		
		for (int i = 0; i < roomList.size(); i++) {
			
			Room room=(Room)roomList.elementAt(i);
			if(room.getTitle().equals(title)&&room.getMaster().equals(master)&&room.getUser_Number()<5){
				room.plusUser(user);
				return room;
			}
		}
		return null;
		
	}
	public JSONObject getRoomList(){
		sendList=new JSONObject();
		AllList=new JSONArray();
		for (int i = 0; i < roomList.size(); i++) {
			list=new JSONObject();
			Room room=(Room)roomList.elementAt(i);
			list.put("title", room.getTitle());
			list.put("master", room.getMaster());
			list.put("people", room.getUser_Number());
			AllList.add(list);
		}
		sendList.put("code", "RoomList");
		sendList.put("list", AllList);
		return sendList;
	}
	
	public void room_Check(){
		
	}
}
