package remakeChatting.server;

public class parsing {
	private String[] dv;
	private server_recieve server_recieve;
	private send sendMessage=new send();
	private Room_Manager Room_Manager=new Room_Manager();
	public parsing(server_recieve server_recieve){
		this.server_recieve=server_recieve;
	}
	public void parsingString(String msg){
		dv=msg.split("@");
	}
	
	public void divideCode(user user){
		switch (dv[0]) {
		case "send":
			sendMessage.send_Allpeople(dv[1],server_recieve.getServerGui());
			break;

		case "roomMake" :
			Room_Manager.room_Make(dv, user);
			break;
		case "roomParticipate" :
			Room_Manager.room_Participate(dv[1],dv[2], user);
			break;	
		case "oto" :
			sendMessage.send_Allpeople(dv[1],server_recieve.getServerGui());
			break;
		default:
			
			break;
		}
	}
}
