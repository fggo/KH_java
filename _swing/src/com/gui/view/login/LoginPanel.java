package com.gui.view.login;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.gui.eventcontroller.ButtonEvent;

public class LoginPanel extends JPanel {
	public LoginPanel(JFrame main) {
		setBounds(1,1, 150, 500);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JLabel name = new JLabel("이름");
		add(name);
		JLabel age = new JLabel("나이");
		add(age);
		JLabel gender = new JLabel("성별");
		add(gender);
		
		JCheckBox check1 = new JCheckBox("음악감성");
		check1.setBackground(Color.ORANGE);
		add(check1);
		JCheckBox check2 = new JCheckBox("유튜브");
		check2.setBackground(Color.ORANGE);
		add(check2);
		JCheckBox check3 = new JCheckBox("게임");
		check3.setBackground(Color.ORANGE);
		check1.addMouseListener(new ButtonEvent());

		add(check3);
		
		JDialog info = new JDialog(main, "안녕 나는 다이얼 창이야", false);
		info.setBounds(500, 500, 140, 100);
		info.setLayout(new FlowLayout());
		info.add(new JLabel("팝업 메시지 맞아요~!!"));
		info.add(new JButton("확인"));
		info.setVisible(true);

		setBackground(Color.ORANGE);
		setVisible(true);
	}
}
