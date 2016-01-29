import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Json_Parse {
	private JSONObject json_Data=new JSONObject();
	private JSONParser parser = new JSONParser();
	private Room room;
	private JSONObject json_list;
	private String json_string;
	
	public void json_parsing(String json_string,Server_GUI Server_GUI,User user){

		try {
			json_Data=new JSONObject();
			json_Data=(JSONObject) parser.parse(json_string);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		code_check((String)json_Data.get("code"),json_string,Server_GUI,user);
		
	}
	private void code_check(String code,String json_string, Server_GUI Server_GUI,User user){
		
		switch (code) {
		case "msg":
			room.send_ToAll(json_string, Server_GUI);
			break;

		case "RoomMake":
			Room_Manager.getInstance().room_Make((String)json_Data.get("title"), (String)json_Data.get("master"),user);
			User_Manager.getInstance().send_ToAll(json_string, Server_GUI);
			break;

		case "RoomParticipate":
			room=Room_Manager.getInstance().room_Participate((String)json_Data.get("title"), (String)json_Data.get("master"),user);
			if(room==null){
				try {
					json_Data=new JSONObject();
					json_Data.put("code", "no");
					user.getDataOutputStream().writeUTF(json_Data.toJSONString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				try {
				json_Data=new JSONObject();
				json_Data.put("code", "yes");
				user.getDataOutputStream().writeUTF(json_Data.toJSONString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
			
		case "RoomList" :
			json_list=new JSONObject();
			json_list=Room_Manager.getInstance().getRoomList();
			
			json_string=json_list.toJSONString();
			//User_Manager.getInstance().sendAll(json_string, Server_GUI);
			try {
				user.getDataOutputStream().writeUTF(json_string);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case "OTO":
			
			break;
		}
		
	}
}
