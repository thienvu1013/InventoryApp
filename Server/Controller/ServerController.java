package Server.Controller;
import java.net.Socket;

import Model.Deserializer;
import Model.Message;
import Model.Serializer;


public class ServerController {
	private Serializer serializer;
	private Deserializer deserializer;
	private Message theMessage;
	private Socket theSocket;

	
	
	public ServerController() {
	}
	
	
	public void setup(Socket theSocket) {
		serializer = new Serializer(theSocket);
		deserializer = new Deserializer(theSocket);
		theMessage = null;
		
	}
	
	public Message recieveMessage() {
		theMessage = deserializer.read();
		return theMessage;
	}
	
	public void sendMessage(Message message) {
		serializer.write(message);
	}



	public Socket getTheSocket() {
		return theSocket;
	}



	public void setTheSocket(Socket theSocket) {
		this.theSocket = theSocket;
	}
}
