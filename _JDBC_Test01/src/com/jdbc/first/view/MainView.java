package com.jdbc.first.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.jdbc.first.controller.MemberController;
import com.jdbc.first.model.vo.Member;

public class MainView {
	private MemberController controller = new MemberController();

	public void mainMenu() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("-----회원관리프로그램-----");
			System.out.println("1. 전체회원 조회");
			System.out.println("2. 이름으로 조회");
			System.out.println("3. 아이디로 조회");
			System.out.println("4. 회원 등록");
			System.out.println("5. 회원 수정");
			System.out.println("6. 회원 삭제");
			System.out.println("0. 종료");
			System.out.print("입력 : ");
			int cho = sc.nextInt(); sc.nextLine();

			switch(cho) {
				case 1: controller.memberAllSearch(); break;
				case 2: controller.memberNameSearch(); break;
				case 3: controller.memberIdSearch(); break;
				case 4: controller.memberInsert(); break;
				case 5: controller.memberUpdate(); break;
				case 6: controller.memberDelete(); break;
				case 0: System.out.println("프로그램을 종료합니다."); return;
			}
		}
	}
	
	//사용자에게 멤버 정보를 출력
	//화면이라고 생각
	public void displayMember(List<Member> list) {
		System.out.println("---회원정보 출력---");
		System.out.println("회원아이디\t회원패스워드\t회원이름\t회원성별 \t회원나이\t"
				+ "회원이메일\t회원전화번호\t회원주소\t회원취미\t가입일");
		if (list == null) return;

		for(Member m : list) {
			System.out.println(m.getMemberId() +"\t"
					+ m.getMemberId() +"\t"
					+ m.getMemberPwd() +"\t"
					+ m.getMemberName() +"\t"
					+ m.getGender() +"\t"
					+ m.getAge() +"\t"
					+ m.getEmail() +"\t"
					+ m.getPhone() +"\t"
					+ m.getAddress() +"\t"
					+ m.getHobby() +"\t"
					+ m.getEnrollDate() +"\t");
		}
	}
	
	public String inputData(String type) {
		Scanner sc = new Scanner(System.in);
		System.out.print("조회할 회원  "+ type + " : ");
		String name = sc.nextLine();
		return name;
	}
	
	public Member insertMember() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 회원 가입 ===");

		//VO Object (exists both in DB and java data)
		Member m = new Member();

		System.out.print("MEMBER ID : ");
		String memberId = sc.nextLine();
		m.setMemberId(memberId);

		System.out.print("MEMBER PWD : ");
		String memberPwd = sc.nextLine();
		m.setMemberPwd(memberPwd);

		System.out.print("MEMBER NAME : ");
		String memberName = sc.nextLine();
		m.setMemberName(memberName);

		System.out.print("GENDER('M', 'F'): ");
		char gender = sc.nextLine().charAt(0);
		m.setGender(gender);

		System.out.print("AGE : ");
		int age = sc.nextInt(); sc.nextLine();
		m.setAge(age);

		System.out.print("EMAIL : ");
		String email = sc.nextLine();
		m.setEmail(email);

		System.out.print("PHONE : ");
		String phone = sc.nextLine();
		m.setPhone(phone);

		System.out.print("ADDRESS : ");
		String address = sc.nextLine();
		m.setAddress(address);

		System.out.print("HOBBY (separated by ',') : ");
		String hobby = sc.nextLine();
		m.setHobby(hobby);

		return m;
	}
	
	//name, age, address, hobby 
	public Member updateView() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 회원 수정 ===");
		//VO Object (exists both in DB and java data)
		Member m = new Member();

		System.out.print("MEMBER NAME : ");
		String memberName = sc.nextLine();
		m.setMemberName(memberName);

		System.out.print("AGE : ");
		int age = sc.nextInt(); sc.nextLine();
		m.setAge(age);

		System.out.print("ADDRESS : ");
		String address = sc.nextLine();
		m.setAddress(address);

		System.out.print("HOBBY (separated by ',') : ");
		String hobby = sc.nextLine();
		m.setHobby(hobby);

		return m;
	}

	public String deleteMember() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 회원 삭제 ===");
		//VO Object (exists both in DB and java data)
		Member m = new Member();

		System.out.print("MEMBER ID TO DELETE : ");
		String memberId = sc.nextLine();

		return memberId;
	}
	
	public void displayMsg(String msg) {
		System.out.println("=== 시스템 메세지 ===");
		System.out.println(msg);
		System.out.println("================");
	}
}
