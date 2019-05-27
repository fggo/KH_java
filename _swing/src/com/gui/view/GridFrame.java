package com.gui.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridFrame extends JFrame {

	public static void main(String[] args) {
		new GridFrame().gridFrame();
	}

	public void gridFrame() {
		setBounds(100,100, 900, 900);
		setLayout(new GridLayout(5,5));
		for(int i =0; i<50;i++) {
			add(new JButton(i+1+ "¹ø"));
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
