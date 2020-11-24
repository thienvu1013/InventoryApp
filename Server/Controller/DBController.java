package Server.Controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBController {
	private Connection jdbc_connection;
	private PreparedStatement statement;
	private CallableStatement myCall;
	private boolean success;
	private String databaseName = "InventoryApp",
				credTable = "CREDENTIAL",
				custTable = "CLIENT",
				toolTable = "ITEM",
				electricalTable = "ELECTRICAL";
		
				
	
	
	// Students should configure these variables for their own MySQL environment
	// If you have not created your first database in mySQL yet, you can leave the 
	// "[DATABASE NAME]" blank to get a connection and create one with the createDB() method.
	public String connectionInfo = "jdbc:mysql://localhost:3306/InventoryApp",  
				  login          = "root",
				  password       = "Ohohoh123";

	public DBController() {
		try{
			// If this throws an error, make sure you have added the mySQL connector JAR to the project
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// If this fails make sure your connectionInfo and login/password are correct
			jdbc_connection = DriverManager.getConnection(connectionInfo, login, password);
			System.out.println("Connected to: " + connectionInfo + "\n");
		}
		catch(SQLException e) { e.printStackTrace(); }
		catch(Exception e) { e.printStackTrace(); }
	}
	
	public boolean verify(String username, String password) {
		ResultSet myRs;
		try {/**
			statement = jdbc_connection.prepareStatement("SELECT * FROM " + credTable+" WHERE Username=? AND Password=?;");
			statement.setString(1, username);
			statement.setString(2, password);
			myRs = statement.executeQuery();*/
			myCall = jdbc_connection.prepareCall("{call get_credentials(?,?)}");
			myCall.setString(1, username);
			myCall.setString(2, password);
			myCall.execute();
			myRs = myCall.getResultSet();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public ResultSet searchCustID(int id) {
		ResultSet myRs;
		try {/**
			statement = jdbc_connection.prepareStatement("SELECT * FROM " + custTable+" WHERE Customer_ID=?;");
			statement.setInt(1,id);
			myRs = statement.executeQuery();*/
			myCall = jdbc_connection.prepareCall("{call get_customerID(?)}");
			myCall.setInt(1, id);
			myCall.execute();
			myRs = myCall.getResultSet();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in getting customer ID");
			e.printStackTrace();
			return null;
		}
		return myRs;
	}
	
	public ResultSet searchCustLast(String last) {
		ResultSet myRs;
		try {/**
			statement = jdbc_connection.prepareStatement("SELECT * FROM " + custTable + " WHERE LName=?;");
			statement.setString(1,last);
			myRs = statement.executeQuery();*/
			myCall = jdbc_connection.prepareCall("{call get_customerName(?)}");
			myCall.setString(1, last);
			myCall.execute();
			myRs = myCall.getResultSet();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return myRs;
	}
	
	public ResultSet searchCustType(String type) {
		ResultSet myRs;
		try {/**
			statement = jdbc_connection.prepareStatement("SELECT * FROM " + custTable + " WHERE Type=?;");
			statement.setString(1,type);
			myRs = statement.executeQuery();*/
			myCall = jdbc_connection.prepareCall("{call get_customerType(?)}");
			myCall.setString(1, type);
			myCall.execute();
			myRs = myCall.getResultSet();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return myRs;
	}
	
	
	
	public void addCustomer(int id, String last, String first,
								String type, String phone,
								String address, String postal) 
										throws SQLException {/**
		statement = jdbc_connection.prepareStatement("INSERT INTO " + custTable + " VALUES (?,?,?,?,?,?,?);");
		statement.setInt(1,id);
		statement.setString(2,last);
		statement.setString(3,first);
		statement.setString(4,type);
		statement.setString(5,phone);
		statement.setString(6,address);
		statement.setString(7,postal);
		statement.executeUpdate();*/
		myCall = jdbc_connection.prepareCall("{call create_customer(?,?,?,?,?,?,?)}");
		myCall.setInt(1,id);
		myCall.setString(2,last);
		myCall.setString(3,first);
		myCall.setString(4,type);
		myCall.setString(5,phone);
		myCall.setString(6,address);
		myCall.setString(7,postal);
		myCall.execute();
	}
	
	public void deleteCustomer(int id) throws SQLException {/**
		statement = jdbc_connection.prepareStatement("DELETE FROM " + custTable + " WHERE Customer_ID =?;");
		statement.setInt(1,id);*/
		myCall = jdbc_connection.prepareCall("{call delete_customer(?)}");
		myCall.setInt(1, id);
		myCall.execute();
	}
	
	//Inventory control
	
	public ResultSet findAll() {
		ResultSet myRs;
		try {/**
			statement = jdbc_connection.prepareStatement("SELECT T.ToolID, T.Name,T.Type,T.Quantity,T.Price, T.SupplierID, E.PowerType"
														+ "	FROM "+ toolTable +" as T"
														+ "	LEFT JOIN " + electricalTable+" AS E"
														+ " ON T.ToolID = E.ToolID;");
			myRs = statement.executeQuery();*/
			myCall = jdbc_connection.prepareCall("{call find_all_tools()}");
			myCall.execute();
			myRs = myCall.getResultSet();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return myRs;
	}
	
	public ResultSet searchItemName(String name) {
		ResultSet myRs;
		try {/**
			statement = jdbc_connection.prepareStatement("SELECT T.ToolID, T.Name,T.Type,T.Quantity,T.Price, T.SupplierID, E.PowerType"
														+ "	FROM "+ toolTable +" as T"
														+ "	LEFT JOIN " + electricalTable+" AS E"
														+ " ON T.ToolID = E.ToolID"
														+ " WHERE T.Name=?");
			statement.setString(1,name);
			myRs = statement.executeQuery();*/
			myCall = jdbc_connection.prepareCall("{call search_toolName(?)}");
			myCall.setString(1,name);
			myCall.execute();
			myRs = myCall.getResultSet();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return myRs;
	
	}
	
	public ResultSet searchItemID(int id) {
		ResultSet myRs;
		try {/**
			statement = jdbc_connection.prepareStatement("SELECT T.ToolID, T.Name,T.Type,T.Quantity,T.Price, T.SupplierID, E.PowerType"
														+ "	FROM "+ toolTable +" as T"
														+ "	LEFT JOIN " + electricalTable+" AS E"
														+ " ON T.ToolID = E.ToolID"
														+ " WHERE T.ToolID=?");
			statement.setInt(1,id);
			myRs = statement.executeQuery();*/
			myCall = jdbc_connection.prepareCall("{call search_toolID()}");
			myCall.setInt(1,id);
			myCall.execute();
			myRs = myCall.getResultSet();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return myRs;
	}
	

	public boolean decreaseQty(int id, int qty) {
		try {/**
			statement = jdbc_connection.prepareStatement("UPDATE " + toolTable + " SET Quantity =?"
					+ " WHERE ToolID=?;");
			statement.setInt(1,qty);
			statement.setInt(1,id);
			statement.executeUpdate();*/
			myCall = jdbc_connection.prepareCall("{call decrease_qty(?,?)}");
			myCall.setInt(1,id);
			myCall.setInt(2, qty);
			success = myCall.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		return success;	
	}
	
	public boolean addTool(int item_id, String item_name, int item_qty,double item_price, int item_sup, String power) {
		try {
			myCall = jdbc_connection.prepareCall("{call add_tool(?,?,?,?,?,?)}");
			myCall.setInt(1,item_id);
			myCall.setString(2, item_name);
			myCall.setInt(3, item_qty);
			myCall.setDouble(4,item_price);
			myCall.setInt(5,item_sup);
			myCall.setString(6, power);
			success = myCall.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
		
	}
	
	public boolean addElectrical(int item_id, String item_name, int item_qty,double item_price, int item_sup, String type,String power) {
		try {
			myCall = jdbc_connection.prepareCall("{call add_electrical(?,?,?,?,?,?,?)}");
			myCall.setInt(1,item_id);
			myCall.setString(2, item_name);
			myCall.setInt(3, item_qty);
			myCall.setDouble(4,item_price);
			myCall.setInt(5,item_sup);
			myCall.setString(6, type);
			myCall.setString(7,power);
			success = myCall.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}
	
	public boolean deleteTool(int id) {
		try {
			myCall = jdbc_connection.prepareCall("{call delete_tool(?)}");
			myCall.setInt(1,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}
	
	

	
	//getters and setters
	public PreparedStatement getStatement() {
		return statement;
	}

	public void setStatement(PreparedStatement statement) {
		this.statement = statement;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getCredTable() {
		return credTable;
	}

	public void setCredTable(String credTable) {
		this.credTable = credTable;
	}

	public String getCustTable() {
		return custTable;
	}

	public void setCustTable(String custTable) {
		this.custTable = custTable;
	}

	public String getToolTable() {
		return toolTable;
	}

	public void setToolTable(String toolTable) {
		this.toolTable = toolTable;
	}

	public String getElectricalTable() {
		return electricalTable;
	}

	public void setElectricalTable(String electricalTable) {
		this.electricalTable = electricalTable;
	}
	
}
