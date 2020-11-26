package Server.Controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Model.Message;
import Model.UserCredential;

public class ModelController implements Runnable {
	private CustomerController custCtrl;
	private InventoryController invCtrl;
	private Socket clientSocket;
	private ServerSocket serverSocket;
	private ExecutorService pool;
	private ServerController serverCtrl;
	private DBController dbCtrl;
	boolean isRunning = true;
	private Message inMessage;
	private Message outMessage;
	
	public ModelController(int portNumber,ServerController srvCtrl, DBController dbCtrl, CustomerController cc, InventoryController ic) {
		try {
			serverSocket = new ServerSocket(portNumber);
			this.serverCtrl = srvCtrl;
			this.dbCtrl = dbCtrl;
			this.setCustCtrl(cc);
			this.setInvCtrl(ic);
			setPool(Executors.newFixedThreadPool(2));
		} catch (IOException e) {
			System.out.println("Server failed");
			e.printStackTrace();
		}
	}
	
	public void runServer() {
		try {
			while(true) {
				setClientSocket(serverSocket.accept());
				serverCtrl.setup(clientSocket);
				pool.execute(this);
				
			}
		} catch (IOException e) {
			System.out.println("Client terminating");
			
		}
	}


	@Override
	public void run() {
		try {
			while(isRunning) {
				inMessage = serverCtrl.recieveMessage();
				if(inMessage.getAction()==-1) {
					break;
				}
				else if (inMessage != null) {
					actionCase(inMessage);
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			System.out.println("Client Terminate");
			serverCtrl.closeClient();
		}
	}
	
	public void actionCase(Message message){
		String controller = message.getController();
		int choice = message.getAction();
		if (controller== null) {
			switch (choice) {
			//if no controller specified then it is for verifying user
			case 1:
				String username = ((UserCredential)message.getObject()).getUsername();
				String password = new String(((UserCredential)message.getObject()).getPassword());
				boolean valid = dbCtrl.verify(username,password);
				outMessage = new Message();
				if (valid) {
					outMessage.setAction(1);
					outMessage.setInfo("User Verified");
				}
				else {
					outMessage.setAction(0);
					outMessage.setInfo("User Failed");
				}
				serverCtrl.sendMessage(outMessage);
				break;
			}
		}
		else if (controller.equals("customer")){
			serverCtrl.sendMessage(custCtrl.handle(message));
		}
		else if (controller.equals("inventory")){
			serverCtrl.sendMessage(invCtrl.handle(message));
		}
	}
	

	public Socket getClientSocket() {
		return clientSocket;
	}

	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	public ExecutorService getPool() {
		return pool;
	}

	public void setPool(ExecutorService pool) {
		this.pool = pool;
	}

	public ServerController getServerCtrl() {
		return serverCtrl;
	}

	public void setServerCtrl(ServerController serverCtrl) {
		this.serverCtrl = serverCtrl;
	}

	public DBController getDbCtrl() {
		return dbCtrl;
	}

	public void setDbCtrl(DBController dbCtrl) {
		this.dbCtrl = dbCtrl;
	}

	public CustomerController getCustCtrl() {
		return custCtrl;
	}

	public void setCustCtrl(CustomerController custCtrl) {
		this.custCtrl = custCtrl;
	}

	public InventoryController getInvCtrl() {
		return invCtrl;
	}

	public void setInvCtrl(InventoryController invCtrl) {
		this.invCtrl = invCtrl;
	}

	public Message getOutMessage() {
		return outMessage;
	}

	public void setOutMessage(Message outMessage) {
		this.outMessage = outMessage;
	}
	
	

}
