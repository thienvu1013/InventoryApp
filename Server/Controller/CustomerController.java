package Server.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Message;
import Model.Commercial;
import Model.Customer;
import Model.Residential;

public class CustomerController {
	private DBController dbCtrl;
	private Message outMessage;
	private String controller = "customer";
	public CustomerController(DBController db) {
		outMessage = new Message();
		outMessage.setController(controller);
		this.dbCtrl = db;
	}
	
	public boolean checkResidential(ResultSet rs) throws SQLException {
		if (rs.getString("Type").equals("R")){
			return true;
		}
		return false;
	}
	
	
	public Message handle(Message message) {
		try {
			int choice = message.getAction();
			ResultSet myRs;
			Customer customer;
			switch(choice) {
			case 1: 
					int id = Integer.parseInt(message.getInfo());
					System.out.println("customer id "+ id);
					myRs = dbCtrl.searchCustID(id);
					outMessage =generateMessage(myRs);
					System.out.println("case 1 completed");
					break;
			case 2:
					
					String last = message.getInfo();
					myRs = dbCtrl.searchCustLast(last);
					outMessage =generateMessage(myRs);
					break;
			
			case 3:
					
					String type = message.getInfo();
					myRs = dbCtrl.searchCustType(type);
					outMessage =generateMessage(myRs);	
					break;
			
			case 4:
					customer = message.getTheCustomer();
					outMessage = addCustomer(customer);
					break;
			case 5:
					customer = message.getTheCustomer();
					outMessage = deleteCustomer(customer);
					break;
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outMessage;
	}
	

	public ArrayList<Customer> createCustList(ResultSet rs) throws SQLException {
		System.out.println("creating list");
		ArrayList<Customer> theList = new ArrayList<Customer>();
		while(rs.next()) {
			Customer customer = createCust(rs);
			theList.add(customer);
		}
		return theList;
		
	}
	
	public Customer createCust(ResultSet rs) throws SQLException {
		System.out.println("creating cust");
		Customer customer;
		if(checkResidential(rs)) {
			customer = createResidential(rs);
		}
		else {
			customer = createCommercial(rs);
		}
		return customer;
	}
	
	public Customer createResidential(ResultSet rs) throws SQLException {
		Customer customer = new Residential(rs.getInt("Customer_ID"),
				rs.getString("LName"),
				rs.getString("FName"),
				rs.getString("PhoneNum"),
				rs.getString("Address"),
				rs.getString("PostalCode"),
				"R");
		return customer;
	}
	
	public Customer createCommercial(ResultSet rs) throws SQLException {
		Customer customer = new Commercial(rs.getInt("Customer_ID"),
				rs.getString("LName"),
				rs.getString("FName"),
				rs.getString("PhoneNum"),
				rs.getString("Address"),
				rs.getString("PostalCode"),
				"C");
		return customer;
	}
	
	public Message generateMessage(ResultSet myRs) throws SQLException {
		System.out.println("generating message");
		ArrayList<Customer>custList = createCustList(myRs);
		outMessage.setAction(1);
		outMessage.setCustList(custList);
		return outMessage;
	}
	
	public Message addCustomer(Customer customer) {
		int customerID = customer.getCustomer_id();
		String lastName = customer.getLastName();
		String firstName = customer.getFirstName();
		String type = customer.getType();
		String phone = customer.getPhone();
		String address = customer.getAddress();
		String postalCode = customer.getPostal();
		try {
			dbCtrl.addCustomer(customerID, lastName, firstName, type, phone,address, postalCode);
			outMessage.setInfo("Successfully added "+ firstName + " " + lastName + " to database!");
	
			
		}catch(Exception e) {
			e.getMessage();
			outMessage.setInfo("Invalid input");
		}
		outMessage.setAction(2);
		return outMessage;
	}
	
	public Message deleteCustomer(Customer customer) {
		int customerID = customer.getCustomer_id();
		try {
			dbCtrl.deleteCustomer(customerID);
			outMessage.setInfo("Successfully deleted customer :"+ customerID + " from database!");
	
			
		}catch(Exception e) {
			e.getMessage();
			outMessage.setInfo("Customer not found, please check for valid ID");
		}
		outMessage.setAction(2);
		return outMessage;
	}
}
