package com.mybatis.model.vo;

import java.sql.Date;

public class Student2 {

  private int studentNo;
  private String studentName;
  private String studentTel;
  private String studentEmail;
  private String studentAddr;
  private Date studentRegDate;

  public Student2() {
    // TODO Auto-generated constructor stub
  }

  public Student2(int studentNo, String studentName, String studentTel, String studentEmail, String studentAddr, Date studentRegDate) {
    super();
    this.studentNo = studentNo;
    this.studentName = studentName;
    this.studentTel = studentTel;
    this.studentEmail = studentEmail;
    this.studentAddr = studentAddr;
    this.studentRegDate = studentRegDate;
  }
  
  @Override
  public String toString() {
    return "Student [studentNo=" + studentNo + ", studentName=" + studentName + ", studentTel=" + studentTel
        + ", studentEmail=" + studentEmail + ", studentAddr=" + studentAddr + ", studentRegDate=" + studentRegDate
        + "]";
  }

  public String getStudentName() { return studentName; }
  public void setStudentName(String studentName) { this.studentName = studentName; }
  public String getStudentTel() { return studentTel; }
  public void setStudentTel(String studentTel) { this.studentTel = studentTel; }
  public String getStudentEmail() { return studentEmail; }
  public void setStudentEmail(String studentEmail) { this.studentEmail = studentEmail; }
  public String getStudentAddr() { return studentAddr; }
  public void setStudentAddr(String studentAddr) { this.studentAddr = studentAddr; } 
  public int getStudentNo() { return studentNo; } 
  public void setStudentNo(int studentNo) { this.studentNo = studentNo; } 
  public Date getStudentRegDate() { return studentRegDate; } 
  public void setStudentRegDate(Date studentRegDate) { this.studentRegDate = studentRegDate; } 
}
