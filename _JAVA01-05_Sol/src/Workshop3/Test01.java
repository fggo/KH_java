package Workshop3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test01 {
	public static void main(String[] args) {
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		int max =0, min =0;
		for(int i =1 ;i<=6; i++) {
			for(int j=1; j<=6; j++) {
				if(Math.abs(i-j) >=1 && Math.abs(i-j)<=3) {
					max = Math.max(i, j);
					min = Math.min(i, j);
					if(map.get(max) == null) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(min);
						map.put(max, list);
					}
					else if(map.get(max).contains(min))
						continue;
					else if(!map.get(max).contains(min)) {
						map.get(max).add(min);
					}
					System.out.println(max + "-" + min + " = " + (max-min));
				}
			}
		}
	}
}
