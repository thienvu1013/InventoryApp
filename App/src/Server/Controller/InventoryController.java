package Server.Controller;

import java.io.FileWriter;
import java.io.IOException;
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
					int id = Integer.parseInt(message.getInfo());
					System.out.println(id);
					myRs = dbCtrl.searchItemID(id);
					outMessage =generateMessage(myRs);	
					break;
			//decrease quantity
			case 4:
					int tool = Integer.parseInt(message.getInfo());
					int qty = Integer.parseInt((String) message.getObject());
					outMessage.setAction(2);
					if(dbCtrl.decreaseQty(tool,qty))
					{
						outMessage.setInfo("Item quantity decreased");
						generateOrderTxt();
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
	
	
	public void generateOrderTxt() {
		ResultSet rs = dbCtrl.getOrders();
		ArrayList<String> orders = createOrderList(rs);
		FileWriter writer;
		try {
			writer = new FileWriter("Orders.txt");
			for(String str:orders) {
				System.out.println(str);
				writer.write(str);
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("fail to write");
			e.printStackTrace();
		}
		
		
	}
	
	public ArrayList<String> createOrderList(ResultSet rs){
		ArrayList<String> orders = new ArrayList<String>();
		try {  
			 while (rs.next()) {
				 String o = createOrder(rs);
				orders.add(o);
			 }
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return orders;
	}
	
	
	public String createOrder(ResultSet rs){
		String result ="";
		int order_id;
		try {
			order_id = rs.getInt("OrderID");
			String date = rs.getDate("Order_Date").toString();
			String orderlines = createOrderLines(dbCtrl.getOrderLines(order_id));
			String sep = "\n----------------------------------------------------------------------------";
			result = sep+"\nOrder Number: "+order_id+"\t\tDate: "+ date +"\n"+orderlines;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
		
	}
	private String createOrderLines(ResultSet oL){
		String orderlines = "";
		try {    
			while (oL.next()) {
				String orderL = createLine(oL);
				orderlines = orderlines + orderL + "\n";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return orderlines;
	}
	private String createLine(ResultSet oL){
		String id;
		String result="";
		try {
			id = Integer.toString(oL.getInt("Order_ID"));
			String tool = oL.getString("Tool");
			String supplier = oL.getString("Supplier");
			String qty = Integer.toString(oL.getInt("Quantity"));
			String sep = "\t-\t";
			result = id+sep+tool+sep+supplier+sep+qty+"\n";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}
	
	
	
}
