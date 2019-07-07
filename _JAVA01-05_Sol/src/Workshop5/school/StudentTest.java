package Workshop5.school;

public class StudentTest {
	public static void main(String[] args) {
		Student[] students = new Student[3];
		students[0] = new Student("홍길동 ", 15, 171, 81);
		students[1] = new Student("한사람", 13,  183 , 72);
		students[2] = new Student("임걱정", 16,  175,  65);
		System.out.println("이름\t나이\t키\t몸무게");

		double sum_age=0, sum_height=0, sum_weight=0;

		for(int i =0; i<students.length; i++) {
			students[i].showStudentInfo();
			sum_age += students[i].getAge();
			sum_height += students[i].getHeight();
			sum_weight += students[i].getWeight();
		}
		System.out.printf("AVEAGE AGE: %.2f\n", sum_age/students.length);
		System.out.printf("AVEAGE HEIGHT: %.2f\n", sum_height/students.length);
		System.out.printf("AVEAGE WEIGHT: %.2f\n", sum_weight/students.length);
	}
}
