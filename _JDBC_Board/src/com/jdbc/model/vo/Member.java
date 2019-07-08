package com.jdbc.model.vo;

import java.sql.Date;

public class Member {
    private int idx;
    private String memberId;
    private String memberPwd;
    private String memberName;
    private String email;
    private String address;
    private String phone;
    private Date enrollDate;
    
    public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(int idx, String memberId, String memberPwd, String memberName, String email, String address,
			String phone, Date enrollDate) {
		super();
		this.idx = idx;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "Member [idx=" + idx + ", memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName="
				+ memberName + ", email=" + email + ", address=" + address + ", phone=" + phone + ", enrollDate="
				+ enrollDate + "]";
	}

	public int getIdx() { return idx; } 
	public void setIdx(int idx) { this.idx = idx; } 
	public String getMemberId() { return memberId; } 
	public void setMemberId(String memberId) { this.memberId = memberId; } 
	public String getMemberPwd() { return memberPwd; } 
	public void setMemberPwd(String memberPwd) { this.memberPwd = memberPwd; } 
	public String getMemberName() { return memberName; } 
	public void setMemberName(String memberName) { this.memberName = memberName; } 
	public String getEmail() { return email; } 
	public void setEmail(String email) { this.email = email; } 
	public String getAddress() { return address; } 
	public void setAddress(String address) { this.address = address; } 
	public String getPhone() { return phone; } 
	public void setPhone(String phone) { this.phone = phone; } 
	public Date getEnrollDate() { return enrollDate; } 
	public void setEnrollDate(Date enrollDate) { this.enrollDate = enrollDate; }
}
