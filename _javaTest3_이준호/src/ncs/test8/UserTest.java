package ncs.test8;

public class UserTest {
	public static void main(String[] args) {
		User[] users = new User[3];
		users[0]= new User("user01", "pass01", "±èÃ¶¼ö", 32, 'M', "010-1234-5678");
		users[1]= new User("user02", "pass02", "ÀÌ¿µÈñ", 25, 'F', "010-5555-7777");
		users[2]= new User("user03", "pass03", "È²ÁøÀÌ", 20, 'F', "010-9874-5632");
		
		User[] copyUsers = new User[users.length];

		System.out.println("---user list---");
		for(int i =0; i<users.length; i++) {
			System.out.println(users[i]);
			try {
				copyUsers[i] = (User)users[i].clone();
			} catch(CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("---(deep)copy users---");
		for(int i =0; i<copyUsers.length; i++)
			System.out.println(copyUsers[i]);
		
		System.out.println("---Equality---");
		for(int i =0; i<users.length; i++) {
			System.out.println(users[i].equals(copyUsers[i]));
		}
	}
}
