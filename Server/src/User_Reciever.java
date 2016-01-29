import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class User_Reciever extends Thread{
	private Server_Manager Server_Manager;
	private ServerSocket serverSocket;
	private Socket socket;
	
	
	public User_Reciever(Server_Manager Server_Manager){
		this. Server_Manager=Server_Manager;
	}
	
	public void setServerSocket(ServerSocket serverSocket){
		
		this.serverSocket=serverSocket;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			try {
				Server_Manager.getServer_GUI().getTextArea().append("접속자 대기중...\n");
				socket=serverSocket.accept();
				Server_Manager.getServer_GUI().getTextArea().append("사용잡 접속!\n");
				
				User_Manager.getInstance().user_Generate(socket,Server_Manager.getServer_GUI());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				if(e.getCause()!=null){
					Server_Manager.getServer_GUI().getTextArea().append("에러 발생.\n");
				}
				else if(e.getCause()==null){
					Server_Manager.getServer_GUI().getTextArea().append("서버 종료로 인한 접속자 접속 대기 종료\n");
					break;
				}
			}
		}
	}
}
