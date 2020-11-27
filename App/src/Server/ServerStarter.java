package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Server.Controller.CustomerController;
import Server.Controller.DBController;
import Server.Controller.InventoryController;
import Server.Controller.ModelController;
import Server.Controller.ServerController;

public class ServerStarter {
	private static ServerStarter server;
	private ServerSocket serverSocket;
	private ExecutorService executorService = Executors.newFixedThreadPool(10);
	

	public static void main(String[] args) {
		
		
		server = new ServerStarter();
		server.runServer();
		System.out.println("Server is now running");


	}
	
	private void runServer() {
		int portNumber = 9090;
		try {
			serverSocket = new ServerSocket(portNumber);
			
			while(true) {
				Socket s = serverSocket.accept();
				ServerController serverCtrl = new ServerController();
				DBController dbCtrl = new DBController();
				CustomerController custCtrl = new CustomerController(dbCtrl);
				InventoryController invCtrl = new InventoryController(dbCtrl);
				executorService.submit(new ModelController(s,serverCtrl, dbCtrl,custCtrl,invCtrl));
			}
		} catch (IOException e) {
			System.out.println("Error accepting connections");
			e.printStackTrace();
		}
		
	}

}
