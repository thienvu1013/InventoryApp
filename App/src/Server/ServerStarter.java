package Server;

import Server.Controller.CustomerController;
import Server.Controller.DBController;
import Server.Controller.InventoryController;
import Server.Controller.ModelController;
import Server.Controller.ServerController;

public class ServerStarter {

	public static void main(String[] args) {
		int portNumber = 9090;
		
		ServerController serverCtrl = new ServerController();
		DBController dbCtrl = new DBController();
		CustomerController custCtrl = new CustomerController(dbCtrl);
		InventoryController invCtrl = new InventoryController(dbCtrl);
		ModelController modelCtrl = new ModelController(portNumber, serverCtrl, dbCtrl,custCtrl,invCtrl);
		modelCtrl.runServer();
		System.out.println("Server is now running");


	}

}
