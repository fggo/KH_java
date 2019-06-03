package contact;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class ContactMain05 {
	private static ContactDAO dao;
	private static ContactDAOImple daoimp;
	private JFrame frame;
	private JTextField menuCategory;
	private JTextField menuName;
	private JTextField menuNo;
	private JTextField menuPrice;
	private JTextArea textArea;

	/**

	 * Launch the application.

	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactMain05 window = new ContactMain05();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**

	 * Create the application.

	 */
	public ContactMain05() {
		dao = ContactDAOImple.getInstance(); // ContactDAO의 인스턴스를 호출
		initialize();
	}
	/**

	 * Initialize the contents of the frame.

	 */
	private void initialize() {
		frame = new JFrame(); // 메인 프레임 생성
		frame.setBounds(100, 100, 510, 639);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼
		frame.getContentPane().setLayout(null);

		JLabel lblTitle = new JLabel("관리자 메뉴");
		lblTitle.setBorder(new LineBorder(Color.GREEN, 2, true));
		lblTitle.setFont(new Font("굴림", Font.BOLD, 21));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(12, 10, 470, 60);
		frame.getContentPane().add(lblTitle);



		JLabel lblMenuCategory = new JLabel("분류"); // "인덱스" 글자를 보여주기 위한 레이블
		lblMenuCategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuCategory.setBorder(new CompoundBorder(
				new EtchedBorder(EtchedBorder.RAISED, new Color(255, 200, 0), new Color(255, 255, 0)), null));
		lblMenuCategory.setFont(new Font("굴림", Font.PLAIN, 14));
		lblMenuCategory.setBounds(12, 80, 160, 40);
		frame.getContentPane().add(lblMenuCategory);



		JLabel lblMenuName = new JLabel("메뉴 이름"); // "이름" 글자를 보여주기 위한 레이블
		lblMenuName.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuName.setFont(new Font("굴림", Font.PLAIN, 14));
		lblMenuName.setBorder(new CompoundBorder(
				new EtchedBorder(EtchedBorder.RAISED, new Color(255, 200, 0), new Color(255, 255, 0)), null));
		lblMenuName.setBounds(12, 132, 160, 40);
		frame.getContentPane().add(lblMenuName);

		
		JLabel lblMenuNo = new JLabel("메뉴 번호"); // "번호" 글자를 보여주기 위한 레이블
		lblMenuNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuNo.setFont(new Font("굴림", Font.PLAIN, 14));
		lblMenuNo.setBorder(new CompoundBorder(
				new EtchedBorder(EtchedBorder.RAISED, new Color(255, 200, 0), new Color(255, 255, 0)), null));
		lblMenuNo.setBounds(12, 182, 160, 40);
		frame.getContentPane().add(lblMenuNo);


		JLabel lblMenuPrice = new JLabel("가격"); // 가격를 보여주기 위한 레이블
		lblMenuPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuPrice.setFont(new Font("굴림", Font.PLAIN, 14));
		lblMenuPrice.setBorder(new CompoundBorder(
				new EtchedBorder(EtchedBorder.RAISED, new Color(255, 200, 0), new Color(255, 255, 0)), null));
		lblMenuPrice.setBounds(12, 232, 160, 40);
		frame.getContentPane().add(lblMenuPrice);

		menuCategory = new JTextField(); // 입출력하기 위한 텍스트 필드 생성
		menuCategory.setBounds(197, 82, 285, 40);
		frame.getContentPane().add(menuCategory);
		menuCategory.setColumns(10);

		menuName = new JTextField(); //입출력하기 위한 텍스트 필드 생성
		menuName.setColumns(10);
		menuName.setBounds(197, 134, 285, 40);
		frame.getContentPane().add(menuName);


		menuNo = new JTextField(); // 입출력하기 위한 텍스트 필드 생성
		menuNo.setColumns(10);
		menuNo.setBounds(197, 184, 285, 40);
		frame.getContentPane().add(menuNo);


		menuPrice = new JTextField(); // 출력하기 위한 텍스트 필드 생성
		menuPrice.setColumns(10);
		menuPrice.setBounds(197, 234, 285, 40);
		frame.getContentPane().add(menuPrice);


		JButton btnInsert = new JButton("등록"); // 정보를 저장하는 버튼 생성
		btnInsert.addActionListener(new ActionListener() { // "등록" 버튼을 클릭하면 기능을 수행
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				insert();
			}
		});
		btnInsert.setFont(new Font("굴림", Font.BOLD, 14));
		btnInsert.setBounds(12, 282, 85, 40);
		frame.getContentPane().add(btnInsert);

		
		JButton btnSelect = new JButton("전체검색"); // 출력하는 버튼 생성
		btnSelect.addActionListener(new ActionListener() { // "전체검색" 버튼을 클릭하면 기능 수행
			@Override
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				selectAll();
			}
		});
		btnSelect.setFont(new Font("굴림", Font.BOLD, 14));
		btnSelect.setBounds(104, 282, 97, 40);
		frame.getContentPane().add(btnSelect);


		JButton btnIndexSelect = new JButton("상세검색"); // 출력하는 버튼 생성
		btnIndexSelect.addActionListener(new ActionListener() { // "상세검색" 버튼을 클릭하면 기능 수행
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				select();
			}
		});
		btnIndexSelect.setFont(new Font("굴림", Font.BOLD, 14));
		btnIndexSelect.setBounds(207, 282, 108, 40);
		frame.getContentPane().add(btnIndexSelect);


		JButton btnUpdate = new JButton("수정"); // 수정하는 버튼 생성
		btnUpdate.addActionListener(new ActionListener() { // "수정" 버튼을 클릭하면 기능 수행
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				update();
			}
		});
		btnUpdate.setFont(new Font("굴림", Font.BOLD, 14));
		btnUpdate.setBounds(320, 282, 79, 40);
		frame.getContentPane().add(btnUpdate);

		
		JButton btnDelete = new JButton("삭제"); //삭제하는 버튼 생성
		btnDelete.addActionListener(new ActionListener() { // "삭제" 버튼을 클릭하면 기능 수행
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				delete();
			}
		});
		btnDelete.setFont(new Font("굴림", Font.BOLD, 14));
		btnDelete.setBounds(403, 282, 79, 40);
		frame.getContentPane().add(btnDelete);


		JScrollPane scrollPane = new JScrollPane(); // textArea를 스크롤 형태로 만들기 위해 스크롤판 생성
		scrollPane.setBounds(12, 332, 470, 259);
		frame.getContentPane().add(scrollPane);
		textArea = new JTextArea(); // 정보를 출력해주기 위한 TextArea 생성
		scrollPane.setViewportView(textArea);
	} // end initialize


	private void insert() { // 등록하는 메소드
		String menuCategory = this.menuCategory.getText(); // 텍스트 필드에서 텍스트를 받아와 name에 저장
		int menuNo = Integer.parseInt(this.menuNo.getText()); // 텍스트 필드에서 텍스트를 받아와 name에 저장
		String menuName =this.menuName.getText(); // 텍스트 필드에서 텍스트를 받아와 name에 저장
		int menuPrice = Integer.parseInt(this.menuPrice.getText());

		ContactVO contact = new ContactVO(menuCategory, menuNo, menuName, menuPrice); // ContactVO
																// 인스턴스를 생성해서
																// 
																// 정보를 contact에
																// 저장
		int result = dao.insert(contact); // ContactDAOImple의 insert에 contact를
											// 입력한 결과를 result에 저장
		
		this.menuName.setText("");			//등록했을때 텍스트필드를 비워주기
		this.menuCategory.setText("");
		this.menuNo.setText("");
		this.menuPrice.setText("");
		
		// result는 0과 1만 출력됨
		// 0은 정상적으로 저장되었을 때, 1은 실패 했을 때
		if (result ==1) {
			System.out.println("등록 성공");
		} else {

			System.out.println("등록 실패");
		}

		// textArea에 저장한 것을 출력
		textArea.setText(contact.toString());
	}


	private void selectAll() {	//전체검색
		ArrayList<ContactVO> list = dao.select();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			buffer.append("[" + i + "] ").append(list.get(i).toString()).append("\n");
		} // end for
		textArea.setText(buffer.toString());
	}


	private void select() {		//부분검색 menuNo으로
		try {
			int menuNo = Integer.parseInt(this.menuNo.getText());
			ContactVO list = dao.select(menuNo);
			
			menuCategory.setText(list.getmenuCategory());
			menuName.setText(list.getMenuName());
			menuPrice.setText(list.getMenuPrice()+"");
			
//			menuNo.setText(Integer.parseInt(list.getMenuNo()));
			
		} catch (NumberFormatException e) {
			textArea.setText("숫자를 입력하세요.");
		} catch (NullPointerException e) {
			textArea.setText("해당 인덱스가 없습니다.");
		}
	}


	private void update() {
		try {
			int menuNo = Integer.parseInt(this.menuNo.getText());
			String menuCategory = this.menuCategory.getText();
			String menuName = this.menuName.getText();
			int menuPrice = Integer.parseInt(this.menuPrice.getText());
			
			ContactVO contact = new ContactVO(menuCategory,menuNo, menuName,menuPrice);
			
			int result = dao.update(menuNo, contact);
			System.out.println(contact);
			if (result ==1) {
				textArea.setText("수정 성공");
			}
			else
				textArea.setText("수정 실패");
		}catch(NumberFormatException e) {
			textArea.setText("숫자를 입력을 하세요.");
		}
	}
//		try {
//			String menuCategory = this.menuCategory.getText();
//			int menuNo = Integer.parseInt(this.menuNo.getText());
//			String menuName = this.menuName.getText();
//			int menuPrice = Integer.parseInt(this.menuPrice.getText());
//			ContactVO contact = new ContactVO(menuCategory, menuNo, menuName, menuPrice);
//
//			int result = dao.update(menuCategory, contact);
//			if (result == 1) {
//				textArea.setText(menuCategory + "수정 성공");
//			} else {
//				textArea.setText(menuCategory + "수정 실패");
//			}
//		} catch (NumberFormatException e) {
//			textArea.setText("숫자를 입력하세요.");
//		}
//	}
	private void delete() {
		try {
			int menuNo = Integer.parseInt(this.menuNo.getText());
			System.out.println(this.menuNo.getText());
			System.out.println(menuNo);
			int result = dao.delete(menuNo);
			
			this.menuName.setText("");		//삭제를 했을때 텍스트 필드 비워주기
			this.menuCategory.setText("");
			this.menuNo.setText("");
			this.menuPrice.setText("");
			
			if (result == 1) {
				textArea.setText(menuNo + "삭제 성공");
			} else {
				textArea.setText(menuNo + "삭제 실패");
			}
		} catch (NumberFormatException e) {
			textArea.setText("숫자를 입력하세요.");
		}
	}


}
