package com.swing.event;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

public class JButtonMouseEvent {
	public static void main(String[] args) {
		JFrame frm = new JFrame("JButton Disable");
		frm.setBounds(120, 120, 250, 150);
		frm.setLayout(new FlowLayout());
		
		JButton btn1 = new JButton("Button Ono");
		JButton btn2 = new JButton("Button Two");
		MouseListener mouseHandler = new MouseEventHandler();
		btn1.addMouseListener(mouseHandler);
		btn2.addMouseListener(mouseHandler);
		
		frm.add(btn1);
		frm.add(btn2);
		btn1.setEnabled(false);

		frm.setVisible(true);
	}
}
