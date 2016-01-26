package remakeChatting.Client;

public class parsing {
	private String[] dv;
	
	public parsing(){
		
	}
	
	public void parsingString(String msg){
		dv=msg.split("@");
	}
	
	public void divideCode(clientGui cg){
		switch (dv[0]) {
		case "msg":
			cg.getTextArea().append(dv[1]+"\n");
			
			break;

		case "roomList":
			
			break;
		case "userList":
			
			break;
		case "oto" :
			
			break;
		}
	}
}
