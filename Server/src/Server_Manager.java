import java.io.IOException;
import java.net.ServerSocket;

public class Server_Manager {
	private GUI_Controller GUI_Controller;
	private ServerSocket serverSocket;
	private User_Reciever User_Reciever=new User_Reciever(this);
	private int port;
	

	public Server_Manager(GUI_Controller GUI_Controller){
		this.GUI_Controller=GUI_Controller;
		
	}
	public Server_GUI getServer_GUI(){
		return GUI_Controller.getServer_GUI();
	}
	
	public void setPort(int port){
		this.port=port;
	}
	
	public void serverStart(){
		try {
			serverSocket=new ServerSocket(port);
			if(serverSocket!=null){
				GUI_Controller.getServer_GUI().getButton()[0].setText("서버 실행중\n");
				GUI_Controller.getServer_GUI().getButton()[0].setEnabled(false);
				User_Reciever.setServerSocket(serverSocket);
				User_Reciever.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			GUI_Controller.getServer_GUI().getTextArea().append("소켓이 이미 사용중입니다...\n");
		}
	}
	
	public void serverStop(){
		try {
			serverSocket.close();
			GUI_Controller.getServer_GUI().getButton()[0].setText("Connection");
			GUI_Controller.getServer_GUI().getButton()[0].setEnabled(true);
			GUI_Controller.getServer_GUI().getTextArea().append("서버 종료\n");
		
		
		} catch (IOException e) {
		// TODO Auto-generated catch block
			GUI_Controller.getServer_GUI().getTextArea().append("서버 중지 실패\n");
			}
	}
}
