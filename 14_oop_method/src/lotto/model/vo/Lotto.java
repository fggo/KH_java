package lotto.model.vo;

public class Lotto {
	private final static int MAX_CNT = 6;
	private int[] lotto = new int[MAX_CNT];
	
	//초기화 블록
	{
		int count = 0;
		int lottoNum = 0;
		boolean duplicate = false;
		do {
			lottoNum = (int)(Math.random()*45+1);
			for(int i =0; i<count; i++) {
				if (lottoNum == lotto[i]) {
					duplicate = true;
					break;
				}
			}
			if(duplicate)
				duplicate = false;
			else
				lotto[count++] = lottoNum;
		}while(count < Lotto.getMaxCnt());
	}
	
	public Lotto() {}

	public static int getMaxCnt() { return MAX_CNT; }

	public void information() {
		for(int i =0; i<Lotto.getMaxCnt(); i++) {
			System.out.print(lotto[i] + " ");
			if(i == Lotto.getMaxCnt() - 1)
				System.out.println();
		}
	}
}
