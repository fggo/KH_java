package ncs.test7;

public class StudentTest {
	public static void main(String[] args) {
		Student[] students = new Student[3];
		students[0] = new Student("È«±æ¼ø", 25, 171, 81, "201401", "¿µ¾î¿µ¹®ÇĞ");
		students[1] = new Student("ÇÑ»ç¶û", 23, 183, 72, "201402", "°ÇÃàÇĞ");
		students[2] = new Student("ÀÓ²©Á¤", 26, 175, 65, "201403", "Ã¼À°ÇĞ");
		
		for(int i =0; i <students.length; i++)
			System.out.println(students[i]);
	}

}
