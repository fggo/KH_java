package common.thread;

public class MySecondThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				sleep(100);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		
	}
}
