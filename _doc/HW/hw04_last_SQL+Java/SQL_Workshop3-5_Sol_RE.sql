--Workshop03
SELECT * FROM tab WHERE tname like 'TB#_%' ESCAPE '#';
SELECT * FROM TB_CLASS;
SELECT * FROM TB_CLASS_PROFESSOR;
SELECT * FROM TB_DEPARTMENT;
SELECT * FROM TB_GRADE;
SELECT * FROM TB_PROFESSOR;
SELECT * FROM TB_STUDENT;

--1
SELECT student_name, student_address FROM tb_student
ORDER BY student_name;

--2
SELECT student_name, student_ssn FROM tb_student
WHERE absence_yn='Y'
ORDER BY student_ssn DESC;


--3
SELECT student_name, student_no, student_address
FROM tb_student
WHERE student_no like '9%'
    AND student_address like '%경기도%' OR
        student_address like '%강원도%'
ORDER BY student_name;

--4
SELECT professor_name, professor_ssn
FROM tb_professor JOIN tb_department USING (department_no)
WHERE department_name ='법학과'
ORDER BY professor_ssn;

--5
SELECT student_no, TO_CHAR(point,'9.99') AS POINT
from tb_student JOIN tb_grade USING(student_no)
where term_no = '200402' and class_no = 'C3118100'
order by point desc, student_no;

--6
SELECT student_no, student_name, department_name
from tb_student JOIN tb_department USING (department_no)
order by student_name;

--7
SELECT class_name, department_name
from tb_department JOIN tb_class USING (department_no)
order by department_name;

--8
SELECT class_name, professor_name
from tb_class_professor
    JOIN tb_class USING (class_no)
    JOIN tb_professor USING (professor_no)
order by professor_name, class_name;

--9
SELECT class_name, professor_name
from tb_class_professor
    JOIN tb_class USING (class_no)
    JOIN tb_professor P USING (professor_no)
    JOIN tb_department D ON D.department_no = P.department_no
where category ='인문사회'
order by professor_name, class_name;

--10
SELECT student_no, student_name, ROUND(avg(point),1) AS 전체평점
from tb_student
    JOIN tb_grade USING (student_no)
    JOIN tb_department USING (department_no)
where department_name ='음악학과'
GROUP BY student_no, student_name
order by ROUND(avg(point),1) desc, student_no;

--11
SELECT department_name, student_name, professor_name
from tb_student S
    JOIN tb_professor P ON coach_professor_no=professor_no
    JOIN tb_department D ON P.department_no = D.department_no
where student_no='A313047';

--12
SELECT student_name, term_no
from tb_student
    JOIN tb_grade USING (student_no)
    JOIN tb_class USING (class_no)
where term_no like '2007%' and class_name='인간관계론'
order by student_name;

--13
SELECT class_name, department_name
from tb_class
    JOIN tb_department USING (department_no)
    LEFT JOIN tb_class_professor USING (class_no)
where category='예체능' and professor_no IS NULL
order by class_name;

SELECT class_name, department_name
from tb_class C
    JOIN tb_department USING (department_no)
where category='예체능'
    and NOT EXISTS(SELECT professor_no from tb_class_professor CP
                    where C.class_no = CP.class_no)
order by class_name;



--Workshop04
--16
SELECT class_no, class_name, TRUNC(avg(point),8)
from tb_class
    JOIN tb_department USING (department_no)
    JOIN tb_grade USING (class_no)
where department_name = '환경조경학과'
GROUP BY class_no, class_name;

--17
SELECT S1.student_name, S1.student_address
from tb_student S1
    JOIN tb_student S2 USING (department_no)
where S2.student_name='최경희';

--18
SELECT student_no, student_name
from
   (SELECT ROWNUM, student_no, student_name, avg(point)
    from tb_student
        JOIN tb_department USING (department_no)
        JOIN tb_grade USING (student_no)
    where department_name='국어국문학과'
    GROUP BY ROWNUM, student_no, student_name
    order by avg(point) desc)
where ROWNUM =1;

--19
SELECT D1.department_name, ROUND(avg(point),1)
from tb_department D1
    JOIN tb_class C ON C.department_no = D1.department_no
    JOIN tb_grade G USING (class_no)
    JOIN tb_department D2 USING (category)
where D2.department_name='환경조경학과'
GROUP BY D1.department_name
order by D1.department_name;

--4
SELECT department_no, capacity from tb_department order by department_no;
UPDATE tb_department
SET capacity = ROUND(capacity*1.1);

--5
UPDATE tb_student
SET student_address = "서울시 종로구 숭인동 181-21"
where student_no = 'A413042';

--6
UPDATE tb_student
SET student_ssn = substr(student_ssn,1,6);

--7
SELECT S.student_name, G.point
from tb_student S
    JOIN tb_grade G ON S.student_no = G.student_no
    JOIN tb_class C ON C.class_no=  G.class_no
where S.student_name='김명훈'
    and G.term_no ='200501'
    and C.class_name='피부생리학';

UPDATE tb_grade G
SET point = 3.5
where EXISTS (SELECT student_no from tb_student 
                JOIN tb_class C USING (department_no)
                where student_no = G.student_no
                    and C.class_no = G.class_no
                    and C.class_name='피부생리학'
                    and student_name='김명훈')
    and G.term_no='200501';

--8
--  483 rows deleted
SELECT student_no, student_name, absence_yn, G.point
from tb_student S
    JOIN tb_grade G USING (student_no)
where absence_yn ='Y';

DELETE FROM tb_grade G
WHERE EXISTS (SELECT student_name 
                from tb_student S
                where S.student_no = G.student_no
                    and absence_yn = 'Y');
commit;
rollback;



--Workshop05
--1
CREATE TABLE tb_category(
    name VARCHAR2(10),
    use_yn CHAR(1) DEFAULT 'Y'
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
MODIFY name VARCHAR2(5) CONSTRAINT nn_name_cons NOT NULL;

--5
-- no VARCHAR2(10), name VARCHAR2(20)
ALTER TABLE tb_category
MODIFY name VARCHAR2(20);

ALTER TABLE tb_class_type
MODIFY (no VARCHAR2(10), name VARCHAR2(20));

--6
ALTER TABLE tb_category RENAME COLUMN name TO category_name;
ALTER TABLE tb_category RENAME COLUMN use_yn TO category_use_yn;

ALTER TABLE tb_class_type RENAME COLUMN no TO class_type_no;
ALTER TABLE tb_class_type RENAME COLUMN name TO class_type_name;

--7
ALTER TABLE tb_category RENAME CONSTRAINT pk_category TO pk_category_name;
ALTER TABLE tb_class_type RENAME CONSTRAINT SYS_C007058 TO pk_no;

COMMIT;

--8
INSERT INTO TB_CATEGORY VALUES ('공학','Y');
INSERT INTO TB_CATEGORY VALUES ('자연과학','Y'); INSERT INTO TB_CATEGORY VALUES ('의학','Y');
INSERT INTO TB_CATEGORY VALUES ('예체능','Y');
INSERT INTO TB_CATEGORY VALUES ('인문사회','Y');

SELECT * from tb_category;
SELECT * from tb_class_type;

--9
ALTER TABLE tb_department
ADD CONSTRAINT fk_department_category FOREIGN KEY(category)
    REFERENCES tb_category(category_name);

DESC tb_category;
DESC tb_class_type;
SELECT * from user_constraints where table_name in ('TB_CATEGORY','TB_CLASS_TYPE', 'TB_DEPARTMENT');

--10
--CONN SYSTEM/ORACLE1
--GRANT CREATE VIEW TO KH;
CREATE OR REPLACE VIEW vw_학생일반정보 AS (
    select student_no, student_name, student_address
    from tb_student
);
SELECT * from vw_학생일반정보;

--11
CREATE OR REPLACE VIEW vw_지도면담 AS (
    SELECT student_name, department_name, professor_name
    FROM tb_student
        JOIN tb_department USING (department_no)
        LEFT JOIN tb_professor ON professor_no = coach_professor_no
);

SELECT * from vw_지도면담;

--12
CREATE OR REPLACE VIEW vw_학과별학생수 AS (
    select department_name, count(*) AS student_count
    from tb_student
        JOIN tb_department USING (department_no)
    GROUP BY department_name);

SELECT * FROM vw_학과별학생수;

--13
UPDATE vw_학생일반정보 SET student_name = '바바바' WHERE student_no='A213046';
UPDATE vw_학생일반정보 SET student_name = '서가람' WHERE student_no='A213046';

--서가람->바바바
select * from vw_학생일반정보 where student_no='A213046';
select * from tb_student where student_no = 'A213046';

COMMIT;
ROLLBACK;

--14
CREATE OR REPLACE VIEW vw_학생일반정보 AS (
        select student_no, student_name, student_address
        from tb_student)
WITH READ ONLY;

--15 ??
SELECT class_no, class_name, "누적수강생수(명)"
FROM (
    SELECT class_no, class_name, count(*) AS "누적수강생수(명)"
    from tb_class
        JOIN tb_grade USING (class_no)
    where term_no >= '2006'
    GROUP BY class_no, class_name
    order by count(*) DESC, class_no)
WHERE ROWNUM <=3;

select class_no AS 과목번호, class_name AS 과목이름, "누적수강생수(명)"
from (
    select DENSE_RANK() OVER(order by count(*) desc, class_no) AS RANK, class_no, class_name, count(*) AS "누적수강생수(명)"
        from tb_class
            JOIN tb_grade USING (class_no)
        where term_no >= '2006'
        GROUP BY class_no, class_name
        order by count(*) desc, class_no)
where RANK <=3;

--DML
--1
INSERT INTO tb_class_type VALUES('01', '전공필수');
INSERT INTO tb_class_type VALUES('02', '전공선택');
INSERT INTO tb_class_type VALUES('03', '교양필수');
INSERT INTO tb_class_type VALUES('04', '교양선택');
INSERT INTO tb_class_type VALUES('05', '논문지도');

SELECT * from tb_class_type;

--2
CREATE TABLE tb_학생일반정보 AS(
    select student_id, student_name, student_address
        from tb_student);

--3
CREATE TABLE tb_국어국문학과 AS (
    SELECT student_no, student_name,
           DECODE(substr(student_ssn,8,1), 1, '19', 2, '19', '20') || substr(student_ssn,1,2) AS 출생년도,
           professor_name
    FROM tb_student S
        JOIN tb_professor ON professor_no = coach_professor_no
        JOIN tb_department D ON S.department_no = D.department_no
    WHERE department_name='국어국문학과');

SELECT * from tb_국어국문학과;
DROP TABLE tb_국어국문학과;
