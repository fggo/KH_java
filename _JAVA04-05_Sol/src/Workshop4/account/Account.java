package Workshop4.account;

public class Account {
	private String account;
	private int balance;
	private double interestRate;

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String account, int balance, double interestRate) {
		super();
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;
	}

	public double calculateInterest() {
		return balance * (interestRate/100.0);
	}

	public void deposit(int money) {
		this.balance += money;
	}

	public void withdraw(int money) {
		this.balance -= money;
	}
	public void showAccount() {
		System.out.println("ACCOUNT NUMBER: "+ account + " BALANCE: " + balance);
	}
	public void showInterest() {
		System.out.println("INTEREST: "+ calculateInterest());
		
	}
	public String accountInfo() {
		return "ACCOUNT# : "+ account + " BALANCE : " + balance + " WON "
				+ "INTEREST : "+ interestRate+"%";
	}

	public String getAccount() { return account; } 
	public void setAccount(String account) { this.account = account; } 
	public int getBalance() { return balance; } 
	public void setBalance(int balance) { this.balance = balance; } 
	public double getInterestRate() { return interestRate; } 
	public void setInterestRate(double interestRate) { this.interestRate = interestRate; } 
	
}
