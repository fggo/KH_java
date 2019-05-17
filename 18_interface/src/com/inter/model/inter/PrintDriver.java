package com.inter.model.inter;

public interface PrintDriver {
	//변수 상수형 변수
	//final static이 디폴트이며, 생략 가능
	public final static int TEST = 19;
	public final static String MSG ="가가가가";

	//public abstract가 디폴트이며, 생략 가능
	public abstract String printDriver();

	void printInfo();
}
