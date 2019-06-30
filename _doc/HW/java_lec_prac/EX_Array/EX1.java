package EX_Array;

public class EX1 {

	public static void main(String[] args)
	{
		int[] arr=new int[5];
		
		//for문을 이용한 대입
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=i+1;
		}
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]);
		}
		
		System.out.println();
		
		//인댁스를 이용한 대입
		arr[0]=1;arr[1]=2;arr[2]=3;arr[3]=4;arr[4]=5;
		System.out.print(arr[0]);
		System.out.print(arr[1]);
		System.out.print(arr[2]);
		System.out.print(arr[3]);
		System.out.print(arr[4]);
	}
	
}
