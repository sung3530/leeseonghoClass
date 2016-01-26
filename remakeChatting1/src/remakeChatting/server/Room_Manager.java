package remakeChatting.server;

import java.util.Vector;

public class Room_Manager {
	public static Vector roomList=new Vector();
	private Room room;
	
	public void room_Make(String[] dv,user user){
		Room room = new Room(dv[1],dv[2],user);
		roomList.add(room);
	}
	
	public void room_Participate(String title, String maker,user user){
		for (int i = 0; i < roomList.size(); i++) {
			room= (Room)roomList.elementAt(i);
			if(this.room.getTitle()==title&&this.room.getMaker()==maker&&this.room.check_people()<6){//title, maker, 방 인원이 6명미만이여야 점속가능.
				this.room.participate(user);
			}
				
		}
	}
}
