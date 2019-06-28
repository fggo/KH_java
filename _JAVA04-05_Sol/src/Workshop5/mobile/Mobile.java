package Workshop5.mobile;

public abstract class Mobile {
	private String mobileName;
	private int batterySize;
	private String osType;

	public Mobile() {
		// TODO Auto-generated constructor stub
	}

	public Mobile(String mobileName, int batterySize, String osType) {
		super();
		this.mobileName = mobileName;
		this.batterySize = batterySize;
		this.osType = osType;
	}
	
//	+operate(int time):int // 사용
//	+charge(int time):int // 충전
}
