package com.list.model.vo;

import java.util.Objects;

public class Person {
	private String name;
	private int age;
	private String address;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	@Override
	public boolean equals(Object obj) {
		Person p = null;
		if(obj instanceof Person) {
			p = (Person)obj;
			if(name.equals(p.getName())
					&& age==p.getAge()
					&& address.equals(p.getAddress()))
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	//필드뿐아니라, 주소도 같아야 같은 객체로 인식하도록
	@Override
	public int hashCode() {
		return Objects.hash(name, age, address);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", address=" + address + "]";
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }
}
