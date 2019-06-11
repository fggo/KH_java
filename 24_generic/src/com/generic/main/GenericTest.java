package com.generic.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.generic.model.vo.Person;
import com.generic.model.vo.Student;

public class GenericTest {

	public static void main(String[] args) {

	}
}

class GenericController{
	
	public void genericTest() {
		
		List<Person> list=new ArrayList<Person>();
		list.add(new Person("유병승",19,"경기도 시흥시"));
		list.add(new Person("문은철",32,"서울시"));
		list.add(new Person("서선덕",20,"경기도 오산시"));
		list.add(new Person("정현빈",21,"서울시"));
		list.add(new Person("남태관",28,"서울시"));
		//list.add("안돼!");
		
		for(Person p: list) {
			System.out.println(p);
		}
		System.out.println(list.get(0).getName());
		//map에 대한 제네릭 선언
		Map<String, Person> persons=new HashMap<String, Person>();
		
		persons.put("병승",new Person("김기호", 26,"부모님집"));
		persons.put("기호",new Person("박기오", 27,"분당"));
		persons.put("기오",new Person("여동규", 27,"자취"));
		//persons.put(1,new Person("여동규", 27,"자취"));
		
		persons.get("병승").getName();
		
		Set<String> keys=persons.keySet();
		Iterator<String> it=keys.iterator();
		while(it.hasNext()) {
			System.out.println(persons.get(it.next()).getName());
		}
		
		Set<Map.Entry<String, Person>> entry=persons.entrySet();
		Iterator<Map.Entry<String, Person>> it2=entry.iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next().getValue());
		}
		
	}
	
}

