package Model;
import java.util.ArrayList;
/**
 * SupplierList represent a list of suppliers that supply items for the shop
 * @author Thien Nguyen
 * @since October 12 2020
 * @version 1.0
 */
public class SupplierList {
	/**
	 * The list of suppliers
	 */
	ArrayList<Supplier> sList;
	
	public SupplierList() {
		sList = new ArrayList<Supplier>();
	}
	
	SupplierList(ArrayList<Supplier> s){
		sList = s;
	}
	
	/**
	 * Function used to find the supplier in the supplier list
	 * @param ID the ID
	 * @return the supplier
	 */
	
	public Supplier findSupplier(int ID) {
		for (Supplier s : sList) {
			if( s.getID() == ID) {
				return s;
			}
		}
		return null;
	}
	
	/**
	 * Overiding toString() method
	 */
	public String toString() {
		String st= "";
		for (Supplier s:sList) {
			st = st+s.getName()+"\n";
		}
		return st;
	}
}
