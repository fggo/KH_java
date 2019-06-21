package ncs.test8;

public class UserTest {
	public static void main(String[] args) {
		User[] users = new User[3];
		User[] copyUsers = new User[users.length];

		users[0]= new User("user01", "pass01", "±èÃ¶¼ö", 32, 'M', "010-1234-5678");
		users[1]= new User("user02", "pass02", "ÀÌ¿µÈñ", 25, 'F', "010-1234-5678");
		users[2]= new User("user03", "pass03", "È²ÁøÀÌ", 20, 'F', "010-1234-5678");
		
		System.out.println("---user list---");


		System.out.println("---copy users---");
	}
}
