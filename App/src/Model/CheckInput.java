/**
 * 
 */
package Model;

/**
 * @author Thien Nguyen
 * This class checks the user input 
 *
 */
public class CheckInput {
	public CheckInput() {
		
	}
	
	
	public boolean checkID(Message message) {
		try {
			Integer.parseInt(message.getInfo());	
		}catch(Exception e){
			return false;
		}
		return true;
	}
}
