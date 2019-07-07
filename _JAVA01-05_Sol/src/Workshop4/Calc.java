package Workshop4;

public class Calc {
	public int calculate(int data) {
		int sum=0;
		System.out.print("Â¦¼ö: ");
		for(int i=1 ; i<=data; i++) {
			if(i%2==0) {
				sum+=i;
				System.out.print(i + " ");
			}
		}
		System.out.println("\n°á°ú: " + sum);
		return sum;
	}
}
