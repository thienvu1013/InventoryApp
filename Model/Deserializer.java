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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return theMessage;
		
	}
	
	public void closeStream() {
		try {
			objectIn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
