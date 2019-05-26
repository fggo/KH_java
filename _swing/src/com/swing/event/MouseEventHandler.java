package com.swing.event;

import java.awt.event.*;

import javax.swing.*;

public class MouseEventHandler implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
//		JButton button = (JButton)e.getComponent();
//		button.setText("Clicked");
		System.out.println("Clicked Button" + e.getButton());
		System.out.println("마우스 버튼 눌렸다 풀림.");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("마우스 버튼 눌림.");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("마우스 버튼 풀림.");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("커서 버튼 위 진입");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("커서 버튼 위 탈출");
	}

}
