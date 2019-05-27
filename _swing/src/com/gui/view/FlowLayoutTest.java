package com.gui.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutTest extends JFrame {

	public static void main(String[] args) {
		new FlowLayoutTest().flowLayoutTest();
	}

	public void flowLayoutTest() {
		//FlowLayout은 매개변수에 시작위치를 설정해야함
		//좌로정렬, 우로정렬, 중앙정렬
		setBounds(400, 400, 500, 500);
		setLayout(new FlowLayout(FlowLayout.CENTER));

		for(int i =0; i <100; i++)
			add(new JButton(i+1+""));

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
