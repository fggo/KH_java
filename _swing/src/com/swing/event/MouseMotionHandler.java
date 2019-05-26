package com.swing.event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionHandler implements MouseMotionListener {

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.printf("Drag [%d %d] \n", e.getX(), e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.printf("Move [%d %d] \n", e.getX(), e.getY());
	}
}
