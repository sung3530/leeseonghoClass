import java.util.Iterator;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Json_Parsing {
	private JSONObject json_Data=new JSONObject();
	private JSONArray Json_temp=new JSONArray();
	private JSONParser parser=new JSONParser();
	private JSONObject JSONTEMP=new JSONObject();
	private Message_Recieve Message_Recieve;
	private Client_GUI client_GUI;
	private Object[][] data=new Object[50][3];
	private Object[][] listdata;
	public Json_Parsing(Message_Recieve Message_Recieve){
		this.Message_Recieve=Message_Recieve;
	}
	
	public void json_parse(String json_String){
		try {
			json_Data.clear();
			json_Data=(JSONObject) parser.parse(json_String);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		code_Check((String)json_Data.get("code"),json_String);
	}
	
	private void code_Check(String code,String json_String){
		switch (code) {
		case "RoomMake":
			String[] temp=new String[3];
			temp[0]=(String) json_Data.get("title");
			temp[1]=(String) json_Data.get("master");
			temp[2]="1";
			Object[][] data=new Object[1][3];
			data[0][0]=temp[0];
			data[0][1]=temp[1];
			data[0][2]=temp[2];
			Message_Recieve.getRoom_GUI().addTable(data);
		
			break;

		case "no" :
			JOptionPane.showMessageDialog(null, "방을 못 찾는중 또는 5명 넘음", "Error", JOptionPane.INFORMATION_MESSAGE);
			break;
		case "yes" :
			Message_Recieve.getRoom_GUI().removeAll();
			client_GUI=new Client_GUI(Message_Recieve.getClient());
			break;
		case "msg" :
			client_GUI.getTextArea().append((String)json_Data.get("body")+"\n");
			break;
		case "RoomList" :
			listdata=new Object[50][3];
			Json_temp= (JSONArray) json_Data.get("list");
			Iterator it=Json_temp.iterator();
			int i=0;
			while(it.hasNext()){
				JSONTEMP=(JSONObject)it.next();
				listdata[i][0]=JSONTEMP.get("title");
				listdata[i][1]=JSONTEMP.get("master");
				listdata[i][2]=JSONTEMP.get("people");
				i++;
			}
			Message_Recieve.getRoom_GUI().resetTable(listdata);
			break;
		default:
			break;
		}
	}
}
