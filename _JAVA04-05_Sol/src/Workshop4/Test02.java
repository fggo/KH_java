package Workshop4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test02 {
	public static void main(String[] args) {
		int[] arr3 = new int[5];
		
		List<Integer> list = new ArrayList<Integer>();
		int rand = 0;
		int count = 0;
		int sum=0;
		while(count!=5) {
			rand = (new Random()).nextInt(10)+1;
			if(!list.contains(rand)) {
				list.add(rand);
				arr3[count++] = rand;
				sum+=rand;
				System.out.print(rand);
				if(count<5) System.out.print(" ");
				else System.out.println();
			}
		}
		System.out.println("sum=" + sum);
		System.out.printf("avg=%.1f\n", (double)sum/arr3.length);
	}
}
