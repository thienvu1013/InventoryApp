package Model;
/**
 * Shop represent the Shop itself
 * @author Thien Nguyen
 * @since October 12 2020
 * @version 1.0
 */
public class Shop {
	/**
	 * The inventory of the shop
	 */
	private Inventory inv;
	/**
	 * THe list of supplier that supply for the shop
	 */
	private SupplierList supList;
	
	/**
	 * Constructor
	 * @param i The inventory
	 * @param sup The supplier list
	 */
	public Shop(Inventory i,SupplierList sup,CustomerList custList) {
		this.inv = i;
		this.supList = sup;
	}
	
	/**
	 * List all Item from inventory
	 */
	public void listAllItems() {
		inv.listAll();
	}

	
	/**
	 * Getter function for item
	 * @param name The String value of the the item name
	 * @return the Item 
	 */
	public Item getItem(String name) {
		return inv.getItem(name);
	}
	
	/**
	 * Getter function for item
	 * @param ID The String value of the the item ID
	 * @return the Item 
	 */
	public Item getItem(int ID) {
		return inv.getItem(ID);	
	}
	
	/**
	 * Function used to get item quantity
	 * @param name The STring value of the item's name
	 * @return the quantity of the item
	 */
	public int checkItemQuantity(String name){
		return inv.checkQuantity(name);
	}
	
	/**
	 * Function that decrease the quantity of the item
	 * @param name String value of items name
	 * @param q the quantity to decrease item quantity by
	 */
	public void decreaseItem(String name, int q){
		inv.decreaseItem(name,q);
	}
	
	/**
	 * Function that prints the order
	 */
	public void printOrder() {
		inv.printOrder();
	}
	
	/**
	 * Function that will place the order
	 */
	public void placeOrder() {
		inv.placeOrder();
	}
	
	/**
	 * Function to mark an order as recieved
	 * @param orderID the Order ID
	 */
	public void recieve(String orderID) {
		inv.recieveOrder(orderID);
	}

	public SupplierList getSupList() {
		return supList;
	}

	public void setSupList(SupplierList supList) {
		this.supList = supList;
	}
}

