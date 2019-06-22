package ncs.test13;

public class AmountNotEnough extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;
	
	public AmountNotEnough(String message) {
		super("Inventory is Empty! Please check your storage for existing units.");
		this.message = message;
	}

	public void showMessage() {
		System.out.println("Inventory is Empty! Please check your storage for existing units.");
	}

	public String getMessage() { return message; } 
	public void setMessage(String message) { this.message = message; }
}
