package Model;

import java.util.ArrayList;

public class CustomerList {
	private ArrayList<Customer> customers;
	
	public CustomerList() {
		
	}
	
	public void add(Customer customer) {
		customers.add(customer);
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	
	public void clear() {
		customers.clear();
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
}
