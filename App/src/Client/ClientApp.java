package Client;


import Client.Controller.ClientController;
import Client.Controller.CustomerViewController;
import Client.Controller.InventoryViewController;
import Client.Controller.LoginController;
import Client.Controller.ModelController;
import Client.View.CustomerGUI;
import Client.View.InventoryGUI;
import Client.View.LoginGUI;

public class ClientApp {

	public static void main(String[] args) {
		int portNumber = 9090;
		String serverName = "localhost";
		CustomerGUI custView = new CustomerGUI();
		InventoryGUI invView = new InventoryGUI();
		LoginGUI logView = new LoginGUI();
		ClientController clientCtrl = new ClientController(serverName,portNumber);
		ModelController modelCtrl = new ModelController(clientCtrl);
		CustomerViewController custCtrl = new CustomerViewController(custView,modelCtrl);
		LoginController logCtrl = new LoginController(logView,modelCtrl);
		InventoryViewController invCtrl = new InventoryViewController(invView,modelCtrl);
		logCtrl.startApp(custCtrl,invCtrl);

	}

}
