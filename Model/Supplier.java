package Model;
/**
 * Supplier represent the supplier that supplies items to the shop
 * @author Thien Nguyen
 * @since October 12 2020
 * @version 1.0
 */
public class Supplier {
	/**
	 * THe ID of the supplier
	 */
	private int ID;
	/*
	 * The name of the supplier
	 */
	private String name;
	/*
	 * The supplier address
	 */
	private String address;
	/**
	 * The contact for the supplier
	 */
	private String contact;
	
	/**
	 * Getter function for supplier ID
	 * @return the ID
	 */
	public int getID() {
		return ID;
	}
	
	/**
	 * Setter function for suppliers ID
	 * @param iD the ID
	 */
	public void setID(int iD) {
		ID = iD;
	}
	
	/**
	 * Getter function for the name of supplier
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setter function for the name of supplier
	 * @param name The name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter address for the supplier
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Setter function for the suppliers address
	 * @param address The address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Getter function for the contact
	 * @return The contact
	 */
	public String getContact() {
		return contact;
	}
	
	/**
	 * Setter function for the contact
	 * @param contact The contact
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	/**
	 * Overriding toString() method
	 */
	public String toString() {
		return(this.getID()+" - "+this.getName()+" - "+this.getAddress()+" - "+this.getContact());
	}
}
