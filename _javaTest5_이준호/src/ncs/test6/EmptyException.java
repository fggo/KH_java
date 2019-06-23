package ncs.test6;

public class EmptyException extends Exception{

	private static final long serialVersionUID = 1L;
	private String message;

	public EmptyException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() { return message; } 
}
