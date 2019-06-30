package EX_Array;

import java.util.Arrays;

public class EX4 {

	public static void main(String[] args)
	{
		//1~45까지 수 6자리
		int arr[] = new int[6];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=((int)(Math.random()*45))+1;
			for(int j=0;j<i;j++)
			{
				if(arr[i]==arr[j])
				{
					i--;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
