package Model;

public class NonElectrical extends Item {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String type;
		
	public NonElectrical(int id, String name, int qty, double price,int sup,String type) {
		super(id,name,qty,price,sup);
		this.type = type;
	}
		
	public String getType() {
		return type;
	}
	public void setType(String type) {
			this.type = type;
	}
	
	

}
