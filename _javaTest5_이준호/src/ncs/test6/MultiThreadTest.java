package ncs.test6;

public class MultiThreadTest {
	public static void main(String[] args) {
		Data data = new Data(); //공유데이터
		Thread putThread = new Provider(data);
		Thread getThread = new Customer(data);
		// data 를 공유하는 Provider 와 Customer 객체 생성 : Thread 객체 생성함
		// 쓰래드 구동
		putThread.start();
		getThread.start();	
		
		try {
			putThread.join();
			getThread.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Main Thread ends...");
	}
}
