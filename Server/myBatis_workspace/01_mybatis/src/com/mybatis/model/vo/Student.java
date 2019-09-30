package com.mybatis.model.vo;

import java.sql.Date;

public class Student {

//  STUDENT_NAME VARCHAR2(30) NOT NULL,
//  STUDENT_TEL CHAR(11) NOT NULL,
//  STUDENT_EMAIL VARCHAR2(50),
//  STUDENT_ADDR VARCHAR2(256),
  private int no;
  private String student_name;
  private String student_tel;
  private String student_email;
  private String student_addr;
  private Date reg_date;

  public Student() {
    // TODO Auto-generated constructor stub
  }

  public Student(int no, String student_name, String student_tel, String student_email, String student_addr,
      Date reg_date) {
    super();
    this.no = no;
    this.student_name = student_name;
    this.student_tel = student_tel;
    this.student_email = student_email;
    this.student_addr = student_addr;
    this.reg_date = reg_date;
  }

  @Override
  public String toString() {
    return "Student [no=" + no + ", student_name=" + student_name + ", student_tel=" + student_tel + ", student_email="
        + student_email + ", student_addr=" + student_addr + ", reg_date=" + reg_date + "]";
  }

  public int getNo() { return no; } 
  public void setNo(int no) { this.no = no; } 
  public String getStudent_name() { return student_name; } 
  public void setStudent_name(String student_name) { this.student_name = student_name; } 
  public String getStudent_tel() { return student_tel; } 
  public void setStudent_tel(String student_tel) { this.student_tel = student_tel; } 
  public String getStudent_email() { return student_email; } 
  public void setStudent_email(String student_email) { this.student_email = student_email; } 
  public String getStudent_addr() { return student_addr; }
  public void setStudent_addr(String student_addr) { this.student_addr = student_addr; } 
  public Date getReg_date() { return reg_date; } 
  public void setReg_date(Date reg_date) { this.reg_date = reg_date; } 
}
