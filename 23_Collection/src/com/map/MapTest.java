package com.map;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import common.compare.StudentSort;

class Main {
	public void mapTest() {
		Map<String, Student> map = new HashMap<String, Student>();
		map.put("1", new Student("유병승", 1, 3, 99));
		map.put("2", new Student("여동규", 2, 3, 83));
		map.put("3", new Student("윤여송", 3, 2, 98));
		map.put("4", new Student("A", 53, 2, 98));
		map.put("5", new Student("B", 13, 2, 98));
		map.put("6", new Student("C", 33, 2, 98));

		System.out.println(((Student)map.get("1")).getName());
		
		//keySet
		System.out.println("===== keySet =====");
		Set<String> keys = map.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String s = (String)it.next();
			System.out.print(((Student)map.get(s)).getName());
			System.out.print(((Student)map.get(s)).getGrade());
			System.out.println(((Student)map.get(s)).getNumber());
		}
		
		//entrySet
		System.out.println("===== entrySet =====");
		Set set = map.entrySet();
		Iterator it1 = set.iterator();
		while(it1.hasNext()) {
			Map.Entry<String, Student> entryMap 
				= (Map.Entry<String, Student>)it1.next();
			System.out.println(entryMap.getKey() + entryMap.getValue());
		}
	}
	
	public void propertiesTest() throws IOException {
		Properties prop = new Properties();
		prop.put("userId", "admin");
		prop.put("userPw", "1234");
		
		//파일 저장
		//파일이 생성되면서 prop이 가지고 있는 key/value 형식의 데이터를 저장!
		prop.store(new FileWriter("user.properties"), "userinfo");
		
		//파일로드
		prop.load(new FileReader("user.properties"));
		System.out.println(prop.getProperty("userId"));
		System.out.println(prop.getProperty("userPw"));
	}
	
	//collection 정령에 대해 알아보자!
	//comparator인터페이스, comparable클래스가 있음
	//이것을 구현해서 정렬을 구현할 수 있음.
	//컬렉션에 대해 정렬을 할때는 Collections객체의 sort라는
	//메소드를 이용하면 됨
	
	public void sortTest() {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("최장원", 1, 1, 90));
		list.add(new Student("김태엽", 3, 20, 25));
		list.add(new Student("전우현", 3, 3, 65));
		list.add(new Student("류별리", 2, 10, 100));
		list.add(new Student("문은철", 4, 5, 60));
		
		for(Student s : list)
			System.out.println(s);

		Collections.sort(list, new StudentSort());

		//lambda
		//클래스 만들지 않고도 쓸수 있음
		Collections.sort(list, (i,j)->{
			Student s1 = (Student)i;
			Student s2 = (Student)j;
			return s1.getGrade() - s2.getGrade();
		});

		Collections.sort(list, (i,j)->{
			return i.getGrade() - j.getGrade();
		});

		for(Object obj : list)
			System.out.println((Student)obj);
		
		
		
		Map<String, Student> map = new HashMap<String, Student>();
		map.put("병승", new Student("aa", 5, 5, 90));
		map.put("준호", new Student("bb", 222, 5, 50));
		map.put("바바", new Student("ca", 225, 25, 20));
		map.put("쿠쿠", new Student("ddaa", 225, 25, 20));
		
		Set<String> keys = map.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) 
			System.out.println(map.get(it.next()).getGrade());
		
		
		Set<Map.Entry<String, Student>> entry
			= map.entrySet();
		Iterator<Map.Entry<String, Student>> it2
			= entry.iterator();
		
		while(it2.hasNext()) {
			System.out.print(it2.next().getKey() + " ");
			System.out.println(it2.next().getValue());
		}

	}
}

public class MapTest {
	public static void main(String[] args) throws IOException {
		new Main().mapTest();
		new Main().propertiesTest();
		new Main().sortTest();
	}
}
