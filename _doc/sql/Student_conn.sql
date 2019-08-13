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

insert into member values('admin','admin','어드민','M', 30, 'admin@iei.or.kr', '0101234678','����� ������ ���ﵿ ������� 7','��Ÿ,����,�','16/03/15');
insert into member values('user11','pass11','ȫ�浿','M', 23, 'hong@kh.org', '01017778888','��⵵ ������ �ȴޱ� �ȴ޵� 77','�,���,��Ÿ','17/09/21');
insert into member values('user22','pass22','�Ż��Ӵ�','F', 48, 'shin50@kh.org', '01050005555','������ ������ ������ 5','����,�׸�,�丮','17/05/05');
insert into member values('user77','user77','�̼���','M', 50, 'dltnstls@naver.com', '01021226374','��⵵ �����','����','17/12/08');
insert into member values('lsj','lsj','�̼���','F', 24, 'dltjswn@naver.com', '01021226377','��⵵ �Ȼ��','�,����,��','17/08/25');
insert into member values('seonn','seonn','�����','F', 28, 'study11@naver.com', '01021226312','��⵵ ������','����,å�б�','17/11/08');

COMMENT ON COLUMN MEMBER.member_id IS 'ȸ�����̵�';
COMMENT ON COLUMN MEMBER.member_pwd IS 'ȸ����й�ȣ';
COMMENT ON COLUMN MEMBER.member_name IS 'ȸ���̸�';
COMMENT ON COLUMN MEMBER.gender IS '����';
COMMENT ON COLUMN MEMBER.age IS '����';
COMMENT ON COLUMN MEMBER.email IS '�̸���';
COMMENT ON COLUMN MEMBER.phone IS '��ȭ��ȣ';
COMMENT ON COLUMN MEMBER.address IS '�ּ�';
COMMENT ON COLUMN MEMBER.hobby IS '���';
COMMENT ON COLUMN MEMBER.enroll_date IS '���Գ�¥';

commit;

SELECT * from member;
SELECT * from user_constraints;

