import java.util.ArrayList;
import java.util.Scanner;
/**
 * FrontEnd simulates the user interface for the inventory App
 * @author Thien Nguyen
 * @since October 12 2020
 * @version 1.0
 */
public class FrontEnd {
	/**
	 * scanner object used to get input from user
	 */
	private Scanner scan;
	
	/**
	 * Constructor
	 */
	FrontEnd(){
	
		scan = new Scanner(System.in);
	}
	
	/**
	 * Print out list of options that a user can select.
	 * 1. To list all tools that is in the inventory
	 * 2. To search tool by name
	 * 3. To search tool by ID
	 * 4. To check the quantity of a specific tool
	 * 5. To decrease the quantity of an item by a certain amount
	 * 6. To print list of orders that yet to be received
	 * 7. To place the order of the day
	 * 8. To receive a specific order (Increase the quantity of the item by the ordered amount)
	 */
	private void printMenuChoices() {
		System.out.println("----------------------------------------------------------------");
		System.out.println("Please choose from one of the following option: ");
		System.out.println("1. List all tools in the inventory.");
		System.out.println("2. Search for tool by tool name.");
		System.out.println("3. Search for tool by tool id.");
		System.out.println("4. Check item quantity.");
		System.out.println("5. Decrease item quantity");
		System.out.println("6. Print list of orders.");
		System.out.println("7. Place today's order.");
		System.out.println("8. Recieve stock");
		System.out.println("9. Quit.");
		System.out.println();
		System.out.print("Please enter your selection: ");
	}
	
	/**
	 * Function that use to initiate the printMenuChoices() and call necessary functions from the Shop object
	 * @param theShop a Shop instance that allow the FrontEnd to call its option
	 */
	public void menu(Shop theShop) {
		while(true) {
			printMenuChoices();
			int choice = scan.nextInt();
			scan.nextLine();
			String name;
			int quantity;
			
			switch(choice) {
			
			case 1:
				theShop.listAllItems();
				break;
			
			case 2:
				name = getItemName();
				System.err.println(theShop.getItem(name));
				break;
				
			case 3:
				int id = getItemId();
				System.err.println(theShop.getItem(id));
				break;
				
			case 4:
				name = getItemName();
				System.err.println(theShop.checkItemQuantity(name));
				break;
				
			case 5:
				name = getItemName();
				quantity = getNumber();
				theShop.decreaseItem(name, quantity);
				break;
				
			case 6:
				theShop.printOrder();
				break;
				
			case 7:
				theShop.placeOrder();
				break;
				
			case 8:
				String orderID = this.getOrderID();
				theShop.recieve(orderID);
				break;
			
			case 9:
				System.out.println("\n Good Bye!");
				return;
			
			default:
				System.out.println("\n Invalid selection. Please try again!");
				break;
			
			}
		}
	}

	/**
	 * Function used to prompt the user for the item's name
	 * @return The item's name
	 */
	private String getItemName() {
		System.out.print("Please enter the item name: ");
		String name = this.scan.nextLine();
		return name;
		
	}
	
	/**
	 * Function used to prompt the user for the item's ID
	 * @return The item's ID
	 */
	private int getItemId() {
		System.out.print("Please enter the ID number of the item: ");
		return scan.nextInt();
	}
	
	/**
	 * Function used to prompt the user for the order's ID
	 * @return The order's ID
	 */
	private String getOrderID() {
		System.out.print("Please enter order ID: ");
		String name = scan.nextLine();
		return name.strip();
	}
	
	/**
	 * Function used to prompt the user for the quantity of item
	 * @return The item's quantity
	 */
	private int getNumber() {
		System.out.print("Please enter how much to decrease by: ");
		return scan.nextInt();
	}
	
	

	public static void main(String[] args){
		String itemFile = "/Users/thiennguyen/Desktop/ENSF-607/RetailStore/src/items.txt";
		String supFile = "/Users/thiennguyen/Desktop/ENSF-607/RetailStore/src/suppliers.txt";
		FileManager fileM = new FileManager();
		ArrayList<Supplier> supplier = fileM.readSuppliers(supFile);
		SupplierList supp = new SupplierList(supplier);
		ArrayList<Item> items = fileM.readItems(itemFile,supp);
		ArrayList<Order> o = new ArrayList<Order>();
		Inventory invent = new Inventory(items, o);
		Shop theShop = new Shop(invent, supp);
		FrontEnd f = new FrontEnd();
		f.menu(theShop);
		

	}

}
