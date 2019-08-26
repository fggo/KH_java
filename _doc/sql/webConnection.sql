--sqlplus oracle/system
--create user web identified by web;
--grant resource, connect to web;


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

--DROP TABLE MEMBER;
--DELETE FROM MEMBER WHERE USERID='admin';
--DELETE FROM MEMBER;

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
--INSERT INTO MEMBER VALUES ('abcde','1234','아무개','M',25,'abcde@naver.com','01012345678','서울시 강남구','운동,등산,독서',DEFAULT);
--INSERT INTO MEMBER VALUES ('asdf','1234','김말년','F',30,'qwerty@naver.com','01098765432','서울시 관악구','운동,등산',DEFAULT);
--INSERT INTO MEMBER VALUES ('admin','1234','관리자','F',33,'admin@naver.com','01012345678','서울시 강남구','독서',DEFAULT);
--INSERT INTO MEMBER VALUES ('dangdang','1234','dang','M',2,'dang@com','111010','경기도','산책',DEFAULT);
--
--UPDATE MEMBER SET password='1ARVn2Auq2/WAqx2gNrL+q3RNjAzXpUfCXrzkA6d4Xa22yhRLy4AC50E+6UTPoscbo31nbOoq51gvkuXzJ6B2w=='
--where userid='admin';
--update member set password='QBsJ6rPAE9TKVJIruAK+yP1TGBkrCnXyAdizcnQpCA+zN1kavT5ERTuVRVW3oIEuEIHDm3QCk/dl6ucx9aZe0Q=='
--where userid='qwerty';
--update member set password='1ARVn2Auq2/WAqx2gNrL+q3RNjAzXpUfCXrzkA6d4Xa22yhRLy4AC50E+6UTPoscbo31nbOoq51gvkuXzJ6B2w=='
--where userid='abcde';
--update member set password='9Du2VRw2a+O15KTtu3OLCsyhPpnVweZa3F0x9TMpxPh82gnMszYpiRFIgVcldByT5pUpdtqgRLJgrSYGM64LFw=='
--where userid='user04';


COMMIT;
