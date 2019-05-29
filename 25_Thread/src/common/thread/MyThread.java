package common.thread;

public class MyThread extends Thread {
	private String name;

	public MyThread(String name) {
		super();
		this.name = name;
	}
	
	//상속한 thread 객체에 있는 run 메소드를 구현!

	@Override
	public void run() {
		for(int i =0; i<10; i++) {
			System.out.println(name + " " + i);
			try {
				sleep(500);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + "쓰레드 끝.");
	}
}
