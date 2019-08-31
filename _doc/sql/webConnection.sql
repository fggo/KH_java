--sqlplus oracle/system
--create user web identified by web;
--grant resource, connect to web;

select * from member;
select * from member where userid='admin';
select * from board;
select * from board_comment;
--update board set board_original_filename='chris-leipelt-176595.jpg' where board_writer='admin';
--          board_ref & board_comment_No=" + $(this).val();
--delete from board_comment where board_ref=? and board_comment_no=?

select * from notice;
select count(*) as cnt from board;
select * from tab;
commit;
--drop table board;
--drop sequence SEQ_BOARD_NO;
--drop table notice;
--drop sequence SEQ_NOTICE_NO;
--DROP TABLE MEMBER;

select * from (select rownum as rnum, a.* from 
                (select * from board order by board_date desc) a) 
             where rnum between 1 and 5;

select * from board_comment;
-- 계층형 쿼리!
select lpad('  ', (level-1)*5) || board_comment_content, a.*
  from board_comment a
where board_ref=34
start with board_comment_level=1
connect by prior board_comment_no=board_comment_ref
order siblings by board_comment_date desc;

select * from board_comment
where board_ref=27
start with board_comment_level=1
connect by prior board_comment_no=board_comment_ref;

select * from notice;
select seq_notice_no.nextval from dual;
select seq_notice_no.currval from dual;
--drop table notice;
--drop sequence SEQ_NOTICE_NO;
--DROP TABLE BOARD_COMMENT;
--DROP SEQUENCE SEQ_BOARD_COMMENT_NO;

CREATE TABLE BOARD_COMMENT(
    "BOARD_COMMENT_NO" NUMBER,
    "BOARD_COMMENT_LEVEL" NUMBER DEFAULT 1,
    "BOARD_COMMENT_WRITER" VARCHAR2(15), 
    "BOARD_COMMENT_CONTENT" VARCHAR2(2000), 
    "BOARD_REF" NUMBER, --PK
    "BOARD_COMMENT_REF" NUMBER, --referring PK(above 1 level) --FK 2개(board, board_comment를 참조함)
    --board_comment_ref가 없으면 댓글 / 있으면 답글(댓글에 대한 댓글)
    "BOARD_COMMENT_DATE" DATE DEFAULT SYSDATE, 
    CONSTRAINT PK_BOARD_COMMENT_NO PRIMARY KEY(BOARD_COMMENT_NO),
    CONSTRAINT FK_BOARD_COMMENT_WRITER FOREIGN KEY(BOARD_COMMENT_WRITER) REFERENCES MEMBER(USERID) ON DELETE SET NULL,
    CONSTRAINT FK_BOARD_REF FOREIGN KEY(BOARD_REF) REFERENCES BOARD(BOARD_NO) ON DELETE CASCADE,
    CONSTRAINT FK_BOARD_COMMENT_REF FOREIGN KEY(BOARD_COMMENT_REF) REFERENCES BOARD_COMMENT(BOARD_COMMENT_NO) ON DELETE CASCADE
);
       COMMENT ON COLUMN BOARD_COMMENT.BOARD_COMMENT_NO IS '게시판댓글번호';
    COMMENT ON COLUMN BOARD_COMMENT.BOARD_COMMENT_LEVEL IS '게시판댓글 레벨';
    COMMENT ON COLUMN BOARD_COMMENT.BOARD_COMMENT_WRITER IS '게시판댓글 작성자';
    COMMENT ON COLUMN BOARD_COMMENT.BOARD_COMMENT_CONTENT IS '게시판댓글';
    COMMENT ON COLUMN BOARD_COMMENT.BOARD_REF IS '참조원글번호';
    COMMENT ON COLUMN BOARD_COMMENT.BOARD_COMMENT_REF IS '게시판댓글 참조번호';
    COMMENT ON COLUMN BOARD_COMMENT.BOARD_COMMENT_DATE IS '게시판댓글 작성일';
    
     CREATE SEQUENCE SEQ_BOARD_COMMENT_NO
    START WITH 1
    INCREMENT BY 1
    NOMINVALUE
    NOMAXVALUE
    NOCYCLE
    NOCACHE;
    
CREATE TABLE BOARD (   
      "BOARD_NO" NUMBER, 
      "BOARD_TITLE" VARCHAR2(50), 
      "BOARD_WRITER" VARCHAR2(15), 
      "BOARD_CONTENT" VARCHAR2(2000), 
      "BOARD_ORIGINAL_FILENAME" VARCHAR2(100), 
      "BOARD_RENAMED_FILENAME" VARCHAR2(100), 
      "BOARD_DATE" DATE DEFAULT SYSDATE, 
      "BOARD_READCOUNT" NUMBER DEFAULT 0, 
      CONSTRAINT PK_BOARD_NO PRIMARY KEY(BOARD_NO),
      CONSTRAINT FK_BOARD_WRITER FOREIGN KEY(BOARD_WRITER) REFERENCES MEMBER(USERID) ON DELETE SET NULL
   );
   COMMENT ON COLUMN "BOARD"."BOARD_NO" IS '게시글번호';
   COMMENT ON COLUMN "BOARD"."BOARD_TITLE" IS '게시글제목';
   COMMENT ON COLUMN "BOARD"."BOARD_WRITER" IS '게시글작성자 아이디';
   COMMENT ON COLUMN "BOARD"."BOARD_CONTENT" IS '게시글내용';
   COMMENT ON COLUMN "BOARD"."BOARD_ORIGINAL_FILENAME" IS '첨부파일원래이름';
   COMMENT ON COLUMN "BOARD"."BOARD_RENAMED_FILENAME" IS '첨부파일변경이름';
   COMMENT ON COLUMN "BOARD"."BOARD_DATE" IS '게시글올린날짜';
   COMMENT ON COLUMN "BOARD"."BOARD_READCOUNT" IS '조회수';

   --게시판시퀀스생성
   CREATE SEQUENCE SEQ_BOARD_NO
   START WITH 1
   INCREMENT BY 1
   NOMINVALUE
   NOMAXVALUE
   NOCYCLE
   NOCACHE;

CREATE TABLE NOTICE(
        NOTICE_NO NUMBER PRIMARY KEY,
        NOTICE_TITLE VARCHAR2(100) NOT NULL,
        NOTICE_WRITER VARCHAR2(15) NOT NULL,
        NOTICE_CONTENT VARCHAR2(4000) NOT NULL,
        NOTICE_DATE DATE DEFAULT SYSDATE,
        FILEPATH VARCHAR2(300),
        STATUS VARCHAR2(1) DEFAULT 'Y',
        constraint fk_notice_writer FOREIGN KEY (NOTICE_WRITER) REFERENCES MEMBER (USERID)
    );

CREATE SEQUENCE SEQ_NOTICE_NO;
INSERT INTO NOTICE VALUES(SEQ_NOTICE_NO.NEXTVAL,'공지사항테스트','admin','공지사항테스트입니다',default,null,default);
INSERT INTO NOTICE VALUES(SEQ_NOTICE_NO.NEXTVAL,'회식공지','admin','7/11일 수료후 전체회식입니다.',default,null,default);
INSERT INTO NOTICE VALUES(SEQ_NOTICE_NO.NEXTVAL,'라라라','admin','테스트 공지', default, 'testfilepath', default);

COMMIT;
--페이징 처리!!!
select * from member;
--순서를 정한 query문 작성하기!
--rownum! from 이 정해지는 순간 row에 번호를 부여.
select ROWNUM, a.* from member a
  where ROWNUM between 1 and 5;

select ROWNUM, a.* from member a --안나옴!!!
  where ROWNUM between 6 and 10; --start가 1보다 클때


--SOL
SELECT * FROM (
  SELECT ROWNUM AS RNUM, A.* FROM MEMBER A)
WHERE RNUM BETWEEN 6 AND 10;

--순서를 정렬 했을 때 문제 발생! rNum 뒤죽박죽
--NOT WORKING
SELECT * FROM (
  SELECT ROWNUM AS RNUM, A.* FROM MEMBER A ORDER BY AGE);

--OK!
select rownum, a.* from (
  select * from member order by age)a;


--안나옴
select rownum, a.* from (
  select * from member order by age)a
where rnum between 11 and 20;

--OK!
select *
  from ( select rownum as rnum, a.* from (
          select * from member order by age)a)
        where rnum between 11 and 20;


SELECT * FROM MEMBER;
--abcde	1234	아무개	M	25	abcde@naver.com	01012345678	서울시 강남구	운동,등산,독서	19/08/16

CREATE TABLE MEMBER(
   USERID VARCHAR2(30) PRIMARY KEY
   ,PASSWORD VARCHAR2(300) NOT NULL
   ,USERNAME  VARCHAR2(50) NOT NULL
   ,GENDER CHAR(1) CHECK (GENDER IN ('M','F'))
   ,AGE NUMBER
   ,EMAIL VARCHAR2(30)
   ,PHONE CHAR(11)  NOT NULL
   ,ADDRESS VARCHAR2(100)
   ,HOBBY VARCHAR2(80)
   ,ENROLLDATE DATE DEFAULT SYSDATE
);

COMMIT;
