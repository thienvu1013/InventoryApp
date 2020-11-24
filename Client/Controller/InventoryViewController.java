package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import Client.View.InventoryGUI;
import Model.Message;

public class InventoryViewController implements Runnable {
	private ModelController modelCtrl;
	private InventoryGUI inventoryGUI;
	private Message outMessage;
	private Message inMessage;
	private String controller = "inventory";
	
	public InventoryViewController(InventoryGUI iView, ModelController modelCtrl) {
		this.inventoryGUI = iView;
		this.modelCtrl = modelCtrl;
		outMessage = new Message();
		inMessage = new Message();
		outMessage.setController(controller);
	}
	
	public void startupView() {
		inventoryGUI.setVisible(true);
		inventoryGUI.addButtonListener(new listAllButton(),
				new searchNameButton(),
				new searchIDButton(),
				new searchQtyButton(),
				new decreaseButton(),
				new addDeleteButton(),
				new submitName(),
				new submitID(),
				new submitQty(),
				new submitAdd(),
				new submitDelete());
			
		//startWindow();
	}
	public void startWindow() {
		while(true) {
			inMessage = modelCtrl.getServerResponse();
			if(inMessage != null && inMessage.getController().equals("inventory")) {
				actionCase(inMessage);
				inMessage = new Message();
			}
		}
	}
	
	
	private void actionCase(Message message) {
		int choice = message.getAction();
		switch(choice) {
		//display on table
		case(1):
			Object[][] invList = modelCtrl.createInvList(message);
			DefaultTableModel tableModel = (DefaultTableModel) inventoryGUI.getResultTable().getModel();
			tableModel.setRowCount(0);
			for (Object[] i: invList) {
				tableModel.addRow(i);
			}
			inventoryGUI.getResultTable().setModel(tableModel);
			inventoryGUI.getMessageBox().setText(message.getInfo());
			break;
		case(2):
			inventoryGUI.getMessageBox().setText(message.getInfo());
			break;
		}
		
	}

	public String getController() {
		return controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	// server action 1, list all tools
	public class listAllButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			outMessage.setAction(1);
			modelCtrl.sendServerMessage(outMessage);

		}
		
	}
	// server action 2, search tool by name
	public class searchNameButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {	
			inventoryGUI.getPromptPane().moveToFront(inventoryGUI.getPromptNamePane());
		}
		
	}
	
	// server action 3, search by tool id
	public class searchIDButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			inventoryGUI.getPromptPane().moveToFront(inventoryGUI.getPromptIDPane());
			
		}
			
	}
	
	//server action 3, search tool id
	public class searchQtyButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			inventoryGUI.getPromptPane().moveToFront(inventoryGUI.getPromptIDPane());
			
		}
		
	}
	// server action 4, decrease qty
	public class decreaseButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			inventoryGUI.getPromptPane().moveToFront(inventoryGUI.getPromptQtyPane());
			
		}
		
	}
	// server action 5,6, add/delete item record;
	public class addDeleteButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			inventoryGUI.getPromptPane().moveToFront(inventoryGUI.getAddDeletePanel());
			
		}
		
	}
	public class submitName implements ActionListener{
		String controller = "inventory";
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = inventoryGUI.getPromptNameField().getText();
			outMessage.setAction(2);
			outMessage.setController(controller);
			outMessage.setInfo(name);
			modelCtrl.sendServerMessage(outMessage);
			
			
		}
		
	}
	
	public class submitID implements ActionListener{
		String controller = "inventory";

		@Override
		public void actionPerformed(ActionEvent e) {
			String id = inventoryGUI.getEnterIDField().getText();
			outMessage.setController(controller);
			outMessage.setInfo(id);
			outMessage.setAction(3);
			modelCtrl.sendServerMessage(outMessage);
			
		}
	}

		
	public class submitQty implements ActionListener{
		String controller = "inventory";
		@Override
		public void actionPerformed(ActionEvent e) {
			String qty = inventoryGUI.getPromptQtyField().getText();
			String tool = inventoryGUI.getPromptToolField().getText();
			outMessage.setAction(4);
			outMessage.setController(controller);
			outMessage.setInfo(tool);
			outMessage.setQty(qty);
			modelCtrl.sendServerMessage(outMessage);
			
		}
		
		
	}
	
	public class submitAdd implements ActionListener{
		String controller = "inventory";
		@Override
		public void actionPerformed(ActionEvent e) {
			int id = Integer.parseInt(inventoryGUI.getaDIDField().getText());
			String name = inventoryGUI.getAdNameField().getText();
			int qty = Integer.parseInt(inventoryGUI.getAdQtyField().getText());
			double price = Double.parseDouble(inventoryGUI.getaDPriceField().getText());
			int sup_id = Integer.parseInt(inventoryGUI.getaDSupplyField().getText());
			String type = inventoryGUI.getaDTypeField().getText();
			String power = inventoryGUI.getaDPowerField().getText();
			outMessage.setTheItem(modelCtrl.createItem(id,name,qty,price,sup_id,type,power));
			outMessage.setAction(5);
			outMessage.setController(controller);
			modelCtrl.sendServerMessage(outMessage);	
		}
		
		
	}
	
	public class submitDelete implements ActionListener{
		String controller = "inventory";
		@Override
		public void actionPerformed(ActionEvent e) {
			String id = inventoryGUI.getaDIDField().getText();
			outMessage.setInfo(id);
			outMessage.setAction(6);
			outMessage.setController(controller);
			modelCtrl.sendServerMessage(outMessage);	
			
		}
		
		
	}

	@Override
	public void run() {
		startWindow();
		
	}

	
	

}
