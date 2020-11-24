package Client.Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Client.View.CustomerGUI;
import Model.Message;

public class CustomerViewController implements Runnable {
	private CustomerGUI customerGUI;
	private ModelController modelCtrl;
	Message outMessage;
	Message inMessage;
	public CustomerViewController(CustomerGUI custGUI,ModelController modelCtrl) {
		this.setCustomerGUI(custGUI);
		this.modelCtrl = modelCtrl;
		inMessage = new Message();
		outMessage = new Message();
	}
	
	
	public void startupView() {
		customerGUI.addButtonListener(new IDButtonClick(),
				new LastButtonClick (),
				new TypeButtonClick(),
				new SearchButtonClick(),
				new SaveButtonClick(),
				new DeleteButtonClick(),
				new ClearButtonClick());
		customerGUI.setVisible(true);
		
	}
	
	public void startWindow() {
		while(true) {
			inMessage = modelCtrl.getServerResponse();
			System.out.println("message recieve");
			if(inMessage != null && inMessage.getController().equals("customer")) {
				actionCase(inMessage);
				inMessage = new Message();
			}
		}
	}
	
	public void actionCase(Message message) {
		int choice = message.getAction();
		String result;
		switch(choice) {
		// receiving customer info
		case(1):
			System.out.println("case 1 received message");
			result = modelCtrl.createCustList(message);
			customerGUI.getResultField().setText(result);
			break;
		// display message
		case(2):
			System.out.println("case 2 received message");
			result = message.getInfo();
			customerGUI.getMessageField().setText(result);
			break;
		}
		

	}
	
	//customer search event handling
	public class IDButtonClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(customerGUI.getClientidButton().isSelected()) {
				customerGUI.getLastButton().setSelected(false);
				customerGUI.getTypeButton().setSelected(false);
				
			}
		}
	}
	
	public class LastButtonClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(customerGUI.getLastButton().isSelected()) {
				customerGUI.getClientidButton().setSelected(false);
				customerGUI.getTypeButton().setSelected(false);
				
			}
		}	
	}
	
	public class TypeButtonClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(customerGUI.getTypeButton().isSelected()) {
				customerGUI.getLastButton().setSelected(false);
				customerGUI.getLastButton().setSelected(false);
				
			}
		}	
	}
	
	public class SearchButtonClick implements ActionListener{
		int action;
		String controller;
		String info;
		@Override
		public void actionPerformed(ActionEvent e) {
			controller = "customer";
			// id button is selected
			if(customerGUI.getClientidButton().isSelected()) {
				System.out.println("id clicked");
				action = 1;
					
			}
			// last name button is selected
			else if (customerGUI.getLastButton().isSelected()) {
				action = 2;
			}
			// type button is selected
			else if (customerGUI.getTypeButton().isSelected()) {
				action = 3;
			}
			else {
				return;
			}
			info = customerGUI.getParamField().getText();
			outMessage.setController(controller);
			outMessage.setAction(action);
			outMessage.setInfo(info);
			modelCtrl.sendServerMessage(outMessage);
			//receive.
		}
	}
	
	public class SaveButtonClick implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String custid = customerGUI.getCustidField().getText();
			String first = customerGUI.getFirstField().getText();
			String last = customerGUI.getLastField().getText();
			String ad = customerGUI.getAddressField().getText();
			String postal = customerGUI.getPostalField().getText();
			String phone = customerGUI.getPhoneField().getText();
			String type = customerGUI.getTypeField().getText();
			modelCtrl.createCustomer(custid,first,last,ad,postal,phone,type);
		}
		
	}
	public class DeleteButtonClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String custid = customerGUI.getCustidField().getText();
			String first = customerGUI.getFirstField().getText();
			String last = customerGUI.getLastField().getText();
			String ad = customerGUI.getAddressField().getText();
			String postal = customerGUI.getPostalField().getText();
			String phone = customerGUI.getPhoneField().getText();
			String type = customerGUI.getTypeField().getText();
			modelCtrl.deleteCustomer(custid,first,last,ad,postal,phone,type);	
		}
		
	}
	public class ClearButtonClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			 customerGUI.getCustidField().setText("");
			 customerGUI.getCustidField().setText("");
			 customerGUI.getFirstField().setText("");
			 customerGUI.getLastField().setText("");
			 customerGUI.getAddressField().setText("");
			 customerGUI.getPostalField().setText("");
			 customerGUI.getPhoneField().setText("");
			 customerGUI.getTypeField().setText("");
			 customerGUI.getMessageField().setText("Clear");
			 
			
		}
		
	}
	public CustomerGUI getCustomerGUI() {
		return customerGUI;
	}
	
	public void setCustomerGUI(CustomerGUI customerGUI) {
		this.customerGUI = customerGUI;
	}


	@Override
	public void run() {
		startWindow();
		
	}
}
