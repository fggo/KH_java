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
select student_no, TO_CHAR(point,'9.99') AS POINT
from tb_student JOIN tb_grade USING(student_no)
where term_no = '200402' and class_no = 'C3118100'
order by point desc, student_no;

--6
select student_no, student_name, department_name
from tb_student JOIN tb_department USING (department_no)
order by student_name;

--7
select class_name, department_name
from tb_department JOIN tb_class USING (department_no)
order by department_name;

--8
select class_name, professor_name
from tb_class_professor
    JOIN tb_class USING (class_no)
    JOIN tb_professor USING (professor_no)
order by professor_name, class_name;

--9
select class_name, professor_name
from tb_class_professor
    JOIN tb_class USING (class_no)
    JOIN tb_professor P USING (professor_no)
    JOIN tb_department D ON D.department_no = P.department_no
where category ='인문사회'
order by professor_name, class_name;

--10
select student_no, student_name, ROUND(avg(point),1) AS 전체평점
from tb_student
    JOIN tb_grade USING (student_no)
    JOIN tb_department USING (department_no)
where department_name ='음악학과'
GROUP BY student_no, student_name
order by ROUND(avg(point),1) desc, student_no;

--11
select department_name, student_name, professor_name
from tb_student S
    JOIN tb_professor P ON coach_professor_no=professor_no
    JOIN tb_department D ON P.department_no = D.department_no
where student_no='A313047';

--12
select student_name, term_no
from tb_student
    JOIN tb_grade USING (student_no)
    JOIN tb_class USING (class_no)
where term_no like '2007%' and class_name='인간관계론'
order by student_name;

--13
select class_name, department_name
from tb_class
    JOIN tb_department USING (department_no)
    LEFT JOIN tb_class_professor USING (class_no)
where category='예체능' and professor_no IS NULL
order by class_name;

select class_name, department_name
from tb_class C
    JOIN tb_department USING (department_no)
where category='예체능'
    and NOT EXISTS(select professor_no from tb_class_professor CP
                    where C.class_no = CP.class_no)
order by class_name;



--Workshop04
--16
select class_no, class_name, TRUNC(avg(point),8)
from tb_class
    JOIN tb_department USING (department_no)
    JOIN tb_grade USING (class_no)
where department_name = '환경조경학과'
GROUP BY class_no, class_name;

--17
select S1.student_name, S1.student_address
from tb_student S1
    JOIN tb_student S2 USING (department_no)
where S2.student_name='최경희';

--18
select student_no, student_name
from
   (select ROWNUM, student_no, student_name, avg(point)
    from tb_student
        JOIN tb_department USING (department_no)
        JOIN tb_grade USING (student_no)
    where department_name='국어국문학과'
    GROUP BY ROWNUM, student_no, student_name
    order by avg(point) desc)
where ROWNUM =1;

--19
select D1.department_name, ROUND(avg(point),1)
from tb_department D1
    JOIN tb_class C ON C.department_no = D1.department_no
    JOIN tb_grade G USING (class_no)
    JOIN tb_department D2 USING (category)
where D2.department_name='환경조경학과'
GROUP BY D1.department_name
order by D1.department_name;

--4
select department_no, capacity from tb_department order by department_no;
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
select S.student_name, G.point
from tb_student S
    JOIN tb_grade G ON S.student_no = G.student_no
    JOIN tb_class C ON C.class_no=  G.class_no
where S.student_name='김명훈'
    and G.term_no ='200501'
    and C.class_name='피부생리학';

UPDATE tb_grade G
SET point = 3.5
where EXISTS (select student_no from tb_student 
                JOIN tb_class C USING (department_no)
                where student_no = G.student_no
                    and C.class_no = G.class_no
                    and C.class_name='피부생리학'
                    and student_name='김명훈')
    and G.term_no='200501';

--8
--  483 rows deleted
select student_no, student_name, absence_yn, G.point
from tb_student S
    JOIN tb_grade G USING (student_no)
where absence_yn ='Y';

DELETE FROM tb_grade G
WHERE EXISTS (select student_name 
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

DESC tb_category;
DESC tb_class_type;
select * from user_constraints where table_name in ('TB_CATEGORY','TB_CLASS_TYPE');
