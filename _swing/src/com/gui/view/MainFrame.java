package com.gui.view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

	 public MainFrame() {

		 setBounds(650, 300, 500, 500);
		 setIconImage(new ImageIcon("components/images/search.png").getImage());
		 setLayout(new BorderLayout());
		 
		 JButton b1 = new JButton("왼쪽");
		 JButton b2 = new JButton("오른쪽");
		 JButton b3 = new JButton("아래");
		 JButton b4 = new JButton("위에");
		 JButton b5 = new JButton("중앙");
		 
		 add(b1, "West");
		 add(b2, "East");
		 add(b3, "South");
		 add(b4, "North");
		 add(b5, "Center");
		 
		 b1.setBounds(10, 10, 300, 300);

		 setVisible(true);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
