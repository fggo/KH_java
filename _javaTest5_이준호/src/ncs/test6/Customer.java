package ncs.test6;

public class Customer extends Thread{
	private Data data;
	

	public Customer(Data data) {
		this.data = data;
	}

	@Override
	public void run() {
		for(int i =0 ;i<10; i++) {
			try {
				if(data.isEmpty() == true) 
					throw new EmptyException("NO VALUE IS SET. PLEASE WAIT!");

				System.out.println("get value: " + data.getValue());
				System.out.println("value is Empty...");
			} catch(EmptyException e) {
				System.out.println(e.getMessage());
				i--;
			}
			try {
				sleep(130);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
