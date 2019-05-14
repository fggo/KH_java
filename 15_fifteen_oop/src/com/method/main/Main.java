package com.method.main;

import com.method.controller.MemberController;
import com.method.model.vo.Employee;
import com.method.model.vo.Member;

public class Main {
	public static void main(String[] args) {
		MemberController mc = new MemberController();
		Member m = mc.enrollMember();
//		m.printMember();
//		mc.updateMember(m);
//		m.printMember();
		
		//java Main a b c
		for(int i =0; i<args.length; i++)
			System.out.println(args[i]);
		
		for(String a : args)
			System.out.print(a + " ");

		System.out.println();
		
		
		//-----
		Employee emp = new Employee();
	}
}