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
				Server_Manager.getServer_GUI().getTextArea().append("������ �����...\n");
				socket=serverSocket.accept();
				Server_Manager.getServer_GUI().getTextArea().append("����� ����!\n");
				
				User_Manager.getInstance().user_Generate(socket,Server_Manager.getServer_GUI());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				if(e.getCause()!=null){
					Server_Manager.getServer_GUI().getTextArea().append("���� �߻�.\n");
				}
				else if(e.getCause()==null){
					Server_Manager.getServer_GUI().getTextArea().append("���� ����� ���� ������ ���� ��� ����\n");
					break;
				}
			}
		}
	}
}
