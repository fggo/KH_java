
--member table
--idx 시퀀스를 이용하여 100부터 1증가하게 하여 부여 primary key 
--member_id varchar2(10) not null
--member_pwd varchar2(10) not null
--member_name varchar2(20) not null
--email varchar2(30)
--address varchar2(100)
--phone varchar2(10)
--enroll_date date

CREATE SEQUENCE seq_idx_member
START WITH 100
INCREMENT BY 1
NOCYCLE
NOCACHE;

CREATE TABLE MEMBER (
    idx NUMBER CONSTRAINT pk_member_idx PRIMARY KEY,
    member_id varchar2(10) CONSTRAINT nn_member_id NOT NULL,
    member_pwd varchar2(10) CONSTRAINT nn_member_pwd NOT NULL,
    member_name varchar2(20) CONSTRAINT nn_member_name NOT NULL,
    email varchar2(30),
    address varchar2(100),
    phone varchar2(10),
    enroll_date date
);

COMMENT ON COLUMN KH.MEMBER.idx IS '부여번호';
COMMENT ON COLUMN KH.MEMBER.member_id IS '아이디';
COMMENT ON COLUMN KH.MEMBER.member_name IS '이름';
COMMENT ON COLUMN KH.MEMBER.email IS '이메일';
COMMENT ON COLUMN KH.MEMBER.address  IS '주소';
COMMENT ON COLUMN KH.MEMBER.phone  IS '폰번호';
COMMENT ON COLUMN KH.MEMBER.enroll_date  IS '등록일';


--board
--idx 시퀀스를 이용 1부터 1증가하여 부여 primary key
--div varchar2(10) '공지' '일반' '비밀' 세개의 값만 넣을수있게 설정
--title varchar2(50) not null
--board_comment varchar2(3000) not null
--writer varchar2(10)
--write_date date 

CREATE SEQUENCE seq_idx_board
START WITH 1
INCREMENT BY 1
NOCYCLE
NOCACHE;

CREATE TABLE BOARD (
    idx NUMBER CONSTRAINT pk_board_idx PRIMARY KEY,
    div VARCHAR2(10) CONSTRAINT chk_div CHECK (div in('공지','일반','비밀')),
    title VARCHAR2(50) CONSTRAINT nn_board_title NOT NULL,
    board_comment VARCHAR2(3000) CONSTRAINT nn_board_comment NOT NULL,
    writer VARCHAR2(10),
    write_date DATE
);

COMMENT ON COLUMN KH.BOARD.idx IS '게시번호';
COMMENT ON COLUMN KH.BOARD.div IS '게시판종류';
COMMENT ON COLUMN KH.BOARD.title IS '제목';
COMMENT ON COLUMN KH.BOARD.board_comment IS '댓글';
COMMENT ON COLUMN KH.BOARD.writer IS '작성자';
COMMENT ON COLUMN KH.BOARD.write_date IS '작성일';

select seq_idx_member.nextval from dual;
select seq_idx_member.currval from dual;

select seq_idx_board.nextval from dual;
select seq_idx_board.currval from dual;


