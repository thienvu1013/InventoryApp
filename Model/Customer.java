package Model;


import java.io.Serializable;

public abstract class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int customer_id;
	private String lastName;
	private String firstName;
	private String phone;
	private String address;
	private String postal;
	private String type;
	
	
	public Customer(int customerID, String lName, String fName,String phone, String add, String post, String type) {
		this.customer_id = customerID;
		this.lastName = lName;
		this.firstName = fName;
		this.address = add;
		this.phone = phone;
		this.postal = post;
		this.type = type;
	}
	
	
	
	//getters and setters
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
}
