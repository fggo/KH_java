package com.method2.model.vo;

public class Student {
	private String name;
	private int year;
	private double kor, math, eng;
	private double sum;
	private double avg;
	
	public Student() {}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getYear() { return year; }
	public void setYear(int year) { this.year = year; }
	public double getKor() { return kor; }
	public void setKor(double kor) { this.kor = kor; }
	public void setMath(double math) { this.math = math; }
	public double getMath() {return math;}
	public double getEng() { return eng; }
	public void setEng(double eng) { this.eng = eng; }
	public double getSum() { return sum; }
	public void setSum(double sum) { this.sum = sum; }
	public double getAvg() { return avg; }
	public void setAvg(double avg) { this.avg = avg; }
}