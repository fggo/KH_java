package com.kh.spring.board.model.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class Attachment {
//  ATTACHMENTNO NUMBER PRIMARY KEY,
//  BOARDNO NUMBER NOT NULL,
//  ORIGINALFILENAME VARCHAR2(255) NOT NULL,
//  RENAMEDFILENAME VARCHAR2(255) NOT NULL,
//  UPLOADDATE DATE DEFAULT SYSDATE,
//  DOWNLOADCOUNT NUMBER DEFAULT 0,
//  STATUS VARCHAR2(1) DEFAULT 'Y',
//  CONSTRAINT FK_BOARDNO FOREIGN KEY(BOARDNO) REFERENCES BOARD(BOARDNO) ON DELETE CASCADE
//);
  private int attachmentNo;
  private int boardNo;
  private String originalFileName;
  private String renamedFileName;
  private Date uploadDate;
  private int downloadCount;
  private String status;
}
