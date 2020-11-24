package Client.Controller;

import java.util.ArrayList;

import Model.Commercial;
import Model.Customer;
import Model.Electrical;
import Model.Item;
import Model.Message;
import Model.NonElectrical;
import Model.Residential;
import Model.UserCredential;

public class ModelController {
	ClientController clientCtrl;
	Item theItem;
	Customer theCustomer;
	ArrayList<Customer> custList;
	UserCredential userInfo;
	Message outMessage;
	Message inMessage;
	String controller;

	public ModelController(ClientController cc) {
		this.clientCtrl = cc;
		this.outMessage = new Message();
		this.inMessage = new Message();
		
	}
	
	public Message getServerResponse() {
		inMessage = this.clientCtrl.recieveMessage();
		return inMessage;
	}
	
	public void sendServerMessage(Message m) {
		this.clientCtrl.sendMessage(m);
	}
	
	public String createCustList(Message message) {
		System.out.println("creating string");
		String result ="";
		custList = message.getCustList();
		for(Customer customer : custList) {
			customer = (Residential) customer;
			String id = Integer.toString(customer.getCustomer_id());
			String lastName = customer.getLastName();
			String firstName = customer.getFirstName();
			String phone = customer.getPhone();
			String postal = customer.getPostal();
			String endline = "\n";
			String type = customer.getType();
			String sep = ", ";
			result = result+
					id+sep+
					lastName+sep+
					firstName+sep+
					phone+sep+
					postal+sep+
					type+sep+
					endline;
		}
		return result;
	}
	
	public Object[][] createInvList(Message message){
		ArrayList<Item> itemList = message.getItemList();
		Object[][] result = new Object[itemList.size()][];
		int index = 0;
		for(Item i:itemList) {
			result[index] = createObjectArray(i);
		}
		return result;
	}
	
	public Object[] createObjectArray(Item i) {
		Object[] result = new Object[7];
		if (i instanceof Electrical) {
		    Electrical item = (Electrical) i;
		    result[0] = item.getID();
		    result[1] = item.getName();
		    result[2] = item.getType();
		    result[3] = item.getQuantity();
		    result[4] = item.getPrice();
		    result[5] = item.getSupplier();
		    result[6] = item.getPower();
		}
		else if (i instanceof NonElectrical) {
			NonElectrical item = (NonElectrical) i;
		    result[0] = item.getID();
		    result[1] = item.getName();
		    result[2] = item.getType();
		    result[3] = item.getQuantity();
		    result[4] = item.getPrice();
		    result[5] = item.getSupplier();
		    result[6] = "null";
		}
		return result;
	}
	
	public void createCustomer(String custid,String first,String last,String ad,String postal,String phone,String type) {
		int id = Integer.parseInt(custid);
		controller = "customer";
		if (type.equals("R")){
			theCustomer = new Residential(id, last, first, phone, ad, postal,type);
		}
		else if(type.equals("C")) {
			theCustomer = new Commercial(id,last, first, phone, ad, postal, type);
		}
		else {
			return;
		}
		outMessage.setAction(4);
		outMessage.setController(controller);
		outMessage.setTheCustomer(theCustomer);
		sendServerMessage(outMessage);
	}
	public void deleteCustomer(String custid,String first,String last,String ad,String postal,String phone,String type) {
		int id = Integer.parseInt(custid);
		controller = "customer";
		if (type.equals("R")){
			theCustomer = new Residential(id, last, first, phone, ad, postal,type);
		}
		else if(type.equals("C")) {
			theCustomer = new Commercial(id,last, first, phone, ad, postal, type);
		}
		else {
			return;
		}
		outMessage.setAction(5);
		outMessage.setController(controller);
		outMessage.setTheCustomer(theCustomer);
		sendServerMessage(outMessage);
	}
	
	public Item createItem(int id,String name,int qty,double price,int sup_id,String type,String power) {
		Item result;
		if (type.equals("E")) {
			result = new Electrical(id, name, qty, price,sup_id,type, power);
		}
		else{
			result = new NonElectrical(id, name, qty, price,sup_id,type);
		}
		return result;
	}
}


