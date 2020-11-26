package Model;


public class Commercial extends Customer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Commercial(int customerID, String lName, String fName,String phone, String add, String post,String type) {
		super(customerID,lName,fName,phone,add,post,type);
	}


}