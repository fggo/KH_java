package com.swing.event;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class SetDefaultCloseOperation {
	public static void main(String[] args) {
		JFrame frmOne = new JFrame("Frame One");
		JFrame frmTwo = new JFrame("Frame Two");
		
		frmOne.setBounds(120, 120, 250, 150);
		frmTwo.setBounds(380, 120, 250, 150);
		
		frmOne.add(new JButton("Button One"));
		frmTwo.add(new JButton("Button Two"));
		
		frmOne.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //dispose();
		frmTwo.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
//		frmOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit(0)
//		frmOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frmOne.setVisible(true);
		frmTwo.setVisible(true);
	}
}
