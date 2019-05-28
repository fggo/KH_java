package com.gui.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.gui.eventcontroller.ButtonEvent;
import com.gui.eventcontroller.MyKeyEvent;
import com.gui.view.login.LoginPanel;

public class NullLayout extends JFrame implements MouseListener{

	private JTextField idInput;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		idInput.setBackground(Color.green);
	}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}

	//사용자 정의용! 컴포넌트들을 하나하나~ 세심하게
	//크기, 위치, 보이는것 모든것을 설정
	public NullLayout() {
		setBounds(550,550,500,500);
		setTitle("null layout");
		setLayout(null);
		
		JButton b1=new JButton("로그인");
		b1.setBounds(250,200,80,20);
		b1.setVisible(true);
		b1.addActionListener(new MyLoginEvent());
		add(b1);
		
		JLabel id=new JLabel("ID ");
		id.setVisible(true);
		id.setBounds(180,200,50,20);
		add(id);
		
		JCheckBox ch=new JCheckBox("test");
		ch.setVisible(true);
		ch.setBounds(200,100, 50,50);
		ch.addMouseListener(this);
		add(ch);

		String[] games= {"LoL","보글보글","오버워치","카트라이더"};
		JComboBox<String> combo=new JComboBox<String>(games);
		combo.setBounds(300,10,100,100);
		combo.setVisible(true);
		combo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println(e.getItem());
				System.out.println(e.getStateChange());
				System.out.println(e.getSource());
			}
		});
		add(combo);
		
		JList<String> list=new JList<String>(games);
		list.setBounds(200,10,100,100);
		list.setVisible(true);
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				System.out.println(e.getFirstIndex());
				System.out.println(e.getLastIndex());
				System.out.println(e.getSource());
			}
		});
		add(list);
		
		idInput=new JTextField();
		idInput.setBounds(200,200,50,20);
		idInput.setVisible(true);
		idInput.addMouseListener(new ButtonEvent());
		idInput.addKeyListener(new MyKeyEvent());
		add(idInput);
		
		add(new LoginPanel(this));
		
		setDefaultCloseOperation(3);
		setVisible(true);
	}

	// 내부클래스를 이용한 이벤트 처리
	class MyLoginEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getSource());
			idInput.setText("안녕");			
		}
	}
	
	public static void main(String[] args) {
		new NullLayout();
	}
	
}