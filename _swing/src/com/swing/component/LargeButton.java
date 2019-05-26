package com.swing.component;

import java.awt.*;

import javax.swing.*;

public class LargeButton extends JButton{

	public LargeButton(String str) {
		super(str);
	}
	
	public Dimension getPreferredSize() {
		Dimension largeBtmSz
			= new Dimension(
					super.getPreferredSize().width+30,
					super.getPreferredSize().height+15);
		return largeBtmSz;
	}
}
