package Workshop5.company;

public class Company {
	private double salary;
	private double annualIncome;
	private double bonus;
	private double afterTaxBonus;

	public Company() {
		// TODO Auto-generated constructor stub
	}

	public Company(double salary) {
		super();
		this.salary = salary;
		this.annualIncome = 12*salary;
		this.bonus = salary*.2;
		this.afterTaxBonus = bonus*(1-.055);
	}

	public double getIncome() {
		return annualIncome;
	}
	public double getAfterTaxIncome() {
		return annualIncome*(1-.1);
	}
	public double getBonus() {
		return 4*bonus;
	} 
	public double getAfterTaxBonus() {
		return 4*afterTaxBonus;
	}
	
	public void showCompanyInfo() {
		System.out.printf("ANNUAL INCOME: %.1f AFTER TAX: %.1f\n", getIncome(), getAfterTaxIncome());
		System.out.printf("ANNUAL BONUS: %.1f AFTER TAX: %.1f\n", getBonus(), getAfterTaxBonus());
		System.out.printf("ANNUAL PAYMENT: %.1f", getAfterTaxIncome()+getAfterTaxBonus());
	}
	
	public double getSalary() { return salary; } 
	public void setSalary(double salary) { this.salary = salary; } 
	public double getAnnualIncome() { return annualIncome; } 
	public void setAnnualIncome(double annualIncome) { this.annualIncome = annualIncome; } 
}
