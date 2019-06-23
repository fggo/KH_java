package ncs.test6;

import java.util.Random;

public class Provider extends Thread {
	private Data data;
	
	public Provider(Data data) {
		this.data = data;
	}

	@Override
	public void run() {
		for(int i =0 ;i<10; i++) {
			//random number from 1~100
			int n = new Random().nextInt(100) +1;
			data.setValue(n);
			if(data.isEmpty() == false) {
				System.out.println("Input Complete...");
				System.out.println("put value: " + n);
			}
			try {
				sleep(200);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
