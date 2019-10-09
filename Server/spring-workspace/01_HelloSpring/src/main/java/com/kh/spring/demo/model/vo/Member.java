package com.kh.spring.demo.model.vo;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;

//@Setter
//@Getter
@NoArgsConstructor // 기본생성자도 추가
@Data
/**
 * @author foo
 * 1.기본적인 member변수에 대한 setter/getter 자동생성
 * 2.매개변수가 있는 생성자
 * 3.toString
 * 4.equals
 * 5.hashcode까지 다 만들어 줌
 */
public class Member {
  private String userId;
  private String password;
  private String userName;
  private String gender;
  private int age;
  private String email;
  private String phone;
  private String address;
  private String hobby;
  private Date date;

}
