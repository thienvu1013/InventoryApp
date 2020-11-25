package Client.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Message;
import Model.UserCredential;
import Client.View.LoginGUI;

public class LoginController {
	private ModelController modelCtrl;
	private boolean logginIn = false;
	private UserCredential user;
	private LoginGUI loginGUI;
	private Message outMessage;
	private Message inMessage;
	private CustomerViewController custCtrl;
	private InventoryViewController invCtrl;
	
	
	public LoginController(LoginGUI lGUI, ModelController modelCtrl) {
		this.loginGUI = lGUI;
		this.modelCtrl = modelCtrl;
		user = new UserCredential();
		outMessage = new Message();
		inMessage = new Message();
		this.startupView();
	}
	
	public void startApp(CustomerViewController custCtrl, InventoryViewController invCtrl) {
		this.custCtrl = custCtrl;
		this.invCtrl = invCtrl;
		while(true) {
			if(logginIn == true) {
				System.out.println(logginIn);
				break;
			}
			continue;
		}
		
	}
	
	public void verifyUser() {
		//ask server to verify user
		outMessage.setAction(1);
		outMessage.setObject(this.getUser());
		modelCtrl.sendServerMessage(outMessage);
		inMessage = modelCtrl.getServerResponse();
		//user is verified
		if (inMessage.getAction() == 1) {
			accept();
		}
		//user is not verified, return to start
		else {
			System.out.println("User is not verified");
			deny();
			
		}
	}
	
	public void startupView() {
		loginGUI.setVisible(true);
		loginGUI.addButtonListener(new ButtonListener());
	}
	
	public void accept() {
		custCtrl.startupView();
		invCtrl.startupView();
		loginGUI.setVisible(false);
		
	}
	
	public void deny() {
		loginGUI.getUserField().setText("");
		setLogginIn(false);
	}
	
	//action listeners
	public class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			user.setUsername(loginGUI.getUserField().getText());
			user.setPassword(loginGUI.getPassField().getPassword());
			setLogginIn(true);
			verifyUser();
		}
		
	}
	
	public boolean isLogginIn() {
		return logginIn;
	}

	public void setLogginIn(boolean logginIn) {
		this.logginIn = logginIn;
	}
	
	public UserCredential getUser() {
		return user;
	}

	public void setUser(UserCredential user) {
		this.user = user;
	}

	public LoginGUI getLoginGUI() {
		return loginGUI;
	}

	public void setLoginGUI(LoginGUI loginGUI) {
		this.loginGUI = loginGUI;
	}



}
