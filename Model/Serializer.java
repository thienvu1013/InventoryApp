package Model;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Serializer {
	private ObjectOutputStream objectOut;
	
	public Serializer(Socket theSocket) {
		try {
			objectOut = new ObjectOutputStream(theSocket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void write(Message theMessage) {
		try {
			objectOut.writeObject(theMessage);
			objectOut.flush();
			objectOut.reset();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void close() {
		try {
			objectOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
