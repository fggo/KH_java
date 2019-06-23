package ncs.test1;

public class ArrayTest {
	public int sum(int[] arr) {
		int sum=0;
		for(int i=0; i<arr.length; i++) {sum+=arr[i];}
		return sum;
	}
	public double avg(int[] arr) {
		int sum = sum(arr);
		return (double)sum/arr.length;
	}
	public int max(int[] arr) {
		int max = arr[0];
		for(int i=1;i<arr.length; i++) {
			if(arr[i]> max) max =arr[i];
		}
		return max;
	}
	public int min(int[] arr) {
		int min = arr[0];
		for(int i=1;i<arr.length; i++) {
			if(arr[i]< min) min =arr[i];
		}
		return min;
	}
	public int evenCount(int[] arr) {
		int count = 0;
		for(int i =0; i<arr.length; i++)
			if(arr[i]%2 ==0) count++;
		return count;
	}
	public int oddCount(int[] arr) {
		int count = 0;
		for(int i =0; i<arr.length; i++)
			if(arr[i]%2 ==1) count++;
		return count;
	}

	public void print(int[] arr) {

		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]);
			if(i<arr.length-1) System.out.print(" ");
			else System.out.println();
		}
		
	}

	public static void main(String[] args) {
		ArrayTest test = new ArrayTest();
		
		int[] array = new int[] {23, 1, 75, 62, 12, 5};

		System.out.println("ARRAY SIZE: " + array.length);
		System.out.print("ARRAY: ");
		test.print(array);

		System.out.println("\nMAX : " + test.max(array));
		System.out.println("MIN : " + test.min(array));

		System.out.println("NUMBER OF EVEN: " + test.evenCount(array));
		System.out.println("NUMBER OF ODD: " + test.oddCount(array));

		System.out.println("SUM: " + test.sum(array));
		System.out.printf("AVG: %.2f\n", test.avg(array));
	}
}
