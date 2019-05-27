package com.gui.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutTest extends JFrame {

	public FlowLayoutTest() {
		setBounds(400, 400, 500, 500);

		//FlowLayout은 매개변수에 시작위치를 설정해야함
		//좌로정렬, 우로정렬, 중앙정렬
		setLayout(new FlowLayout(FlowLayout.CENTER));
		for(int i =0; i <100; i++)
			add(new JButton(i+1+""));

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
