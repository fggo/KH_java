package ncs.test2;

public class StringTest {
	public static void main(String[] args) {
		String str = " A, b, c, D, a, B, C, d, f, F";
		String[] st = str.replace(" ", "").split(",");
		//st -> char[]
		char[] data = new char[st.length];
		int count = 0;
		for(String s : st){ //for~each
			data[count++] = s.charAt(0);
		}

		count=0;
		while(count<data.length){
			if(Character.isUpperCase(data[count])){
				System.out.println("data[" + count+"] : " + data[count]);
			}
			count++;
			
		}
		
	}
}
