package com.gui.eventcontroller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//public class MyKeyEvent implements KeyListener {
public class MyKeyEvent extends KeyAdapter{

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		System.out.println(e.getKeyChar());
	}

//	@Override
//	public void keyTyped(KeyEvent e) {
//	}

//	@Override
//	public void keyReleased(KeyEvent e) {
//		// TODO Auto-generated method stub
//	}
}
