package com.mvc.model;

import com.mvc.view.Output;

public class PayTable extends Salary implements Calculate, Output{
	public PayTable() {
		// TODO Auto-generated constructor stub
	}

	public PayTable(String name, long pay, int family, int overtime) {
		super(name, pay, family, overtime);
	}

	@Override
	public void calc() {
		//familyP
		long familyP = getFamily()<3? getFamily()*20000 : 60000;
		setFamilyP(familyP);

		//overtimeP
		long overtimeP = getOvertime()*5000;
		setOvertimeP(overtimeP);
		
		//tax
		long tax = (long)(getPay() *.1);
		setTax(tax);
		
		//incenP
		long incenP = (long)(getIncentive() * getPay());
		setIncenP(incenP);
		
		//totalPay
		long totalPay = getPay() + getFamilyP() + getIncenP() +getOvertimeP() - getTax();
		setTotalPay(totalPay);
	}

	@Override
	public void out() {
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\t%d\t%.1f\t%d\t%d\n",
				getName(), getPay(), getFamily(), getFamilyP(), getOvertime(),
				getOvertimeP(), getTax(), getIncentive(), getIncenP(), getTotalPay());
	}
}