package board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import board.model.vo.*;

public class BoardManager {
	public static final Scanner CONSOLE = new Scanner(System.in);

	private List<Board> list = new ArrayList<Board>();
	private File file = new File("board_list.dat");

	//메소드 작성
//	1. 게시글 쓰기 메소드		
	public void writeBoard(){
//		>> 구현내용
//		1> "새 게시글 쓰기 입니다." 출력
//		2> "글제목 : " >> 입력받음(공백포함)
//		3> "작성자 : " >> 이름 입력받음 (공백없이)
//		4> 작성날짜는 현재 날짜로 입력처리함
//		5> "글내용 : " >> 여러 줄로 입력받음
//				"exit" 입력하면 입력종료
//		6> Board 객체 생성시 초기값으로 사용함
//		7> list에 추가함
		this.checkNewLine();
		System.out.println("새 게시글 쓰기 입니다.");
		System.out.print("글제목 : ");
		String boardTitle = CONSOLE.nextLine(); //공백포함

		System.out.print("작성자 : ");
		String boardWriter = CONSOLE.next(); CONSOLE.nextLine(); //공백없이

		System.out.print("글내용(내용 완료하려면 exit) : ");
		String boardContent= "";
		String line = "";
		do {
			line = CONSOLE.nextLine();
			boardContent += line;
		} while(!line.equals("exit"));
		
		Board newBoard = new Board(list.size()+1, boardTitle, boardWriter, 
				new Date(), boardContent, 0);
		list.add(newBoard);
	}


//	2. 게시글 전체 보기	메소드
	public void displayAllList(){
//		>> 구현내용
//		1> list 에 기록된 정보를 모두 화면에 출력시킴
		for(Board b : list)
			System.out.println(b);
	}

//	3. 게시글 한개 보기	메소드
	public void displayBoard(){
//		>> 구현내용
//		1> "조회할 글번호 : " >> 입력받음
//		2> 해당 글번호에 대한 게시글을 화면에 출력시킴
//		3> 해당 글에 대한 조회수 1증가 처리함
		System.out.print("조회할 글번호 : ");
		int boardNo = CONSOLE.nextInt();
		for(Board b : list) {
			if(b.getBoardNo() == boardNo) {
				System.out.println(b);
				b.setReadCount(b.getReadCount() + 1);
			}
		}
	}


//	4. 게시글 제목 수정	메소드
	public void modifyTitle(){
//		>> 구현내용
//		1> "수정할 글번호 : " >> 입력받음
//		2> 해당 글번호에 대한 게시글을 화면에 출력시킴
//		3> "변경할 제목 : " >> 새 제목 입력받음 >> 제목변경
//		4> 변경된 객체 정보를 list의 해당 번호 객체에 적용함
		System.out.print("수정할 글번호 : ");
		int boardNo = CONSOLE.nextInt(); CONSOLE.nextLine();
		String boardTitle = "";
		for(Board b : list) {
			if(b.getBoardNo() == boardNo) {
				System.out.println(b);
				System.out.print("변경할 제목 : ");
				boardTitle = CONSOLE.nextLine();
				b.setBoardTitle(boardTitle);
				return;
			}
		}
	}
		   

//	5. 게시글 내용 수정	메소드
	public void modifyContent(){
//		>> 구현내용
//		1> "수정할 글번호 : " >> 입력받음
//		2> 해당 글번호에 대한 게시글을 화면에 출력시킴
//		3> "변경할 내용 : " >> 새 내용 입력받음 >> 내용변경
//		4> 변경된 객체 정보를 list의 해당 번호 객체에 적용함
		System.out.print("수정할 글번호 : ");
		int boardNo = CONSOLE.nextInt(); CONSOLE.nextLine();
		String boardContent = "";
		String line = "";
		for(Board b : list) {
			if(b.getBoardNo() == boardNo) {
				System.out.println(b);
				System.out.println("변경할 내용(내용 완료하려면 exit) : ");
				do {
					line = CONSOLE.nextLine();
					boardContent += line;
				} while(!line.equals("exit"));
				b.setBoardContent(boardContent);
				return;
			}
		}
	}

//	6. 게시글 삭제 메소드
	public void deleteBoard(){
//		>> 구현내용
//		1> "삭제할 글번호 : " >> 입력받음
//		2> 해당 글번호에 대한 게시글을 화면에 출력시킴
//		3> "정말로 삭제하시겠습니까? (y/n) : " 
//			>> 'Y'입력시 list에서 해당 객체 삭제함
//		4> "oo번 글이 삭제되었습니다." 출력
		System.out.print("삭제할 글번호 : ");
		int boardNo = CONSOLE.nextInt(); CONSOLE.nextLine();
		char answer = '\u0000';
		String boardTitle = "";
		for(Board b : list) {
			if(b.getBoardNo() == boardNo) {
				System.out.println(b);
				System.out.print("정말로 삭제하시겠습니까? (y/n) : ");
				answer = CONSOLE.nextLine().charAt(0);
				if(Character.toLowerCase(answer) == 'y') {
					list.remove(b);
					System.out.println(boardNo + "번 글이 삭제되었습니다.");
				}
				else
					break;
			}
		}
	}
		

//	7. 게시글 검색 메소드
	public void searchBoard(){
//		>> 구현내용
//		1> "검색할 제목 : " >> 검색할 글자를 입력받음
//		2> 입력된 글자를 제목으로 포함하고 있는 객체들을 list에서
//		   찾음
//		3> 화면에 검색된 객체들을 출력함
		this.checkNewLine();
		System.out.print("검색할 제목 : ");
		String boardTitle = CONSOLE.nextLine();
		for(Board b : list) {
			if(b.getBoardTitle().equals(boardTitle))
				System.out.println(b);
		}
	}


//	8. 파일에 저장하기 메소드
	public void saveListFile(){
//		>> 구현내용
//		1> list에 저장된 정보를 board_list.dat 파일에 
//		   ObjectOutputStream 클래스 사용하여 기록 저장함
//		   try with resource 문 사용할 것
//		2> "board_list.dat 에 성공적으로 저장되었습니다." 출력
		try(FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);){
			oos.writeObject(list);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadListFile() {
		if(file.exists() == false)
			return;
		ObjectInputStream ois = null;
		try{
			FileInputStream fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			this.list = (ArrayList<Board>)ois.readObject();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

//	9. 정렬처리용 메소드
	public void sortList(int item, boolean isDesc){
//		>> 구현내용
//		1> item 이 1이면 번호순 정렬
//			item 이 2이면 날짜순 정렬
//			item 이 3이면 제목순 정렬 작동되게 정렬용 클래스 사용함
//		2> isDesc 가 true 이면 내림차순정렬 작동
//			isDesc 가 false 이면 오름차순정렬 작동되게 함
		if(item == 1) {
			if(isDesc)
				Collections.sort(list, new DescBoardNo());
			else
				Collections.sort(list, new AscBoardNo());
		}
		else if(item == 2) {
			if(isDesc)
				Collections.sort(list, new DescBoardDate());
			else
				Collections.sort(list, new AscBoardDate());
		}
		else if (item ==3) {
			if(isDesc)
				Collections.sort(list, new DescBoardTitle());
			else
				Collections.sort(list, new AscBoardTitle());
		}
		else
			return;
	}
	
	private void checkNewLine() {
		if(CONSOLE.hasNextLine())
			CONSOLE.nextLine();
	}
}
