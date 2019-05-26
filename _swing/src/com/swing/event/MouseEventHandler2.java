package com.swing.event;

import java.awt.event.*;

import javax.swing.*;

public class MouseEventHandler2 extends MouseAdapter{
	public void mouseClicked(MouseEvent e) {
		System.out.println("마우스 버튼 눌렸다 풀림");
	}
}
