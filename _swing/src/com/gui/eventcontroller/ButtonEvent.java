package com.gui.eventcontroller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

//public class ButtonEvent implements MouseListener{
public class ButtonEvent extends MouseAdapter{

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() instanceof JCheckBox) {
			JCheckBox ch = (JCheckBox)e.getSource();
			if(ch.isSelected())
				ch.setBackground(Color.RED);
			else
				ch.setBackground(Color.ORANGE);
		}
		System.out.println(e.getSource());
		System.out.println(e.getPoint());
	}

//	@Override
//	public void mousePressed(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//	@Override
//	public void mouseEntered(MouseEvent e) {
//		if(e.getSource() instanceof JTextField) {
//			JTextField f= (JTextField)e.getSource();
//			f.setBackground(Color.YELLOW);
//		}
//		System.out.println(e.getSource());
//	}
//
//	@Override
//	public void mouseExited(MouseEvent e) {
//		if(e.getSource() instanceof JTextField) {
//			JTextField f= (JTextField)e.getSource();
//			f.setBackground(Color.WHITE);
//		}
//		System.out.println(e.getSource());
//	}
}
