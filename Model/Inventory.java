package Model;
import java.util.ArrayList;
/**
 * Inventory represent an inventory of the shop. It contain a list of items and manages the orders
 * @author Thien Nguyen
 * @since October 12 2020
 * @version 1.0
 */
public class Inventory {
	/**
	 * List of items within the inventory
	 */
	private ArrayList<Item> items;
	/**
	 * List of orders that been placed and one order of that day that will need to be placed
	 */
	private ArrayList<Order> order;
	
	/**
	 * Constructor
	 * @param i A list of Items
	 * @param order A list of Orders
	 */
	Inventory(ArrayList<Item> i, ArrayList<Order> order){
		this.items = i;
		this.order = order; 
	}
	
	
	/**
	 * Function that lists all items within the inventory list
	 */
	public void listAll() {
		for (Item i : this.items) {
			System.out.println(i);
		}
	}
	
	/**
	 * Function that retrieve an Item from the item list using name
	 * @param name The String value of the item name
	 * @return The Item instance that matches the name
	 */
	public Item getItem(String name) {
		for (Item i : items) {
			if( i.getName().equals(name)){
				return i;
			}
		}
		System.err.println("Item does not exist!");
		return null;
	}
	
	/**
	 * Function that retrieve an Item from the item list using ID
	 * @param ID The int value of the item ID
	 * @return The Item instance that matches the ID
	 */
	public Item getItem(int ID) {
		for (Item i : items) {
			if( i.getID() == ID) {
				return i;
			}
		}
		System.out.println("Item does not exist!");
		return null;
	}
	
	/**
	 * Function that checks the quantity of a specific Item
	 * @param name The String value of the item name
	 * @return The quantity of the item in stock
	 */
	public int checkQuantity(String name) {
		Item i = this.getItem(name);
		return i.getQuantity();
	}
	
	/**
	 * Function that decrease the items quantity by a specified value. The functiion also call the manageQuantity to maintain the inventory
	 * @param name The String value of the item name
	 * @param q The quantity of the item
	 */
	public void decreaseItem(String name, int q) {
		Item i = this.getItem(name);
		if (i==null) {
			return;
		}
		if (i.getQuantity()==0) {
			System.err.println("Out of stock!");
			this.manageQuantity(i);
		}
		else if (i.getQuantity()< q) {
			System.err.println("Value exceed what we have in stock. Please enter smaller number");
			return;
		}
		else {
			System.err.println("Complete!");
			i.setQuantity(i.getQuantity()-q);
			this.manageQuantity(i);
		}
	}
	
	/**
	 * Function used to check shortages and create orders for items that need ordering
	 * @param i The item object
	 */
	public void manageQuantity(Item i) {
		if(i.checkShortage() == true) {
			//Find order that not yet placed
			Order unorder = this.findUnordered();
			//if there is no order created
			if (unorder == null) {
				OrderLine orderline = new OrderLine(i);
				ArrayList<OrderLine> ol = new ArrayList<OrderLine>();
				ol.add(orderline);
				Order ord = new Order(ol);
				this.order.add(ord);
			}
			else {
				//Find order line of the item
				OrderLine orderline = unorder.findOrderLine(i);
				//if item is not in order
				if (orderline == null) {
					//create new order line for the item and add that to the order
					OrderLine ol = new OrderLine(i);
					unorder.addOrderLine(ol);
				}
				else {
					orderline.update();
				}
			}
		}
	}
	
	/**
	 * Function that return the Order that has yet to be placed
	 * @return The unordered Order object
	 */
	public Order findUnordered() {
		for (Order o: this.order) {
			boolean status = o.getOrderStatus();
			if(status == true) {
				continue;
			}
			else {
				return o;
			}
		}
		return null;
	}
	
	/**
	 * Function find the unordered Order and change its status to ordered by calling the placeOrder() function from Order class
	 */
	public void placeOrder() {
		Order pOrder = this.findUnordered();
		if(pOrder == null) {
			System.err.println("No order to place");
			return;
		}
		else {
			pOrder.placeOrder();
		}
		System.err.println("The following order has been placed");
		pOrder.printOrder();
	}
	
	
	/**
	 * Function used to search for a specific order based on the order's ID
	 * @param orderID the String value of the order's ID
	 * @return the Order object
	 */
	public Order searchOrder(String orderID) {
		for( Order o : this.order) {
			if (o.getID().strip().equals(orderID)) {
				return o;
			}
		}
		return null;
	}
	
	/**
	 * Function used to change the status of the order to recieved. This will remove the order from the order list and also call the recieve() function from Order class
	 * @param orderID the ID of the order
	 */
	public void recieveOrder(String orderID) {
		Order o = searchOrder(orderID);
		if (o != null) {
			o.recieve();
			order.remove(o);
			return;
		}
		else {
			System.err.println("No order found, please check order ID again");
			return;
		}	
	}
	
	/**
	 * Function used to print all order within the inventory
	 */
	public void printOrder() {
		if (order != null)
			for (Order o:this.order) {
				o.printOrder();
			}
		else{
			System.err.println("There's no outstanding orders");
		}
	}
}
