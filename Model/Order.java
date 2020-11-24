package Model;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
/**
 * Order represent an Order for the store
 * @author Thien Nguyen
 * @since October 12 2020
 * @version 1.0
 */
public class Order {
	/**
	 * The ID of the order
	 */
	private String ID;
	/**
	 * The list of order lines inside an order
	 */
	private ArrayList<OrderLine> lines;
	/**
	 * The date of an order
	 */
	private String date;
	/**
	 * The status of an order, false = not yet placed, true = been placed
	 */
	private boolean orderStatus = false;
	
	/**
	 * Constructor
	 * @param l a list of order lines
	 */
	Order(ArrayList<OrderLine> l){
		this.lines = l;
		this.ID = this.generateID();
		this.date=this.generateDate();
	}
	
	/**
	 * Function used to generate a random ID for the order
	 * @return the ID
	 */
	public String generateID() {
		Random random = new Random();
		String id = String.format("%04d%n", random.nextInt(10000));
		return id;
	}
	
	/**
	 * Function used to generate todays date
	 * @return the date
	 */
	public String generateDate() {
		Date today = new Date();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		return(df.format(today));
	}
	
	/**
	 * Function used to signify an order has been placed. This set the status to true and update all the OrderedQuantity of all item inside the order
	 */
	public void placeOrder() {
		this.setOrderStatus(true);
		for (OrderLine ol : lines) {
			ol.getItem().setOrderedQuantity((ol.getItem().getOrderedQuantity()+ol.getQuantity()));
		}
	}
	
	/**
	 * Function used to print orders onto console
	 */
	public void printOrder() {
		String format = "%-30s %30s";
		System.out.println("-------------------------------------------------------------------------");
		System.out.format(format,"ORDER ID:",this.ID);
		System.out.format(format,"Date:",this.date);
		System.out.println();
		for (OrderLine ol : lines) {
			ol.printOL();
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Function used to find a specific order line from the Order based on the item
	 * @param i The item
	 * @return the OrderLine object
	 */
	public OrderLine findOrderLine(Item i) {
		for (OrderLine line:lines) {
			if (line.getItem() == i) {
				return line;
			}
			continue;
		}
		return null;
	}
	
	/**
	 * Function used to signify the acquisition of an order. This will update the Item's quantity
	 */
	public void recieve() {
		for (OrderLine ol : lines) {
			Item i = ol.getItem();
			i.setQuantity((ol.getQuantity() + i.getQuantity()));
			i.setOrderedQuantity((i.getOrderedQuantity()-ol.getQuantity()));
		}
	}
	
	/**
	 * Function used to add an order line into an order
	 * @param ol The oder line
	 */
	public void addOrderLine(OrderLine ol) {
		this.lines.add(ol);
	}

	/**
	 * Getter function for the order status
	 * @return The order status
	 */
	public boolean getOrderStatus() {
		return orderStatus;
	}

	/**
	 * Setter function for the order status
	 * @param orderStatus boolean of the order status
	 */
	public void setOrderStatus(boolean orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	/**
	 * Getter function for the date
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * Getter function for the ID
	 * @return the ID
	 */
	public String getID() {
		return this.ID;
	}
	
	/**
	 * Function that returns the list of order lines
	 * @return the lines
	 */
	public ArrayList<OrderLine> getLines() {
		return lines;
	}
	
	/**
	 * Function that set the list of order lines
	 * @param lines The list of lines
	 */
	public void setLines(ArrayList<OrderLine> lines) {
		this.lines = lines;
	}
}
