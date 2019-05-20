package com.kh.lotto.model.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Iterator;

public class User {
    private String username;
    private String password;
    private char grade; //회원등급
    private LocalDateTime createdDate;
	private String accountNumber;
    private int userPoint;
    private int userMoney;
    private boolean loggedOn;
    private HashSet<String> gambleRecord;
    
    public User() {}
    
    public User(String username, String password, char grade, LocalDateTime createdDate, String accountNumber,
			int userPoint, int userMoney, boolean loggedOn, HashSet<String> gambleRecord) {
		super();
		this.username = username;
		this.password = password;
		this.grade = grade;
		this.createdDate = createdDate;
		this.accountNumber = accountNumber;
		this.userPoint = userPoint;
		this.userMoney = userMoney;
		this.loggedOn = loggedOn;
		this.gambleRecord = gambleRecord;
	}
	
	public void showUserInfo() {
		System.out.println("아이디 : " + username);
		System.out.println("회원등급 : " + grade);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println("가입일자 : " + createdDate.format(formatter));

		System.out.println("계좌번호 : " + accountNumber);
		System.out.println("포인트 : " + userPoint);
		System.out.println("잔액캐쉬 : " + userMoney);

		String str = (loggedOn)? "로그인 중" :"로그오프 중";
		System.out.println("로그온 상태 : " + str);
		System.out.println("플레이한 게임 : ");

		Iterator<String> itr = gambleRecord.iterator();
		String record = null;
		while(itr.hasNext()) {
			record = itr.next();
			System.out.println(record);
		}
	}

	public void pointToMoney(int amount) {
		if(amount >= userPoint)
			amount = userPoint;
		
		userPoint = userPoint - amount;
		userMoney = userMoney + amount;
	}
	
	public void moneyToPoint(int amount) {
		if(amount >= userMoney)
			amount = userMoney;
		userMoney = userMoney -amount;
		userPoint = userPoint + amount;
	}

	public void addMoney(int amount) {
		this.setUserMoney(amount);
	}

	public void playGame(int i) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime date = LocalDateTime.now();

		String record = "사용자 " + username + "은 "
				+ "게임 " + i + "를 " + date.format(formatter) + "에 플레이 하였습니다.";
		gambleRecord.add(record);
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
	public boolean isLoggedOn() { return loggedOn; }
	public void setLoggedOn(boolean loggedOn) { this.loggedOn = loggedOn; }
	public HashSet<String> getGambleRecord() { return gambleRecord; }
	public void setGambleRecord(HashSet<String> gambleRecord) { this.gambleRecord = gambleRecord; }
}
