package com.abstracttest.model.vo;

public abstract class Car {
	private String model;
	private String engine;
	private int tire;

	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String model, String engine, int tire) {
		super();
		this.model = model;
		this.engine = engine;
		this.tire = tire;
	}
	
	public abstract void move(int x, int y);

	public String getModel() { return model; }
	public void setModel(String model) { this.model = model; } 
	public String getEngine() { return engine; } 
	public void setEngine(String engine) { this.engine = engine; } 
	public int getTire() { return tire; } 
	public void setTire(int tire) { this.tire = tire; } 
}
