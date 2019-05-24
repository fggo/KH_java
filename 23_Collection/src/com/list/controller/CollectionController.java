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
		List<Object> list = new ArrayList<Object>(); //배열 10개 ==Object[] list= new Object[10];
		list.add("홍길동");
		list.add(1); //auto-boxing : int->Integer
		list.add(180.5);
		list.add(new Person());
		list.add(new Student());
		list.add(new Employee());
		list.add(2, "바바"); //중간에 삽입 list.add(index, Object);

		for(int i =0; i<list.size(); i++) {
			if(list.get(i) instanceof String)
				System.out.println("list.get(" +i+") = " + list.get(i) + " is a String");
			else if (list.get(i) instanceof Integer)
				System.out.println("list.get(" +i+") = " + list.get(i) + " is an Integer");
			else if(list.get(i) instanceof Student)
				System.out.println("list.get(" +i+") = " + list.get(i) + " is an instance"
						+ " of Student");
			else if(list.get(i) instanceof Employee)
				System.out.println("list.get(" +i+") = " + list.get(i) + " is an instance"
						+ " of Employee");
		}
			
		System.out.println(list.size());
		this.printList(list);
		
		//list.get(index) Object 반환, list에 사용자정의 (클래스)가 대입된 경우,
		//그 객체의 자료형은 Object로 형변환되어 들어감.접근하려면 그 객체로 형변환하여 접근해야함(다형성)
		((Person)list.get(4)).getName(); //Student
		
		list.remove(2); //인덱스 번호도 앞으로 1씩 당겨짐
		
//		list.clear();
		if(list.isEmpty())
			System.out.println("리스트는 비어있습니다.");
		else
			System.out.println("리스트는 비어있지 않습니다.");

		if(list.size() > 0)
			System.out.println("list.isEmpty()는 false를 return");

		//ArrayList는 부모 인터페이스 List를 상속
		List<Object> list2 = new ArrayList<Object>();
		List list3 = new ArrayList(); //Collection list3 = new ArrayList();
		List<Object> list4;

		list2.add(new Employee());

		LinkedList<Object> linkedList = new LinkedList<Object>();
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
		Collections.sort(list3); //오름차순 정렬
		System.out.println(list3);
		Collections.sort(list3, (i,j)->((String)j).compareTo((String)i));
		System.out.println(list3); //내림차순 정렬 (java8 lambda)

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
		set.add("김태엽"); //String의 equals() 조건 만족하므로 중복해서 안들어감
		set.add("문은철");
		set.add("서현희");
		set.add("정현빈");
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
		//hashCode(){reurn Object.hashCode(name, age,address)}
		//3개중 하나만 다르면 다른 주소값 반환
		set.add(new Person("최장원", 26, "용인"));
		set.add(new Person("최장원", 26, "용인"));
		set.add(new Person("최장원", 26, "인"));
		set.add(new Person("최장원", 26, "용인"));
		set.add(new Person("최장원", 26, "용인"));

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
		System.out.println(map.get(1));
		System.out.println(map.get("1"));
		System.out.println(map.get("병승")); //null
		//get으로 출력할 수 있는건?? 내가 key값 을  알고 있을때
		//map 먼저 key값을 출력 entrySet()매소드
		//entrySet() 반환형 Set으로 반환해줌.
		//map은 key값이 중복되지 않습니다.(기존 key-value를 덮어씀)
		map.put("1",new Employee("유병승",19,"경기도 시흥시",1000,"자바학부","강사"));
		System.out.println("===========entrySet============");
		Set set=map.entrySet();
		Iterator it=set.iterator();
		//key, value값을 한번에 보내주는것
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
			System.out.println(obj+" "+ map.get(obj));
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
		System.out.println();
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
			else if(obj instanceof Employee) {
				System.out.println((Employee)obj);
			}
			else {
				System.out.println(obj);
			}
		}
		System.out.println();
	}
}
