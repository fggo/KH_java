package com.kh.lotto.model.vo;

import java.util.Date;

public class User {
    private String username;
    private String password;
    private String email;
	private String memberID;
    private Date createdDate;
	private String accountNumber;
    private int userPoint;
    private int userMoney;
    private String[] gambleRecord;


    public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
    public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public String getMemberID() { return memberID; }
	public void setMemberID(String memberID) { this.memberID = memberID; }
	public Date getCreatedDate() { return createdDate; }
	public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }
	public String getAccountNumber() { return accountNumber; }
	public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
	public int getUserPoint() { return userPoint; }
	public void setUserPoint(int userPoint) { this.userPoint = userPoint; }
	public int getUserMoney() { return userMoney; }
	public void setUserMoney(int userMoney) { this.userMoney = userMoney; }
	public String[] getGambleRecord() { return gambleRecord; }
	public void setGambleRecord(String[] gambleRecord) { this.gambleRecord = gambleRecord; }
}
