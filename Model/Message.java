package Model;
import java.io.Serializable;
import java.util.ArrayList;


public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int action;
	private String controller;
	private String info;
	private Serializable object;
	public Message() {
		
	}
	
	
	//getters and setters

	public String getController() {
		return controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Serializable getObject() {
		return object;
	}

	public void setObject(Serializable object) {
		this.object = object;
	}


	public int getAction() {
		return action;
	}


	public void setAction(int action) {
		this.action = action;
	}
}
