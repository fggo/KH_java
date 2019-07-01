select * from tab where tname like 'TB#_%' ESCAPE '#';

select * from TB_CLASS;
select * from TB_CLASS_PROFESSOR;
select * from TB_DEPARTMENT;
select * from TB_GRADE;
select * from TB_PROFESSOR;
select * from TB_STUDENT;

--DDL
--1
CREATE TABLE tb_category(
    name VARCHAR2(10),
    user_yn CHAR(1) default 'Y'
);

--2
CREATE TABLE tb_class_type(
    no VARCHAR2(5) PRIMARY KEY,
    name VARCHAR2(10)
);

--3
ALTER TABLE tb_category
ADD CONSTRAINT pk_category PRIMARY KEY(name);

--4
ALTER TABLE tb_class_type
MODIFY name VARCHAR2(10) CONSTRAINT nn_name_cons NOT NULL;

--5
ALTER TABLE tb_class_type
MODIFY (no VARCHAR2(10), name VARCHAR2(20));

ALTER TABLE tb_category
MODIFY name VARCHAR2(20);

--6
ALTER TABLE tb_class_type RENAME COLUMN no TO class_type_no;
ALTER TABLE tb_class_type RENAME COLUMN name TO class_type_name;

ALTER TABLE tb_category RENAME COLUMN name TO category_name;
ALTER TABLE tb_category RENAME COLUMN user_yn TO category_user_yn;

select * from tb_class_type;
select * from tb_category;


--7
ALTER TABLE tb_category RENAME CONSTRAINT pk_category TO pk_category_name;
ALTER TABLE tb_class_type RENAME CONSTRAINT sys_c0013231 TO pk_no;

select * from user_constraints
where table_name in ('TB_CLASS_TYPE', 'TB_CATEGORY');

--8
INSERT INTO TB_CATEGORY VALUES ('공학','Y');
INSERT INTO TB_CATEGORY VALUES ('자연과학','Y');
INSERT INTO TB_CATEGORY VALUES ('의학','Y');
INSERT INTO TB_CATEGORY VALUES ('예체능','Y');
INSERT INTO TB_CATEGORY VALUES ('인문사회','Y');
COMMIT;

--9
ALTER TABLE TB_DEPARTMENT
    ADD CONSTRAINT fk_department_category FOREIGN KEY(category)
            REFERENCES TB_CATEGORY(category_name);

select * from user_constraints
where table_name in ('TB_DEPARTMENT', 'TB_CLASS_TYPE', 'TB_CATEGORY');

--10
CREATE OR REPLACE VIEW vw_학생일반정보 AS (
    select student_no AS 학번, student_name 학생이름, student_address AS 주소
    from tb_student);

select * from vw_학생일반정보;

--11
CREATE OR REPLACE VIEW vw_지도면담 AS (
    select student_name 학생이름, department_name 학과이름, professor_name AS 지도교수이름
    from tb_student
        JOIN tb_department USING(department_no)
        LEFT JOIN tb_professor ON (professor_no = coach_professor_no));

select * from vw_지도면담;
drop view vw_지도면담;

--12
CREATE OR REPLACE VIEW vw_학과별학생수 AS (
    select department_name, count(*) AS student_count
    from tb_student JOIN tb_department USING(department_no)
    GROUP BY department_name);

select * from vw_학과별학생수;

--13
UPDATE vw_학생일반정보 SET 학생이름='바바바' where 학번='A213046';
UPDATE vw_학생일반정보 SET 학생이름='서가람' where 학번='A213046';
--서가람->바바바
select * from vw_학생일반정보 where 학번='A213046';
select * from tb_student where student_no = 'A213046';

--14
CREATE OR REPLACE VIEW vw_학생일반정보 AS (
    select student_no AS 학번, student_name 학생이름, student_address AS 주소
    from tb_student) WITH READ ONLY;

--15 ??
select class_no AS 과목번호, class_name AS 과목이름, "누적수강생수(명)"
from (
    select DENSE_RANK() OVER(order by count(*) desc, class_no) AS RANK, class_no, class_name, count(*) AS "누적수강생수(명)"
        from tb_class
            JOIN tb_grade USING (class_no)
        where term_no >= '2006'
        GROUP BY class_no, class_name
        order by count(*) desc, class_no)
where RANK <=3;

select class_no AS 과목번호, class_name AS 과목이름, "누적수강생수(명)"
from (
    select class_no, class_name, count(*) AS "누적수강생수(명)"
        from tb_class
            JOIN tb_grade USING (class_no)
        where term_no >= '2006'
        GROUP BY class_no, class_name
        order by count(*) desc, class_no)
where ROWNUM <=3;


--DML
--1
INSERT INTO tb_class_type VALUES('01', '전공필수');
INSERT INTO tb_class_type VALUES('02', '전공선택');
INSERT INTO tb_class_type VALUES('03', '교양필수');
INSERT INTO tb_class_type VALUES('04', '교양선택');
INSERT INTO tb_class_type VALUES('05', '논문지도');

--2
CREATE TABLE tb_학생일반정보 AS (
    select student_no AS 학번,
           student_name AS 학생이름,
           student_address AS 주소
    from tb_student);

--3
CREATE TABLE tb_국어국문학과 AS (
    select S.student_no AS 학번,
           S.student_name AS 학생이름,
           TO_NUMBER(DECODE(substr(student_ssn,8,1), 1,'19',2,'19','20') ||
               substr(student_ssn,1,2)) AS 출생년도,
           P.professor_name AS 교수이름
    from tb_student S
        JOIN tb_professor P ON professor_no = coach_professor_no
        JOIN tb_department D ON S.department_no = D.department_no
    where D.department_name='국어국문학과');
DROP TABLE tb_국어국문학과;
select * from tb_국어국문학과;
