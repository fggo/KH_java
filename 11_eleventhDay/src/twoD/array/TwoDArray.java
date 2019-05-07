package twoD.array;

public class TwoDArray {
	public void test1() {
		int[][] arr = new int[15][11];
		for(int i =0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = i*arr[i].length + j;
				System.out.print(arr[i][j]+1 + " ");
			}
			System.out.println();
		}
	}
	
	public void test2() {
		
	}
}
