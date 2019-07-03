--JDBC

--  SQLPLUS system/oracle
CREATE USER student identified by student;
GRANT RESOURCE TO student;
GRANT CONNECT TO student;


CREATE TABLE MEMBER(
    member_id VARCHAR2(15) CONSTRAINT pk_member_id PRIMARY KEY,
    member_pwd VARCHAR2(15) CONSTRAINT nn_member_pwd NOT NULL,
    member_name VARCHAR2(20) CONSTRAINT nn_member_name NOT NULL,
    gender CHAR(1) CONSTRAINT chk_member_gender CHECK (gender in('M','F')),
    age NUMBER CONSTRAINT nn_member_age NOT NULL,
    email VARCHAR2(30),
    phone CHAR(11),
    address VARCHAR2(500),
    hobby VARCHAR2(50),
    enroll_date DATE DEFAULT SYSDATE
);

insert into member values('admin','admin','관리자','M', 30, 'admin@iei.or.kr', '0101234678','서울시 강남구 역삼동 테헤란로 7','기타,독서,운동','16/03/15');
insert into member values('user11','pass11','홍길동','M', 23, 'hong@kh.org', '01017778888','경기도 수원시 팔달구 팔달동 77','운동,등산,기타','17/09/21');
insert into member values('user22','pass22','신사임당','F', 48, 'shin50@kh.org', '01050005555','강원도 강릉시 오죽헌 5','독서,그림,요리','17/05/05');
insert into member values('user77','user77','이순신','M', 50, 'dltnstls@naver.com', '01021226374','경기도 시흥시','음악','17/12/08');
insert into member values('lsj','lsj','이선주','F', 24, 'dltjswn@naver.com', '01021226377','경기도 안산시','운동,음악,댄스','17/08/25');
insert into member values('seonn','seonn','김공부','F', 28, 'study11@naver.com', '01021226312','경기도 성남시','공부,책읽기','17/11/08');

COMMENT ON COLUMN MEMBER.member_id IS '회원아이디';
COMMENT ON COLUMN MEMBER.member_pwd IS '회원비밀번호';
COMMENT ON COLUMN MEMBER.member_name IS '회원이름';
COMMENT ON COLUMN MEMBER.gender IS '성별';
COMMENT ON COLUMN MEMBER.age IS '나이';
COMMENT ON COLUMN MEMBER.email IS '이메일';
COMMENT ON COLUMN MEMBER.phone IS '전화번호';
COMMENT ON COLUMN MEMBER.address IS '주소';
COMMENT ON COLUMN MEMBER.hobby IS '취미';
COMMENT ON COLUMN MEMBER.enroll_date IS '가입날짜';


SELECT * from member;
SELECT * from user_constraints;
