package com.jdbc.controller;

import java.util.List;

import com.jdbc.model.service.BoardService;
import com.jdbc.model.vo.Board;
import com.jdbc.view.MainView;

public class BoardController {
	private BoardService service = new BoardService();
	
	public void selectAll() {
		List<Board> list = service.selectAll();
		if (list.size() > 0)
			new MainView().displayList(list);
		else
			new MainView().displayMsg("NO BOARD SEARCH RESULT...");
	}
	
	public void selectWriter() {
		this.selectAll();

		String writer = new MainView().inputData("WRITER");
		List<Board> list = service.selectWriter(writer);

		if (list.size() > 0)
			new MainView().displayList(list);
		else
			new MainView().displayMsg("NO BOARD WRITER SEARCH RESULT...");
	}

	public void selectTitle() {
		this.selectAll();

		String title = new MainView().inputData("TITLE");
		List<Board> list = service.selectTitle(title);

		if (list.size() > 0)
			new MainView().displayList(list);
		else
			new MainView().displayMsg("NO BOARD TITLE SEARCH RESULT...");
		
	}
	
	public void insertBoard() {
		this.selectAll();

		Board b = new MainView().insertBoard();

		if(b == null) {
			System.out.println("DIV CHECK FAILED : invalid input for DIV");
			return;
		}

		int result = service.insertBoard(b);
		
		String msg = result > 0 ? result + " ROW(s) INSERT COMPLETE." : "BOARD INSERT FAILED.";

		new MainView().displayMsg(msg);
	}
	
	public void updateBoard() {
		this.selectAll();

		Board b = new MainView().updateBoard();
		int result = service.updateBoard(b);
		
		String msg = result > 0 ? result + " ROW(s) UPDATE COMPLETE." : "BOARD UPDATE FAILED.";

		new MainView().displayMsg(msg);
	}
	
	public void deleteBoard() {
		this.selectAll();

		int idx = new MainView().deleteBoard();
		int result = service.deleteBoard(idx);
		
		String msg = result > 0 ? result + " ROW(s) DELETE COMPLETE." : "BOARD DELETE FAILED.";

		new MainView().displayMsg(msg);
	}
}
