package Client.Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Client.View.CustomerGUI;
import Model.Message;

public class CustomerViewController{
	private CustomerGUI customerGUI;
	private ModelController modelCtrl;
	Message outMessage;
	Message inMessage;
	public CustomerViewController(CustomerGUI custGUI,ModelController modelCtrl) {
		this.setCustomerGUI(custGUI);
		this.modelCtrl = modelCtrl;
		inMessage = new Message();
		outMessage = new Message();
		outMessage.setController("customer");
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
	
	
	public void actionCase(Message message) {
		int choice = message.getAction();
		String result;
		switch(choice) {
		// receiving customer info
		case(0):
			customerGUI.getResultField().setText("No result matches with you query");
			break;
		case(1):
			result = modelCtrl.createCustList(message);
			customerGUI.getResultField().setText(result);
			break;
		// display message
		case(2):
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
				customerGUI.getClientidButton().setSelected(false);
				customerGUI.getLastButton().setSelected(false);
				
			}
		}	
	}
	
	public class SearchButtonClick implements ActionListener{
		int action;
		String controller= "customer";
		String info;
		@Override
		public void actionPerformed(ActionEvent e) {
			// id button is selected
			if(customerGUI.getClientidButton().isSelected()) {
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
			inMessage = modelCtrl.getServerResponse();
			actionCase(inMessage);
			inMessage = new Message();
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
			if(modelCtrl.createCustomer(custid,first,last,ad,postal,phone,type)) {
				inMessage = modelCtrl.getServerResponse();
				actionCase(inMessage);
			}
			else {
				inMessage.setAction(2);
				inMessage.setInfo("Please input proper format");
				actionCase(inMessage);
			}
			inMessage = new Message();
		}
		
	}
	public class DeleteButtonClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String custid = customerGUI.getCustidField().getText();
			if(modelCtrl.deleteCustomer(custid)) {
				inMessage = modelCtrl.getServerResponse();
				actionCase(inMessage);
			}
			else {
				inMessage.setAction(2);
				inMessage.setInfo("Please input proper format");
				actionCase(inMessage);
			}
			inMessage = new Message();
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

}
