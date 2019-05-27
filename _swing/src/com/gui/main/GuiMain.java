package com.gui.main;

import javax.swing.JFrame;

public class GuiMain extends JFrame {
	public GuiMain() {
		super("MyMeo");
		//생성된 창의 크기 설정
		/*setSize(200, 200);
		setLocation(600, 700);*/

		//생성된 창의 위치와 크기를 한번에 설정 : setSize() + setLocation()
		setBounds(600, 200, 200, 200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GuiMain();
	}
}
