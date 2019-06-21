package ncs.test6;

public class InvalidException extends Exception {
	private static final long serialVersionUID = 1L;

	int wrongChoice;

	public InvalidException(int wrongChoice) {
		super("잘못된 숫자입력 입니다.");
		this.wrongChoice = wrongChoice;
	}
	
	public void showWrongChoice() {
		System.out.println(wrongChoice + "는 잘못된 입력값입니다.");
	}
}
