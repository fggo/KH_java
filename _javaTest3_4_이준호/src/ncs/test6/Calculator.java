package ncs.test6;

public class Calculator {
	public double getSum(int data) {
		try {
			if(data <2 || data > 5)
				throw new InvalidException(data);
		} catch(InvalidException e) {
			e.showWrongChoice();
		}

		int sum = 0;
		for(int i =1; i<=data; i++)
			sum += i;

		return sum;
	}

}
