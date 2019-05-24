package com.list.controller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.list.model.vo.Employee;
import com.list.model.vo.Person;
import com.list.model.vo.Student;

public class CollectionController {
	public void listTest() {
		//ArrayList list를 구현한 클래스 ~ 배열이랑 비슷함!
		//new 연산자를 통해 객체를 생성해서 사용!
		List list = new ArrayList(); //배열 10개 ==Object[] list= new Object[10];
		list.add("홍길동");
		System.out.println(list.size());
		
		list.add(1); //auto-boxing : int->Integer

		boolean isString = (list.get(0) instanceof String);
		boolean isInt = (list.get(1) instanceof Integer);
		System.out.println(isString);
		System.out.println(isInt);
		
		list.add(180.5);
		list.add(new Person());
		list.add(new Student());

		System.out.println(list);
		
		//중간에 삽입 list.add(index, Object);
		list.add(2, "바바");
		
		System.out.println(list);
		//list.get(index)는 Object를 반환
		//list에 사용자정의 (클래스)가 대입된 경우, 그 객체의 자료형은 Object로 형변환
		//형변환 되어 들어감.(다형성). 실제객체에 접근하려면 그 객체로 형변환하여 접근해야함
		((Person)list.get(4)).getName();

//		List<Person> perList = new ArrayList<Person>();
//		polymorphism can be used!!!
		
		list.remove(2); //인덱스 번호도 앞으로 1씩 당겨짐
		printList(list);
		
		System.out.println(list.isEmpty()); // list에 자료가 있는지 확인
		if(list.size() > 0)
			System.out.println("list.isEmpty()는 false를 return");
//		list.clear();
		System.out.println(list.isEmpty());

		
		//ArrayList의 상속관계를 보면 부모: List인터ㅂ페이스
		List list2 = new ArrayList();
		list2.add(new Employee());
//		Collection list3 = new ArrayList();
		List list3 = new ArrayList();
		
		List list4;
		LinkedList linkedList = new LinkedList();
		list2= linkedList;
		list.add("김태엽");
		
		//list해당 객체가 있는지 확인하는 매소드
		//contains()이용
		System.out.println("비교"+ list.contains("김태엽"));
		System.out.println("비교"+ list.contains("유병승"));

		list.add(new Person("유병승",19,"경기도 시흥시"));
		//사용자 정의 객체를 찾아보자!
		Person com=new Person("유병승",19,"경기도 시흥시");
		//equals 오버라이딩을 시켜줘야함.
		System.out.println("비교"+ list.contains(com));
		
		//sort 정렬
		list3.add("유병승");
		list3.add("박기오");
		list3.add("류별리");
		list3.add("김기호");
		list3.add("서선덕");
		System.out.println(list3);
		//오름차순 정렬
		Collections.sort(list3);
		System.out.println(list3);
		//내림차순 정렬 (using java8 lambda)
		Collections.sort(list3, (i,j)->((String)j).compareTo((String)i));
		System.out.println(list3);

		//중복값 add 허용됨
		list3.add("유병승");
		list3.add("유병승");
		list3.add("유병승");
		list3.add("유병승");
		Student s = new Student("aa", 1, "aa", 1, 1, "aa");
		list3.add(s);
		list3.add(s);
		System.out.println(list3);
		printList(list3);
	}
	
	public void setTest() {
		Set set = new HashSet();
		set.add("김태엽");
		set.add("문은철");
		set.add("서현희");
		set.add("정현빈");
		set.add("김현식");
		set.add("김현식");
		set.add("김현식");
		set.add("김현식");
		set.add("김현식");
		set.add(new Student());
		//Employee는 equals() override 안했으므로, 다른값으로 계속 들어감.
		set.add(new Employee("윤여송", 28, "부천", 10, "개발부", "웹개발자"));
		set.add(new Employee("윤여송", 28, "부천", 10, "개발부", "웹개발자"));
		set.add(new Employee("윤여송", 28, "부천", 10, "개발부", "웹개발자"));
		set.add(new Employee("윤여송", 28, "부천", 10, "개발부", "웹개발자"));
		set.add(new Employee("윤여송", 28, "부천", 10, "개발부", "웹개발자"));

		
		//equals() override 했는데도, 다른 객체들로 인식함
		//hashCode()도 override 해야함!! (주소값)
		//hashCode(){reurn Object.hashCode(name, age,address)
		//3개중 하나만 다르면 다른 주소값 반환

		set.add(new Person("최장원", 26, "용인"));
		set.add(new Person("최장원", 26, "용인"));
		set.add(new Person("최장원", 26, "용인"));
		set.add(new Person("최장원", 26, "용인"));
		set.add(new Person("최장원", 26, "용인"));

//		Set<String> set2 = new HashSet<String> ();
		
		//출력할 때는 Iterator 자동 반복검색기를 사용!
		Iterator itr = set.iterator();
		
		String name = "";
		while(itr.hasNext()) {
//			String s = (String)itr.next();
			//Object ->String
			System.out.println(itr.next());
//			System.out.println(itr.next() instanceof String);
		}
		
		
		/* HashSet을 이용한 List에서의 중복값 제거 */
		List list = new ArrayList();
		list.add("유병승");
		list.add("유병승");
		list.add("유병승");
		list.add("유병승");
		list.add("류별리");
		list.add("류별리");
		list.add("류별리");
		list.add("류별리");
		list.add("류별리");
		list.add("류별리");
		list.add("류별리");
		list.add("김준영");
		list.add("김준영");
		list.add("김준영");
		System.out.println("중복 제거 전: ");
		System.out.println(list);
		set = new HashSet(list);
		list = new ArrayList(set);
		System.out.println("중복 제거 후: ");
		System.out.println(list);

		System.out.println(set.contains("김준영"));
		System.out.println(set.contains("류별리"));
		
		set.remove("김준영");
		System.out.println(set.contains("김준영"));
		System.out.println(set);
	}

	public void mapTest() {
		Map map = new HashMap();
		//map.put(key,value);
		//key, value의 자료형은 Object로 되어 있어, 모든 객체 대입 가능
		map.put(1, new Student());
		map.put(2, "유병승");
		map.put("1", 180.5);
		map.put(1, new Person("유병승", 19, "경기도"));
		/* key값은 통상 String OR Integer형으로 작성 
		 * 한개의 변수의 키값의 자료형은 일치
		 * */
		//출력하는 방법
		//get이용하는방법 get(key값)
//		System.out.println(map.get(1));
//		System.out.println(map.get("1"));
//		System.out.println(map.get("병승"));
		//get으로 출력할 수 있는건?? 내가 key값 을  알고 있을때
		//map 먼저 key값을 출력 entrySet()매소드
		//entrySet() 반환형 Set으로 반환해줌.
		Set set=map.entrySet();
		Iterator it=set.iterator();
		while(it.hasNext()) {
			Object obj=it.next();
			System.out.println(obj+""+ map.get(obj));
		}
		//iterator는 한번 사용하면 재사용이 불가능함.
		//System.out.println(it.next());
		//map은 key값이 중복되지 않습니다.
		map.put("1",new Employee("유병승",19,"경기도 시흥시",1000,"자바학부","강사"));
		System.out.println("===========entrySet============");
		//key, value값을 한번에 보내주는것
		set=map.entrySet();
		it=set.iterator();
		while(it.hasNext()) {
			Map.Entry obj=(Map.Entry)it.next();
			System.out.println(obj.getKey()+" : "+obj.getValue());
		}
		System.out.println("===========keySet============");
		//key값만 받고 처리 하는것
		set=map.keySet();
		it=set.iterator();
		while(it.hasNext()) {
			Object obj=it.next();
			System.out.println(obj+""+ map.get(obj));
		}
	}
	
	
//	Map (key,value) = (String String)
	public void propertiesTest() {
		//파일하고 연결하여 파일에 있는 문자값을 불러오는 객체.
		//test.properties
		Properties prop = new Properties();
		try {
			prop.load(new FileReader("test.properties"));
			System.out.println(prop.get("user"));
			System.out.println(prop.get("pw"));
			prop.setProperty("version", "10");
			prop.store(new FileWriter("test.properties"), "COMMENT");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void printList(List list) {
		//각인덱스값을 출력 get(인덱스)메소드 사용
//		for(int i =0; i<list.size(); i++)
//			System.out.println(list.get(i));

		//list 출력할때는 for-each 문을 자주 사용함.
		for(Object obj : list) {
			if(obj instanceof Person) {
				System.out.println((Person)obj);
			}
			else if(obj instanceof Student) {
				System.out.println((Student)obj);
			}
			else {
				System.out.println(obj);
			}
		}
	}
}
