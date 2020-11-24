package Model;


public class Electrical extends Item{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String power;
	String type;
	
	


	public Electrical(int id, String name, int qty, double price,int sup,String type, String power) {
		super(id,name,qty,price,sup);
		this.power = power;
		this.type = type;
	}
	

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


}
