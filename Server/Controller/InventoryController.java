package Server.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Electrical;
import Model.Item;
import Model.Message;
import Model.NonElectrical;

public class InventoryController {
	private DBController dbCtrl;
	private Message outMessage; 
	private String controller = "inventory";
	public InventoryController(DBController db) {
		outMessage = new Message();
		outMessage.setController(controller);
		this.dbCtrl = db;
	}
	public Message handle(Message message) {
		try {
			int choice = message.getAction();
			ResultSet myRs;
			Item item;
			boolean success;
			switch(choice) {
			
			//list all items
			case 1:
					myRs = dbCtrl.findAll();
					outMessage =generateMessage(myRs);
					break;
			//search by name	
			case 2:
			 
					String name = message.getInfo();
					myRs = dbCtrl.searchItemName(name);
					outMessage =generateMessage(myRs);
					break;
			//search by id
			case 3:
					System.out.println("message reciened");
					int id = Integer.parseInt(message.getInfo());
					System.out.println(id);
					myRs = dbCtrl.searchItemID(id);
					outMessage =generateMessage(myRs);	
					break;
			//decrease quantity
			case 4:
					int tool = Integer.parseInt(message.getInfo());
					int qty = Integer.parseInt((String) message.getObject());
					System.out.println(tool);
					System.out.println(qty);
					outMessage.setAction(2);
					if(dbCtrl.decreaseQty(tool,qty))
					{
						outMessage.setInfo("Item quantity decreased");
						checkQuantity();
					}
					else {
						outMessage.setInfo("Operation failed");
					}
					break;
			//adding item
			case 5:
					item = (Item) message.getObject();
					if(item instanceof Electrical) {
						Electrical e_item = (Electrical)item;
						success = addElectrical(e_item);
					}
					else {
						NonElectrical n_item = (NonElectrical)item;
						success = addTool(n_item);
					}
					outMessage.setAction(2);
					if(success) {
						outMessage.setInfo("Tool added");
					}
					else {
						outMessage.setInfo("Error in adding tool");
						
					}
					break;
			//delete items		
			case 6:
					id = Integer.parseInt(message.getInfo());
					success = dbCtrl.deleteTool(id);
					outMessage.setAction(2);
					if(success) {
						outMessage.setInfo("Tool deleted");
					}
					else {
						outMessage.setInfo("Error in deleting tool");
					}	
					break;
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outMessage;
	}
	
	public Message generateMessage(ResultSet myRs) throws SQLException {
		ArrayList<Item>itemList = createItemList(myRs);
		if (itemList!= null) {
			outMessage.setAction(1);
			outMessage.setObject(itemList);
		}
		else {
			outMessage.setAction(2);
			outMessage.setInfo("No item found");
	}
	return outMessage;
	}
	
	
	public ArrayList<Item> createItemList(ResultSet rs) throws SQLException{
		ArrayList<Item> theList = new ArrayList<Item>();
		if (!rs.next() ) {
		    return null;
		} else {

		    do {
		    	Item customer = createItem(rs);
				theList.add(customer);
		    } while (rs.next());
		}
		return theList;
		
	}
	
	public Item createItem(ResultSet rs) throws SQLException {
		Item item;
			if(checkNonElect(rs)) {
				item = createNonElect(rs);
			}
			else {
				item = createElect(rs);
			}
		return item;
	}
	
	public boolean checkNonElect(ResultSet rs) throws SQLException {
		if(rs.getString("Type").equals("N")) {
			return true;
		}
		return false;
	}
	public Item createNonElect(ResultSet rs) throws SQLException {
		Item item = new NonElectrical(rs.getInt("ToolID"),
									rs.getString("Name"),
									rs.getInt("Quantity"),
									rs.getDouble("price"),
									rs.getInt("SupplierID"),
									rs.getString("type"));
		return item;
		
	}
	
	public Item createElect(ResultSet rs) throws SQLException {
		Item item = new Electrical(rs.getInt("ToolID"),
									rs.getString("Name"),
									rs.getInt("Quantity"),
									rs.getDouble("price"),
									rs.getInt("SupplierID"),
									rs.getString("type"),
									rs.getString("PowerType"));
		return item;
		
	}
	
	public boolean addElectrical(Electrical item) {
		int item_id = item.getID();
		String item_name = item.getName();
		int item_qty = item.getQuantity();
		double item_price = item.getPrice();
		int item_sup = item.getSupplier();
		String item_type = item.getType();
		String item_power = item.getPower();
		return(dbCtrl.addElectrical(item_id, item_name, item_qty, item_price,item_sup, item_type, item_power));
	}
	
	public boolean addTool(NonElectrical item) {
		int item_id = item.getID();
		String item_name = item.getName();
		int item_qty = item.getQuantity();
		double item_price = item.getPrice();
		int item_sup = item.getSupplier();
		String item_type = item.getType();
		return(dbCtrl.addTool(item_id, item_name, item_qty, item_price,item_sup, item_type));
	}
	
	public void checkQuantity() {
		try {
			System.out.println("creating orders");
			ResultSet rs = dbCtrl.findShortage();
			ArrayList<Item>itemList = createItemList(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
