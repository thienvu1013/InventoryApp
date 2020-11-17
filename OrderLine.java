/**
 * OrderLine represent an order line per order
 * @author Thien Nguyen
 * @since October 12 2020
 * @version 1.0
 */
public class OrderLine {
	/**
	 * The item that the order line is refering to
	 */
	private Item item;
	/**
	 * the String value of the supplier name
	 */
	private String supplierName;
	/**
	 * The quantity to be ordered
	 */
	private int quantity;
	
	/**
	 * Constructor
	 * @param i the Item instance
	 */
	OrderLine(Item i){
		this.item = i;
		this.supplierName = item.getSupplier().getName();
		this.quantity = item.getRequiredQuantity();
	}
	
	/**
	 * Function used to print the orderline
	 */
	public void printOL() {
		String format = "%-30s %30s %n";
		System.out.format(format,"Item Name:",this.item.getName());
		System.out.format(format,"Quantity:",this.quantity);
		System.out.format(format,"Supplier:",this.supplierName);
		
	}
	
	/**
	 * Getter function for item
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * Setter function for the item
	 * @param item instance of item
	 */
	public void setItem(Item item) {
		this.item = item;
	}
	
	/**
	 * Getter function for quantity
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Set the quantity based on items required quantity
	 */
	public void update() {
		this.quantity = item.getRequiredQuantity();
	}

}
