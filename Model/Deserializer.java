package Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;


public class Deserializer {
	private ObjectInputStream objectIn;
	private Message theMessage;
	
	public Deserializer(Socket theSocket) {
		try {
			objectIn = new ObjectInputStream(theSocket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Message read() {
		try {
			theMessage = (Message) objectIn.readObject();
		} catch (ClassNotFoundException e) {
			
			System.out.println("class not found");
		} catch (IOException e) {
			theMessage = new Message();
			theMessage.setAction(-1);
		}
		return theMessage;
		
	}
	
	public void close() {
		try {
			objectIn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
