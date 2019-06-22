package ncs.test1;

public class ArrayTest {
	public static void main(String[] args) {
		int [][] array = {
			{12, 41, 36, 56, 21}, 
			{82, 10, 12, 61, 45}, 
			{14, 16, 18, 78, 65}, 
			{45, 26, 72, 23, 34}};

		int elCount =0;
		double sum=0;

		for(int i =0;i<array.length; i++) {
			elCount += array[i].length;
			for(int j=0; j<array[i].length; j++)
				sum+=array[i][j];
		}

		System.out.printf("ÇÕ°è: %.2f\n", sum);
		System.out.printf("Æò±Õ: %.2f", sum/elCount);
	}
}
