--sqlplus oracle/system
--create user web identified by web;
--grant resource, connect to web;
SELECT * FROM MEMBER;

--abcde	1234	아무개	M	25	abcde@naver.com	01012345678	서울시 강남구	운동,등산,독서	19/08/16

--DROP TABLE MEMBER;

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
--INSERT INTO MEMBER VALUES ('qwerty','asdf','김말년','F',30,'qwerty@naver.com','01098765432','서울시 관악구','운동,등산',DEFAULT);
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
