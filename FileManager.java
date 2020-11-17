import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
/**
 * FileManager is responsible for opening the text file and create instances of suppliers and items.
 * @author Thien Nguyen
 * @since October 12 2020
 * @version 1.0
 */
public class FileManager {
	
	/**
	 * Constructor
	 */
	public FileManager() {
		//open file items for each line you read you create a new item and add that item
		// to that array of item in an inventory object
		
	}
	
	/**
	 * Function allows the reading of a text file and parse the information into a list of suppliers
	 * @param filename The name of the txt file
	 * @return An array list of supplier objects
	 */
	public ArrayList<Supplier> readSuppliers(String filename){
		ArrayList<Supplier> sup = new ArrayList<Supplier>();
		
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			String line =br.readLine();
			while (line!= null) {
				String[] temp = line.split(";");
				Supplier s = new Supplier();
				s.setID(Integer.parseInt(temp[0].strip()));
				s.setName(temp[1].strip());
				s.setAddress(temp[2].strip());
				s.setContact(temp[3].strip());
				sup.add(s);
				line = br.readLine();
				}
			br.close();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		return sup;
	}
	
	/**
	 * Function allows the reading of a text file and parsing it into a list of items
	 * @param filename The name of the txt file
	 * @param slist A list of suppliers, this will be used to link the items to the supplier
	 * @return A list of item objects
	 */

	public ArrayList<Item> readItems(String filename, SupplierList slist){
		ArrayList<Item> items = new ArrayList<Item>();
		
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			String line = br.readLine();
			while (line!= null) {
				String[] temp = line.split(";");
				Item i = new Item();
				i.setID(Integer.parseInt(temp[0].strip()));
				i.setName(temp[1].strip());
				i.setQuantity(Integer.parseInt(temp[2].strip()));
				i.setPrice(Double.parseDouble(temp[3].strip()));
				Supplier s = slist.findSupplier(Integer.parseInt(temp[4].strip()));
				if (s != null) {
					i.setSupplier(s);
					items.add(i);
				}
				else {
					System.out.println("Unknown supplier, skiping this item");
					continue;
				}
				line = br.readLine();
			}
			br.close();
		}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		return items;
	}
	

}
