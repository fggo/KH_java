package board.model.vo;

import java.util.Comparator;

public class AscBoardNo implements Comparator<Board> {

	@Override
	public int compare(Board o1, Board o2) {
		int n1 = o1.getBoardNo();
		int n2 = o2.getBoardNo();
		
		if(n1<n2)
			return -1;
		else if (n1 > n2)
			return +1;
		else 
			return 0;
	}

}
