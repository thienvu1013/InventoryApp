package Client.Controller;

import java.io.IOException;
import java.net.Socket;

import Model.Deserializer;
import Model.Message;
import Model.Serializer;

public class ClientController {
	
	private Socket theSocket;
	private Serializer serializer;
	private Deserializer deserializer;
	private Message theMessage = null;
	public ClientController(String serverName, int hostNumber) {
		try {
			Socket theSocket = new Socket(serverName, hostNumber);
			serializer = new Serializer(theSocket);
			deserializer = new Deserializer(theSocket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to connect to server");
			e.getMessage();
		}
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
	public Serializer getSerializer() {
		return serializer;
	}
	public void setSerializer(Serializer serializer) {
		this.serializer = serializer;
	}
	public Deserializer getDeserializer() {
		return deserializer;
	}
	public void setDeserializer(Deserializer deserializer) {
		this.deserializer = deserializer;
	}
	public Message getTheMessage() {
		return theMessage;
	}
	public void setTheMessage(Message theMessage) {
		this.theMessage = theMessage;
	}
	
	
	
	
	
	
	

}
