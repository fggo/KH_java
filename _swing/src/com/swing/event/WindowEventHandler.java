package com.swing.event;

import java.awt.event.*;

import javax.swing.JFrame;

public class WindowEventHandler implements WindowListener {
	String frameInfo;

	public WindowEventHandler(String frameInfo) {
		super();
		this.frameInfo = frameInfo;
	}


	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println(frameInfo + " windowOpened");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		JFrame frm = (JFrame)e.getWindow();
		frm.dispose();
		System.out.println(frameInfo + " windowClosing");
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println(frameInfo + " windowClosed");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println(frameInfo + " windowIconified");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println(frameInfo + " windowDeiconified");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println(frameInfo + " windowActivated");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println(frameInfo + " windowDeactivated");
	}

}
