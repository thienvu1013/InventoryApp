package Model;

import java.io.Serializable;

public class UserCredential implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String username;
	char[] password;
	
	public UserCredential() {
		
	}
	
	
	
	
	
	//getter and setter
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	
}
