package com.swing.event;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MouseMotionEvent{
	public static void main(String[] args) {
		JFrame frm = new JFrame("Mouse Motion");
		frm.setBounds(120, 120, 250, 150);
		frm.addMouseMotionListener(new MouseMotionHandler());
		
		frm.setVisible(true);
		frm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
