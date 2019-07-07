package Workshop5.exception;

public class Account {
	private String account;
	private double balance;
	private double interestRate;

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String account, double balance, double interestRate) {
		super();
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;
	}

	public double calculateInterest() {
		return balance * interestRate/100;
	}

	public void deposit(double money) throws Exception {
		
		if(money < 0)
			throw new Exception("Deposite Amount is less than 0.");
		balance += money;
		
	}
	public void withdraw(double money) throws Exception {
		if(money <0 || balance - money <0)
			throw new Exception("Deposite Amount is less than 0"
					+ " OR withdraw amount is greater than Balance.");
		balance = balance-money;
	}

	public void showAccountInfo() {
		System.out.println("ACCOUNT INFO : " + account+ " " 
				+ balance + " WON " + interestRate);
	}

	public String getAccount() { return account; } 
	public void setAccount(String account) { this.account = account; } 
	public double getBalance() { return balance; } 
	public void setBalance(double balance) { this.balance = balance; } 
	public double getInterestRate() { return interestRate; } 
	public void setInterestRate(double interestRate) { this.interestRate = interestRate; } 
}
