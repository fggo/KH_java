package com.swing.event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class AdapterEventHandling {
	public static void main(String[] args) {
		JFrame frm = new JFrame("Mouse Motion");
		frm.setBounds(120, 120, 250, 150);
//		frm.addMouseListener(new MouseEventHandler2());
		frm.addMouseListener(
			new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					System.out.println("마우스 버튼 눌림");
				}
			}
		);
		
		frm.setVisible(true);
		frm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
