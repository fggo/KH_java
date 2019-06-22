package ncs.test11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {
	public static void display(List<Integer> list) {
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext())
			System.out.print(itr.next() + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(69);
		list.add(29);
		list.add(41);
		list.add(11);
		list.add(2);
		list.add(77);
		list.add(15);
		list.add(84);
		list.add(98);
		list.add(3);

		System.out.print("정렬 전: ");
		display(list);

		list.sort(new Descending());

		System.out.print("정렬 후: ");
		display(list);
	}

}
