package com.gui.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridFrame extends JFrame {

	public GridFrame() {
		setBounds(100,100, 700, 700);
		setLayout(new GridLayout(5,5));
		for(int i =0; i<100;i++) {
			add(new JButton(i+1+ "¹ø"));
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
