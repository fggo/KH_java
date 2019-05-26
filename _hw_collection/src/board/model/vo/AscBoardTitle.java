package board.model.vo;

import java.util.Comparator;

public class AscBoardTitle implements Comparator<Board> {

	@Override
	public int compare(Board o1, Board o2) {
		String s1 = o1.getBoardTitle();
		String s2 = o2.getBoardTitle();
		
		return s1.compareTo(s2);
	}

}
