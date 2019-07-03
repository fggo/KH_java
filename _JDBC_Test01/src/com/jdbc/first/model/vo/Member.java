package com.jdbc.first.model.vo;

import java.sql.Date;

//DB의 멤버 테이블에 있는 데이터를 보관하기 위해
//생성한 객체로 멤버변수의 명칭은 테이블 컬럼명과 
//일치 시켜주는 것이 좋다.
public class Member {
	private String memberId;
	private String memberPwd;
	private String memberName;
	private char gender;
	private int age;
	private String email;
	private String phone;
	private String address;
	private String hobbby;
	private Date enrollDate; //java.sql.Date
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String memberId, String memberPwd, String memberName, char gender, int age, String email, String phone, String address,
			String hobbby, Date enrollDate) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.hobbby = hobbby;
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName=" + memberName + ", gender=" + gender + ", age=" + age
				+ ", email=" + email + ", phone=" + phone + ", address=" + address + ", hobbby=" + hobbby
				+ ", enrollDate=" + enrollDate + "]";
	}

	public String getMemberId() { return memberId; } 
	public void setMemberId(String memberId) { this.memberId = memberId; } 
	public String getMemberPwd() { return memberPwd; } 
	public void setMemberPwd(String memberPwd) { this.memberPwd = memberPwd; } 
	public String getMemberName() { return memberName; } 
	public void setMemberName(String memberName) { this.memberName = memberName; } 
	public char getGender() { return gender; } 
	public void setGender(char gender) { this.gender = gender; } 
	public int getAge() { return age; } 
	public void setAge(int age) { this.age = age; } 
	public String getEmail() { return email; } 
	public void setEmail(String email) { this.email = email; } 
	public String getPhone() { return phone; } 
	public void setPhone(String phone) { this.phone = phone; } 
	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; } 
	public String getHobbby() { return hobbby; } 
	public void setHobbby(String hobbby) { this.hobbby = hobbby; } 
	public Date getEnrollDate() { return enrollDate; } 
	public void setEnrollDate(Date enrollDate) { this.enrollDate = enrollDate; } 
}
