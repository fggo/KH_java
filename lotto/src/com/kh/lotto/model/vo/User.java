package com.kh.lotto.model.vo;

import java.time.LocalDateTime;
import java.util.List;

public class User {
    private String username;
    private String password;
    private char grade; //회원등급
    private LocalDateTime createdDate;
	private String accountNumber;
    private int userPoint;
    private int userMoney;
    private List<String> gambleRecord;
    
    public User() {}
    
    public User(String username, String password, String accountNumber) {
		super();
		this.username = username;
		this.password = password;
		this.grade = 'F';
		this.createdDate = LocalDateTime.now();
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//		LocalDateTime now = LocalDateTime.now();
//		System.out.println(dtf.format(now)); //2016/11/16 12:08:43 
		this.accountNumber = accountNumber;
	}

	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	public char getGrade() { return grade; }
	public void setGrade(char grade) { this.grade = grade; }
	public LocalDateTime getCreatedDate() { return createdDate; }
	public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }
	public String getAccountNumber() { return accountNumber; }
	public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
	public int getUserPoint() { return userPoint; }
	public void setUserPoint(int userPoint) { this.userPoint = userPoint; }
	public int getUserMoney() { return userMoney; }
	public void setUserMoney(int userMoney) { this.userMoney = userMoney; }
	public List<String> getGambleRecord() { return gambleRecord; }
	public void setGambleRecord(List<String> gambleRecord) { this.gambleRecord = gambleRecord; }
	
	public void showUserInfo() {
		System.out.println("아이디 : " + username);
		System.out.println("회원등급 : " + grade);
		System.out.println("가입일자 : " + createdDate);
		System.out.println("계좌번호 : " + accountNumber);
		System.out.println("포인트 : " + userPoint);
		System.out.println("잔액캐쉬 : " + userMoney);
		System.out.println("플레이한 게임 : ");
		for(int i =0; i < gambleRecord.size(); i++)
			System.out.println("\t" + gambleRecord.get(i));
	}
}
