package board.model.vo;

import java.util.Comparator;
import java.util.Date;

public class DescBoardDate implements Comparator<Board> {

	@Override
	public int compare(Board o1, Board o2) {
		Date d1 = o1.getBoardDate();
		Date d2 = o2.getBoardDate();
		if(d1.before(d2))
			return +1;
		else if(d1.after(d2))
			return -1;
		else 
			return 0;
	}

}
