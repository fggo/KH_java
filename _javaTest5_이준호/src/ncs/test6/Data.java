package ncs.test6;

public class Data {
	private int value;
	private boolean isEmpty = true;

	public Data() {
		// TODO Auto-generated constructor stub
	}

	public void setValue(int value) { 
		synchronized(this) {
			if(isEmpty == false) {
				try {
					wait();
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.value = value;
			isEmpty = false;
			notify();
		}
	}

	public int getValue() { 
		int retVal = 0;
		synchronized(this){
			if(isEmpty == true) {
				try {
					wait();
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			retVal = this.value;
			isEmpty = true;
			notify();
		}
		return retVal;

	}

	public boolean isEmpty() { return isEmpty; }
}
