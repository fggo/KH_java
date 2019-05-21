package com.abstracttest.model.vo;

public class Bus extends Car {
	private int seat;
	private String company;
	private String city;
	private int fuel;

	public Bus(String model, String engine, int tire, int seat, String company, String city, String manufacturer,
			int fuel) {
		super(model, engine, tire);
		this.seat = seat;
		this.company = company;
		this.city = city;
		this.fuel = fuel;
	}

	public Bus(int seat, String company, String city, String manufacturer) {
		super();
		this.seat = seat;
		this.company = company;
		this.city = city;
	}

	@Override
	public void move(int x, int y) {
		System.out.println(company + "회사 " +getModel() +"차량을 " 
				+ "x방향으로  " + x +"만큼 이동하고," +
				"y방향으로 " + y +"만큼 이동합니다.");
	}
	
	public void addPassenger() {
		System.out.println("승객을 태웠습니다.");
	}

	public int getSeat() { return seat; }
	public void setSeat(int seat) { this.seat = seat; }
	public String getCompany() { return company; }
	public void setCompany(String company) { this.company = company; }
	public String getCity() { return city; }
	public void setCity(String city) { this.city = city; }
}
