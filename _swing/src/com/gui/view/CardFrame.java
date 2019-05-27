package com.gui.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardFrame extends JFrame {
	public CardFrame() {
		setBounds(600, 600, 300, 300);
		CardLayout card = new CardLayout();
		setLayout(card);
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		
		//패널에 배경색 추가
		p1.setBackground(Color.YELLOW);
		p2.setBackground(Color.RED);
		p3.setBackground(Color.CYAN);
		
		//패널에 컴포넌트 추가
		p1.add(new JLabel("p1"), "1");
		p2.add(new JLabel("p2"), "2");
		p3.add(new JLabel("p3"), "3");
		p1.setName("1");
		p2.setName("2");
		p3.setName("3");
		
		add(p1);
		add(p2);
		add(p3);

		p1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = ((JPanel)e.getSource()).getName();
				System.out.println(name);
				if(Integer.parseInt(name) == 1) {
					card.next(p1.getParent());
				}
				if(Integer.parseInt(name) == 3) {
					card.previous(p1.getParent());
				}
			}
		});

		p2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = ((JPanel)e.getSource()).getName();
				System.out.println(name);
				if(Integer.parseInt(name) == 1) {
					card.next(p2.getParent());
				}
				if(Integer.parseInt(name) == 3) {
					card.previous(p2.getParent());
				}
			}
		});

		p3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = ((JPanel)e.getSource()).getName();
				System.out.println(name);
				if(Integer.parseInt(name) == 1) {
					card.next(p3.getParent());
				}
				if(Integer.parseInt(name) == 3) {
					card.previous(p3.getParent());
				}
			}
		});


		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	

}
