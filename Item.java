/**
 * Item represent an Item within the store
 * @author Thien Nguyen
 * @since October 12 2020
 * @version 1.0
 */
public class Item {
	/**
	 * The ID of the item
	 */
	private int ID;
	/**
	 * The name of the item
	 */
	private String name;
	/**
	 * The amount of the item
	 */
	private int quantity;
	/**
	 * The supplier of the item
	 */
	private Supplier supplier;
	/**
	 * The price of the item
	 */
	private double price;
	/**
	 * Max and minimum number of item
	 */
	static int MIN_QUANT =  40;
	static int MAX_QUANT =  50;
	
	/**
	 * The number of item thats been ordered
	 */
	private int orderedQuantity = 0;
	/**
	 * Constructor
	 */
	public Item() {
		
	}
	/**
	 * Getter function for ID
	 * @return ID
	 */
	public int getID() {
		return ID;
	}
	/**
	 * Setter function for ID
	 * @param iD the ID
	 */
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * Getter function for item name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Setter function of item name
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter function for quantity
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Setter function for quantity
	 * @param quantity The quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Getter function for supplier
	 * @return the supplier
	 */
	public Supplier getSupplier() {
		return supplier;
	}
	
	/**
	 * Setter function for supplier
	 * @param supplier The object of a supplier
	 */
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	/**
	 * Overriding toString function for item
	 */
	public String toString() {
		return(this.getID()+" - "+this.getName()+" - "+this.getQuantity()+" - "+this.getSupplier());
	}
	
	/**
	 * Getter function for the price
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Setter function for the price
	 * @param price the price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Function that checks the shortage of an item
	 * @return  a boolean true if an item is short
	 */
	public boolean checkShortage() {
		boolean need = false;
		if (quantity < MIN_QUANT) {
			need = true;
		}
		return need;
	}
	
	/**
	 * Function that return the required quantity of an item, this quantity will be used to order
	 * @return the required quantity to be ordered
	 */
	public int getRequiredQuantity() {
		return((MAX_QUANT- orderedQuantity)-quantity);
	}
	
	/**
	 * Getter function for ordered quantity
	 * @return The ordered quantity
	 */
	public int getOrderedQuantity() {
		return orderedQuantity;
	}
	
	/**
	 * Setter function for ordered quantity
	 * @param orderedQuantity the ordered quantity
	 */
	public void setOrderedQuantity(int orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}
}
